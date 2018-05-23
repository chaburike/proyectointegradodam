package spring.pintura.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import spring.pintura.constant.ViewConstant;
import spring.pintura.entity.*;
import spring.pintura.repository.MaterialQueryDslRepository;
import spring.pintura.service.impl.MaterialServiceImpl;

@Controller
@RequestMapping("/materiales")
public class MaterialesController {
	
	private static final Log LOG = LogFactory.getLog(MaterialesController.class);
	
	@Autowired
	@Qualifier("MaterialService")
	private MaterialServiceImpl materialService;
	
	@Autowired
	@Qualifier("materialesQueryDslRepository")
	private MaterialQueryDslRepository materialQuery;

		/** The application context. */
	// Realizamos una inyección de dependencias especifica que usaremos para el
	// Jasper
	@Autowired
	private ApplicationContext applicationContext;
	
	@GetMapping("/listMateriales")
	public ModelAndView listAllMateriales() {
		LOG.info("Call "+" listAllMateriales()");
		ModelAndView mav = new ModelAndView(ViewConstant.Materiales);
		mav.addObject("material", new Materiales());
		mav.addObject("materiales", materialService.listAllMateriales());
		return mav;
	}
	
	
	@GetMapping("/showmateriales")
	public String showMateriales() {
		return ViewConstant.Materiales;
	}
	
	@PostMapping("/addMateriales")
	public String addMateriales(@ModelAttribute("material") Materiales material) {
		LOG.info("Call: "+" addMateriales()"+material);
		LOG.info("este es el objeto MATERIAL que estoy modificando "+material.toString());
		materialService.addMateriales(material);
		return "redirect:/materiales/listMateriales";
		
	}
	
	@GetMapping("/removeMateriales")
	public String removeMateriales(@RequestParam(name="idMateriales", required=true) int idMateriales) {
		LOG.info("Call: "+" removeMateriales()"+ idMateriales);
		materialService.removeMateriales(idMateriales);
		return "redirect:/materiales/listMateriales";
	}
	
	@GetMapping("/listMaterialesUpdate")
	public ModelAndView listMaterialesUpdate(@RequestParam(name="idMateriales", required = false) int idMateriales) {
		Materiales materialMod=new Materiales();
		LOG.info("idMateriales: " +idMateriales);
		materialMod=materialService.findMaterialByIdMaterial(idMateriales);
		LOG.info("call: "+"listMaterialesUpdate()"+materialMod.toString());
		ModelAndView mav=new ModelAndView(ViewConstant.Materiales);
		mav.addObject("material", materialMod);
		mav.addObject("materiales", materialService.listAllMateriales());
		return mav;
	}

	

	
	@GetMapping("/searchMateriales")
	private ModelAndView searchMateriales(
			@RequestParam(name="id", required=true) Integer id,
			@RequestParam(name="pMax", required=true) Double pMax, 
			@RequestParam(name="pMin", required=true) Double pMin,
			@RequestParam(name="nombre", required=true) String nombre) {
			LOG.info("Nombre: "+nombre);
			LOG.info("Precio maximo: "+pMax);
			LOG.info("Precio minimo: "+pMin);
		if (id != null || pMax != null || pMin != null || !nombre.equals("") ) {
			LOG.info("Ha entrado en searchMaterialesByNombre:"+ " searchMateriales()");
			ModelAndView mav=new ModelAndView(ViewConstant.Materiales);
			mav.addObject("material", new Materiales());
			mav.addObject("materiales", materialQuery.searchMateriales(id,nombre,pMax,pMin));
			return mav;
		}else {
			ModelAndView mav = new ModelAndView("redirect:/materiales/listMateriales");
			return mav;
		}
	}

		/**
	 * Report.
	 *
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/report"
	@GetMapping("/report")
	public ModelAndView report() {
		// Creamos un objeto JasperReport
		JasperReportsPdfView view = new JasperReportsPdfView();
		// ¿?¿??¿?¿?¿?¿??¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿??¿?¿?¿?¿??¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿??¿?¿?¿?¿??¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?
		view.setUrl("classpath:/reports/report5.jrxml");
		view.setApplicationContext(applicationContext);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datasource", materialService.reportMateriales());
		return new ModelAndView(view, params);

	}
	

}