package spring.pintura.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import spring.pintura.constant.ViewConstant;
import spring.pintura.converter.FacturaConverter;
import spring.pintura.entity.Cliente;
import spring.pintura.entity.Factura;
import spring.pintura.repository.FacturaQueryDslRepository;
import spring.pintura.repository.FuncionContarClientes;
import spring.pintura.service.FacturaService;
import spring.pintura.service.FacturasMaterialesService;
import spring.pintura.service.impl.FacturaServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturasController.
 */
@Controller
@RequestMapping("/factura")
public class FacturasController {

	/** The Constant LOG. */
	// Creamos un objeto log para crear informes(logs) y obtener cierta informacion
	// por consola
	private static final Log LOG = LogFactory.getLog(ClientesController.class);

	/** The factura service impl. */
	// Realizamos una inyección de dependencias del servicio
	// FacturaService(facturaServiceImpl)
	// FacturaService será el servicio donde tenemos los metodos para hacer el
	// CRUD sobre facturas
	@Autowired
	@Qualifier("facturaServiceImpl")
	private FacturaService facturaService;

	/** The factura query dsl repository. */
	// Realizamos una inyección de dependencias del repositorio
	// FacturaQueryDslRepository(facturaQueryDslRepository)
	// FacturaQueryDslRepository será el repositorio que usaremos para manejar el
	// buscador de la pagina, es decir,
	// para buscar las facturas por varios campos
	@Autowired
	@Qualifier("facturaQueryDslRepository")
	private FacturaQueryDslRepository facturaQueryDslRepository;

	/** The factura converter. */
	// Realizamos una inyección de dependencias del servicio
	// FacturaConverter(facturaConverter)
	// FacturaConverter será el convertidor que usaremos para pasar de entidad a modelo y viceversa
	@Autowired
	@Qualifier("facturaConverter")
	private FacturaConverter facturaConverter;

	/** The funcion contar clientes. */
	//Realizamos una inyección de dependencias de una función
	//FuncionContarClientes(funcionContarClientes)
	//Dicha función es la encargada de contar los clientes almacenados
	@Autowired
	@Qualifier("funcionContarClientes")
	private FuncionContarClientes funcionContarClientes;

	/** The facturas materiales service. */
	// Realizamos una inyección de dependencias del servicio
	// FacturasMaterialesService(facturasMaterialesServiceImpl)
	// FacturasMaterialesService será el servicio donde tenemos los metodos para hacer el
	// CRUD sobre facturas(de la tabla intermedia)
	@Autowired
	@Qualifier("facturasMaterialesServiceImpl")
	private FacturasMaterialesService facturasMaterialesService;

	/** The application context. */
	//Realizamos una inyección de dependencias especifica que usaremos para el Jasper
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * List facturas.
	 *
	 * @param var the var
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/listFacturas"
	@GetMapping("/listFacturas")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre listFacturas()
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un numero informativo para saber X cantidad de una cosa
	public ModelAndView listFacturas(@RequestParam(name = "var", required = false) Integer var) {

		LOG.info("ENTRAMOS EN EL METODO DE LISTAR FACTURAS");
		// Creamos un objeto ModelAndView y le pasamos la vista de facturas
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURA);
		//Convertimos de entity a model
		mav.addObject("factura", facturaConverter.entityModel(new Factura()));
		//Añadimos a nuestro ModelAndView la cantidad de facturas que hay
		mav.addObject("var", funcionContarClientes.getContarFactura(var));
		//Añadimos a nuestro ModelAndView los datos de todas las facturas con el metodo listaAllFacturas
		mav.addObject("facturas", facturaService.listaAllFacturas());
		//Retornamos nuestro ModelAndView con los datos
		return mav;
	}

	/**
	 * Removes the factura.
	 *
	 * @param id
	 *            the id
	 * @return the string
	 */
	//Creamos mediante @PreAuthorize una autorización para que solo el usuario Administrador pueda acceder a dicho metodo
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	// Establecemos un GetMapping para el metodo, en este caso "/removeFactura"
	@GetMapping("/removeFactura")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un Id para realizar una eliminación
	public String removeFactura(@RequestParam(name = "idFactura", required = true) int id) {
		LOG.info("ENTRAMOS EN EL METODO REMOVEFACTURA");
		// Llamamos al metodo removeFactura a traves del servicio facturaService y le
		// pasamos el id que hemos recibido
		facturaService.removeFactura(id);
		//Retornamos el listado de facturas
		return "redirect:/factura/listFacturas";
	}

	/**
	 * Search factura.
	 *
	 * @param idFactura
	 *            the id factura
	 * @param precio
	 *            the precio
	 * @param dni
	 *            the dni
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/searchFacturas"
	@GetMapping("/searchFacturas")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso obtener los datos
	// de la busqueda(datos de la factura)
	// Para ello usamos varios @RequestParam en los que cada uno de ellos nos
	// devuelve un valor sobre la busqueda
	public ModelAndView searchFactura(
			@RequestParam(name = "idFactura", required = false) Integer idFactura,
			@RequestParam(name = "precio", required = false) Double precio,
			@RequestParam(name = "dni", required = false) String dni) {
		// Creamos un if para comprobar que los distintos campos no son nulos
		if (idFactura != null || precio != null || !dni.equalsIgnoreCase("")) {
			LOG.info("ENTRAMOS EN EL METODO BUSCAR FACTURA");
			// Creamos un objeto ModelAndView y le pasamos la vista de facturas
			ModelAndView mav = new ModelAndView(ViewConstant.FACTURA);
			// Añadimos al ModelAndView un objeto factura
			mav.addObject("factura", new Factura());
			// Añadimos al ModelAndView un objeto facturas y llamamos al metodo searchFacturas
			// del repositorio
			// facturaQueryDslRepository y le pasamos los distintos campos de busqueda(que contiene los
			// parametros introducidos)
			mav.addObject("facturas", facturaQueryDslRepository.searchFacturas(idFactura, precio, dni));
			// Retornamos el objeto ModelAndView
			return mav;
			
			//En caso de que los campos sean nulos redirigimos a la vista de listar facturas
		} else {
			ModelAndView mav = new ModelAndView("redirect:/factura/listFacturas");
			return mav;
		}
	}

	/**
	 * Contar clientes.
	 *
	 * @param var the var
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/contarFacturas"
	@GetMapping("/contarFacturas")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un numero informativo para saber X cantidad de una cosa
	public ModelAndView contarClientes(@RequestParam(name = "var", required = true) Integer var) {
		LOG.info("HAS ENTRADO EN EL METODO DE CONTAR CLIENTES...");
		// Creamos un objeto ModelAndView y le pasamos la vista de factura
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURA);
		// Añadimos al ModelAndView un objeto factura
		mav.addObject("factura", new Factura());
		//Añadimos al ModelAndView  la variable pasada por parametro y llamamos al metodo getContarFactura del repositorio
		//FuncionContarClientes
		mav.addObject("var", funcionContarClientes.getContarFactura(var));
		// Añadimos al ModelAndView un objeto factura y llamamos al metodo
		// listaAllFacturas() del servicio facturaService
		mav.addObject("facturas", facturaService.listaAllFacturas());
		return mav;
	}

	/**
	 * Report.
	 *
	 * @param idFactura the id factura
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/report"
	@GetMapping("/report")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un Id
	public ModelAndView report(@RequestParam(name = "idFactura", required = false) Integer idFactura) {
		//Creamos un objeto JasperReport
		Factura factura = facturaService.findFacturaById(idFactura);
		String dni = factura.getCliente().getDni();
		JasperReportsPdfView view = new JasperReportsPdfView();
		//¿?¿??¿?¿?¿?¿??¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿??¿?¿?¿?¿??¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿??¿?¿?¿?¿??¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?
		view.setUrl("classpath:/reports/report2.jrxml");
		view.setApplicationContext(applicationContext);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datasource", facturasMaterialesService.reportFactura(idFactura, dni));
		return new ModelAndView(view, params);

	}

}
