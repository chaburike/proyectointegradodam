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
import spring.pintura.entity.Cliente;
import spring.pintura.repository.ClienteQueryDslRepository;
import spring.pintura.service.ClienteService;

@Controller // Indica que la clase es un bean controlador
@RequestMapping("/clientes") // Indica el mapeo de la clase principal, en este caso "/clientes"
public class ClientesController {

	// Creamos un objeto log para crear informes(logs) y obtener cierta informacion
	// por consola
	private static final Log LOG = LogFactory.getLog(ClientesController.class);

	// Realizamos una inyección de dependencias del servicio
	// ClienteService(clienteServiceImpl)
	// ClienteService será el servicio donde tenemos los metodos para hacer el CRUD
	// sobre clientes
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;

	// Realizamos una inyección de dependencias del repositorio
	// ClienteQueryDslRepository(clienteQueryDslRepository)
	// ClienteQueryDslRepository será el repositorio que usaremos para manejar el
	// buscador de la pagina, es decir,
	// para buscar los clientes por varios campos
	@Autowired
	@Qualifier("clienteQueryDslRepository")
	private ClienteQueryDslRepository clienteQueryDslRepository;  
	
	@Autowired
	private ApplicationContext applicationContext; 
	
	private static Integer comprobador;

	// Establecemos un GetMapping para el metodo, en este caso "/listclientes"
	@GetMapping("/listclientes")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre listAllClientes()
	public ModelAndView listAllClientes() {
		LOG.info("Call: " + "listAllClientes()");
		// Creamos un objeto ModelAndView y le pasamos la vista de clientes
		ModelAndView mav = new ModelAndView(ViewConstant.CLIENTES);
		// Añadimos al ModelAndView un objeto cliente
		mav.addObject("cliente", new Cliente());
		// Añadimos al ModelAndView un objeto clientes con todos los datos y llamamos al
		// metodo "listAllClientes" a traves
		// de la inyeccion de clienteService
		mav.addObject("clientes", clienteService.listAllClientes());
		// Y retornamos dicho objeto ModelAndView, es decir, retornamos la vista con los
		// datos
		return mav;

	}

	// Establecemos un GetMapping para el metodo, en este caso "/listclientesupdate"
	@GetMapping("/listclientesupdate")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre listAllClientesUpdate()
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un DNI para realizar una modificación
	public ModelAndView listAllClientesUpdate(@RequestParam(name = "dni", required = false) String dni) {
		// Creamos un nuevo objeto cliente
		Cliente clientep = new Cliente();
		// Añadimos a nuestro nuevo cliente el resultado del metodo findClienteByDni del
		// servicio clienteService
		// a dicho metodo le pasamos el dni pasado a traves del @RequestParam
		clientep = clienteService.findClienteByDni(dni);
		LOG.info("Call: " + "listAllClientesUpdate()" + clientep.toString());
		// Creamos un objeto ModelAndView y le pasamos la vista de clientes
		ModelAndView mav = new ModelAndView(ViewConstant.CLIENTES);
		// Añadimos al ModelAndView un objeto cliente con los datos del cliente buscado
		// por dni
		mav.addObject("cliente", clientep);
		// Añadimos al ModelAndView un objeto cliente y llamamos al metodo
		// listAllClientes() del servicio clienteService
		mav.addObject("clientes", clienteService.listAllClientes());
		return mav;
	}

	// Establecemos un PostMapping, que son llamados cuando ocurre una accion (en
	// este caso pulsar el boton guardar)
	@PostMapping("/addcliente")
	public String addCourse(@ModelAttribute("cliente") Cliente cliente) {
		LOG.info("Call: " + "addCliente()" + "--Param: " + cliente.toString());
		// Llamamos al metodo addCliente a traves del repositorio clienteService y le
		// añadimos el cliente que se nos
		// a pasado a traves de la vista
		clienteService.addCliente(cliente);
		// Hacemos un return al metodo de listar clientes (listclientes)
		return "redirect:/clientes/listclientes";
	}

	// Establecemos un GetMapping para el metodo, en este caso "/removecliente"
	@GetMapping("/removeclientes")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un DNI para realizar una
	// eliminación
	public String removecliente(@RequestParam(name = "dni", required = true) String dni) {
		// Llamamos al metodo removeCliente a traves del servicio clienteService y le
		// pasamos el dni que hemos recibido
		clienteService.removeCliente(dni);// Aqui podemos utilizar el convertidor
		// Hacemos un return al metodo de listar clientes (listclientes)
		return "redirect:/clientes/listclientes";
	}

	// Establecemos un GetMapping para el metodo, en este caso "/searchcliente"
	@GetMapping("/searchcliente")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener una busqueda(datos del cliente)
	// de clientes
	private ModelAndView searchCliente(@RequestParam(name = "busqueda", required = true) String busqueda) {

		// Hacemos un if para comprobar que los campos de bsuqueda no están vacios
		if (busqueda != null && !busqueda.isEmpty()) {
			LOG.info("Call: " + "searchCliente()");
			// Creamos un objeto ModelAndView y le pasamos la vista de clientes
			ModelAndView mav = new ModelAndView(ViewConstant.CLIENTES);
			// Añadimos al ModelAndView un objeto cliente
			mav.addObject("cliente", new Cliente());
			// Añadimos al ModelAndView un objeto cliente y llamamos al metodo
			// searchClientes del repositorio
			// clienteQueryDslRepository y le pasamos la busqueda(que contiene los
			// parametros introducidos)
			mav.addObject("clientes", clienteQueryDslRepository.searchClientes(busqueda));
			// Retornamos el objeto ModelAndView
			return mav;

			// En caso de que la busqueda esté vacía
		} else {

			// Retornamos al metodo listar clientes (listclientes)
			ModelAndView mav = new ModelAndView("redirect:/clientes/listclientes");
			return mav;
		}

	}


	@GetMapping("/report")
	public ModelAndView report() {
		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:/reports/report3.jrxml");
		view.setApplicationContext(applicationContext);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datasource", clienteService.reportClientes());
		return new ModelAndView(view, params);

	}

}