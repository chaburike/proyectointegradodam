package spring.pintura.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.data.solr.core.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import spring.pintura.constant.ViewConstant;
import spring.pintura.converter.ComprasConverter;
import spring.pintura.entity.Cliente;
import spring.pintura.entity.Factura;
import spring.pintura.entity.FacturasMateriales;
import spring.pintura.entity.Materiales;
import spring.pintura.model.Compra;
import spring.pintura.repository.ClienteQueryDslRepository;
import spring.pintura.repository.MaterialQueryDslRepository;
import spring.pintura.service.ClienteService;
import spring.pintura.service.FacturaService;
import spring.pintura.service.FacturasMaterialesService;
import spring.pintura.service.impl.MaterialServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ComprasController.
 */
@Controller// Indica que la clase es un bean controlador
@RequestMapping("/compras")// Indica el mapeo de la clase principal, en este caso "/compras"
public class ComprasController {

	/** The id fc. */
	// lo utilizamos para el precio
	public static Integer idFc;
	
	/** The id cl. */
	public static String idCl;
	
	//¿?¿?¿?¿?¿?¿¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿??¿?¿?¿?¿?¿?¿?¿?¿?
	//Creamos varias variables para controlar errores o campos vacíos
	/** The exito. */
	public static String exito = null;
	
	/** The error total. */
	public static String errorTotal = null;
	
	/** The error cliente. */
	public static String errorCliente = null;
	
	/** The error compra. */
	public static String errorCompra = null;
	
	/** The add cliente. */
	public static boolean addCliente = false;
	
	/** The id cliente. */
	public static String idCliente = null; // Lo utilizamos para introducir el id en compras "facturas"
	
	/** The Constant LOG. */
	// Creamos un objeto log para crear informes(logs) y obtener cierta informacion
	// por consola
	private static final Log LOG = LogFactory.getLog(ClientesController.class);
	
	/** The c. */
	// Creamos un objeto Compra
	Compra c = new Compra();

	/** The cliente service. */
	// Realizamos una inyección de dependencias del servicio
	// ClienteService(clienteServiceImpl)
	// ClienteService será el servicio donde tenemos los metodos para hacer el CRUD
	// sobre compras
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;

	/** The cliente query dsl repository. */
	// Realizamos una inyección de dependencias del repositorio
	// ClienteQueryDslRepository(clienteQueryDslRepository)
	// ClienteQueryDslRepository será el repositorio donde tenemos los metodos para
	// buscar clientes
	@Autowired
	@Qualifier("clienteQueryDslRepository")
	private ClienteQueryDslRepository clienteQueryDslRepository;

	/** The material service. */
	// Realizamos una inyección de dependencias del servicio
	// MaterialServiceImpl(MaterialService)
	// MaterialServiceImpl será el servicio donde tenemos los metodos para hacer el
	// CRUD sobre materiales
	@Autowired
	@Qualifier("MaterialService")
	private MaterialServiceImpl materialService;

	/** The material query. */
	// Realizamos una inyección de dependencias del repositorio
	// MaterialQueryDslRepository(materialesQueryDslRepository)
	// MaterialQueryDslRepository será el repositorio donde tenemos los metodos para
	// buscar materiales
	@Autowired
	@Qualifier("materialesQueryDslRepository")
	private MaterialQueryDslRepository materialQuery;

	/** The Compras converter. */
	// Realizamos una inyección de dependencias del servicio
	// ComprasConverter(comprasConverter)
	// ComprasConverter será el servicio donde tenemos el metodo para reunir los
	// datos
	// y convierte un objeto material a un objeto compra
	@Autowired
	@Qualifier("comprasConverter")
	private ComprasConverter ComprasConverter;

	/** The factura service. */
	// Realizamos una inyección de dependencias del servicio
	// FacturaService(facturaServiceImpl)
	// FacturaService será el servicio donde tenemos el metodo para hacer el CRUD
	// sobre facturas
	@Autowired
	@Qualifier("facturaServiceImpl")
	private FacturaService facturaService;

	/** The facturas material service. */
	// Realizamos una inyección de dependencias del servicio
	// FacturaService(facturaServiceImpl)
	// FacturaService será el servicio donde tenemos el metodo para hacer el CRUD
	// sobre facturas
	@Autowired
	@Qualifier("facturasMaterialesServiceImpl")
	private FacturasMaterialesService facturasMaterialesService;

	/** The application context. */
	//Realizamos una inyección de dependencias especifica que usaremos para el Jasper
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * List all clientes.
	 *
	 * @return the model and view
	 */
	// Con este metodo verificamos si se ha realizado una busqueda sin introducir
	// datos para que nos devuelva la vista con alert exito
	// o por lo contrario nos devuelve los campos vacios
	// Establecemos un GetMapping para el metodo, en este caso "/listclientes"
	@GetMapping("/listclientes")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre listAllClientes()
	public ModelAndView listAllClientes() {
		LOG.info("Call: " + "listAllClientes()");

		//Creamos un objeto de cliente
		Cliente clientep = new Cliente();
		// Añadimos a nuestro nuevo cliente el resultado del metodo findClienteByDni del
		clientep = clienteService.findClienteByDni(idCliente);
		//Por defecto es false, es decir, al iniciarse los campos del cliente están en blanco
		if (addCliente == false) {
			//Asignamos a nuestro nuevo objeto cliente un cliente vacio
			clientep = new Cliente();
		}

		//Creamos un objeto ModelAndView y le pasamos la vista de facturar
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
		//Controlamos los errores o campos vacíos
		mav.addObject("errorTotal", errorTotal);
		mav.addObject("errorCompra", errorCompra);
		mav.addObject("errorCliente", errorCliente);
		//Carga los datos oportunos en función del id
		mav.addObject("compra", new Compra(c.getTotal()));
		mav.addObject("compras", Compra.getListaCompra());
		mav.addObject("material", new Materiales());
		mav.addObject("materiales", materialService.listAllMateriales());
		mav.addObject("cliente", clientep);// Aqui podemos utilizar el convertidor
		mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor
		exito = null;
		errorTotal = null;
		errorCliente = null;
		errorCompra = null;
		//Retornamos un ModelAndView
		return mav;

	}

	/**
	 * List all clientes update.
	 *
	 * @param dni the dni
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/listclientesupdate"
	@GetMapping("/listclientesupdate")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre listAllClientesUpdate()
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un dni para realizar una modificacion
	public ModelAndView listAllClientesUpdate(@RequestParam(name = "dni", required = false) String dni) {
		addCliente = true;
		//Asignamos la variable que hemos recogido a traves del @RequestParam
		idCliente = dni;//Recogemos el dni del cliente que insertamos en el form
		LOG.info("Recogemos el valor del idCliente al seleccionarlo de la lista: " + idCliente);
		//Creamos un nuevo objeto de cliente
		Cliente clientep = new Cliente();
		//Asignamos al nuevo cliente creado los datos del cliente buscado a traves del DNI
		//Nos devuelve un objeto cliente con todos sus datos
		clientep = clienteService.findClienteByDni(dni);
		LOG.info("Call: " + "listAllClientesUpdate()" + clientep.toString());
		// Creamos un objeto ModelAndView y le pasamos la vista de compras
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
		mav.addObject("compra", new Compra(c.getTotal()));
		//Añadimos al ModelAndView un objeto compras y el arrayList con el Listado de las compras
		mav.addObject("compras", Compra.getListaCompra());
		//Añadimos al ModelAndView un objeto material
		mav.addObject("material", new Materiales());
		//Añadimos al ModelAndView un objeto materiales y le pasamos el listado de materiales
		mav.addObject("materiales", materialService.listAllMateriales());
		//Añadimos al ModelAndView un objeto cliente con sus datos buscados por DNI
		mav.addObject("cliente", clientep);// Aqui podemos utilizar el convertidor
		//Añadimos al ModelAndView un objeto cliente y le pasamos el listado de clientes
		mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor
		//Retornamos el ModelAndView con todos los datos añadidos
		return mav;

	}

	
	/**
	 * Removes the cliente.
	 *
	 * @return the model and view
	 */
	// Con este metodo limpiamos la información del form cliente, y le damos un
	// valor null a idCliente
	// Establecemos un GetMapping para el metodo, en este caso "/removecliente"
	@GetMapping("/removecliente")
	public ModelAndView removeCliente() {
		addCliente = false;
		idCliente = null;
		LOG.info("Call: " + "removeCliente()");
		// Creamos un objeto ModelAndView y le pasamos la vista de compras
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
		mav.addObject("compra", new Compra(c.getTotal()));
		mav.addObject("compras", Compra.getListaCompra());
		mav.addObject("material", new Materiales());
		mav.addObject("materiales", materialService.listAllMateriales());
		mav.addObject("cliente", new Cliente());// Aqui podemos utilizar el convertidor
		mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor
		//Retornamos el ModelAndView con todos los datos añadidos
		return mav;

	}

	/**
	 * Removes the materiales.
	 *
	 * @param idMateriales the id materiales
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/removemateriales"
	@GetMapping("/removemateriales")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre removeMateriales()
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un Id para realizar una eliminación
	public ModelAndView removeMateriales(@RequestParam(name = "idMat", required = false) int idMat) {
		Cliente clientep = new Cliente();
		clientep = clienteService.findClienteByDni(idCliente);
		if (addCliente == false) {
			clientep = new Cliente();
		}
		LOG.info("Call: " + "removeMateriales()");
		LOG.info("ID PARA BORRAR EL MATERIAL DE LA LISTA DE LA COMPRA" + idMat);
		//Creamos un nuevo objeto de MATERIAL llamado materialMod
		Materiales materialMod = new Materiales();
		//Asignamos a dicho objeto el material a eliminar buscado a traves de su id que hemos recibido por parametro
		materialMod = materialService.findMaterialByIdMaterial(idMat);
		//Le pasamos a nuestro metodo remove la id recibida atraves del @RequestParam
		//dicho metodo está alojado en el modelo de Compras
		Compra.remove(idMat);
		// Creamos un objeto ModelAndView y le pasamos la vista de compras
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
		//Limpiamos los campos y mostramos los datos de la vista(es decir, materiales y clientes)
		mav.addObject("compras", Compra.getListaCompra());
		mav.addObject("material", new Materiales());
		mav.addObject("materiales", materialService.listAllMateriales());
		mav.addObject("cliente", clientep);// Aqui podemos utilizar el convertidor
		mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor
		mav.addObject("compra", new Compra(c.totalResta(materialMod.getPrecio())));
		//Retornamos el ModelAndView con todos los datos
		return mav;

	}

	/**
	 * Removes the compra.
	 *
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/removecompra"
	@GetMapping("/removecompra")
	public ModelAndView removeCompra() {
		LOG.info("Eliminamos la compra la compra");
		addCliente = false; //Lo volvemos false para que en la vistas inserte uno vacio
		idCliente = null; // Borramos el idCliente para que necesite insertar uno nuevo para realizar la compra
		//Limpiamos las compras escogidas
		//Y ponemos el total a 0
		Compra.getListaCompra().clear();
		c.setTotal(0.00);
		//Creamos un objeto de ModelAndView y le pasamos la vista de compras
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
		mav.addObject("compra", new Compra(c.getTotal()));
		mav.addObject("compras", Compra.getListaCompra());
		mav.addObject("material", new Materiales());
		mav.addObject("materiales", materialService.listAllMateriales());
		mav.addObject("cliente", new Cliente());// Aqui podemos utilizar el convertidor
		mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor
		return mav;

	}

	/**
	 * Adds the course.
	 *
	 * @param cliente the cliente
	 * @return the model and view
	 */
	// Establecemos un PostMapping, que son llamados cuando ocurre una accion (en este caso pulsar el boton guardar)
	@PostMapping("/addcliente")
	// Utilizamos la anotación ModelAtribute, que indica que estamos recibiendo el
	// objeto cliente, que tiene los datos introducidos en el campos para añadir clientes
	public ModelAndView addCourse(@ModelAttribute("cliente") Cliente cliente) {
		addCliente = true;
		//Recogemos el dni del cliente que insertamos en el form
		idCliente = cliente.getDni();
		LOG.info("Recogemos el valor del idCliente al crear un nuevo cliente: " + idCliente);
		// Primero introducimos la información del nuevo cliente en el form
		LOG.info("Call: " + "listAllClientesUpdate()" + cliente.toString());
		// Creamos un objeto ModelAndView y le pasamos la vista de compras
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
		mav.addObject("compras", Compra.getListaCompra());
		//Limpiamos los campos y mostramos los datos de la vista(es decir, materiales y clientes)
		mav.addObject("compra", new Compra(c.getTotal()));
		mav.addObject("material", new Materiales());
		mav.addObject("materiales", materialService.listAllMateriales());
		mav.addObject("cliente", cliente);// Aqui podemos utilizar el convertidor
		mav.addObject("clientes", clienteService.listAllClientes());
		// Seguidamente introducimos al nuevo cliente en la base de datos
		LOG.info("Call: " + "addCliente()" + "--Param: " + cliente.toString());
		// Llamamos al metodo addCliente e introducimos al nuevo cliente en la base de datos
		clienteService.addCliente(cliente);// Aqui podemos utilizar el convertidor
		//Retornamos el ModelAndView con todos los datos
		return mav;// Aqui podemos utilizar el convertidor
	}

	/**
	 * List all materiales update.
	 *
	 * @param idMateriales the id materiales
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/listMaterialesUpdate"
	@GetMapping("/listMaterialesUpdate")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre listAllMaterialesUpdate()
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un Id para realizar una modificación
	public ModelAndView listAllMaterialesUpdate(@RequestParam(name = "idMateriales", required = false) int idMateriales) {

		//Creamos un nuevo objeto Cliente para controlar los datos del cliente(en caso de que se elija alguno)
		//ya que al refrescar la pantalla debemos mostrar los datos del cliente seleccionado
		Cliente clientep = new Cliente();
		//Buscamos el cliente en función del id
		clientep = clienteService.findClienteByDni(idCliente);
		//Creamos un if para saber si hay algún cliente seleccionado, en caso de que no haya ningún cliente seleccionado
		//pasamos un objeto en nuevo de cliente
		if (addCliente == false) {
			clientep = new Cliente();
		}
		//Creamos un nuevo objeto de material
		Materiales materialMod = new Materiales();
		LOG.info("idMateriales: " + idMateriales);
		//Asignamos a nuestro nuevo objeto de materiales el material en funcion de su Id
		materialMod = materialService.findMaterialByIdMaterial(idMateriales);
		//Creamos un nuevo un objeto de Compra con los datos del material seleccionado
		new Compra(materialMod.getIdMateriales(), materialMod.getNombre(), materialMod.getPrecio());
		LOG.info("call: " + "listAllMaterialesUpdate()" + materialMod.toString());
		// Creamos un objeto ModelAndView y le pasamos la vista de compras
		ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);

		//Mostramos los datos de la vista(es decir, materiales, clientes y compras)
		mav.addObject("compras", Compra.getListaCompra());
		mav.addObject("material", new Materiales());
		mav.addObject("materiales", materialService.listAllMateriales());
		mav.addObject("cliente", clientep);// Aqui podemos utilizar el convertidor
		mav.addObject("clientes", clienteService.listAllClientes());
		mav.addObject("compra", new Compra(c.totalSuma(materialMod.getPrecio())));
		return mav;
	}

	/**
	 * Search cliente.
	 *
	 * @param model the model
	 * @param busqueda the busqueda
	 * @return the model and view
	 */
	//Establecemos un GetMapping para el metodo, en este caso "/searchcliente"
	@GetMapping("/searchcliente")
	private ModelAndView searchCliente(Model model, String busqueda) {

		// Si hemos añadido datos al buscador, es decir, el campo de busqueda no está vacio
		if (busqueda != null && !busqueda.isEmpty()) {
			LOG.info("Call: " + "busqueda" + busqueda);

			LOG.info("Call: " + "searchCliente()");
			// Se nos mostrara en modo alert el que se haya activado al realizar la
			// comprobación anterior
			// Creamos un objeto ModelAndView y le pasamos la vista de compras
			ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
			//Mostramos los datos de la vista(es decir, materiales, clientes y compras)
			mav.addObject("compra", new Compra(c.getTotal()));
			mav.addObject("compras", Compra.getListaCompra());
			mav.addObject("material", new Materiales());
			mav.addObject("materiales", materialService.listAllMateriales());
			mav.addObject("cliente", new Cliente()); // Aqui podemos utilizar el convertidor
			mav.addObject("clientes", clienteQueryDslRepository.searchClientes(busqueda));

			return mav;

		} else {
			// Si no hemos añadido datos al buscador nos redireccionará a la vista con todo
			// el listado de clientes
			ModelAndView mav = new ModelAndView("redirect:/compras/listclientes");
			return mav;
		}

	}

	/**
	 * Search materiales.
	 *
	 * @param id the id
	 * @param pMax the max
	 * @param pMin the min
	 * @param nombre the nombre
	 * @return the model and view
	 */
	//Establecemos un GetMapping para el metodo, en este caso "/searchMateriales"
	@GetMapping("/searchMateriales")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso obtener los datos
	// de la busqueda(datos del material)
	// Para ello usamos varios @RequestParam en los que cada uno de ellos nos devuelve un valor sobre la busqueda
	//Podremos buscar a partir del nombre y del precio, tanto minimo como maximo
	private ModelAndView searchMateriales(@RequestParam(name = "id", required = true) Integer id,
			@RequestParam(name = "pMax", required = true) Double pMax,
			@RequestParam(name = "pMin", required = true) Double pMin,
			@RequestParam(name = "nombre", required = true) String nombre) {

		//Creamos un nuevo objeto Cliente para controlar los datos del cliente(en caso de que se elija alguno)
		//ya que al refrescar la pantalla debemos mostrar los datos del cliente seleccionado
		Cliente clientep = new Cliente();
		//Buscamos el cliente en función del id
		clientep = clienteService.findClienteByDni(idCliente);
		//Creamos un if para saber si hay algún cliente seleccionado, en caso de que no haya ningún cliente seleccionado
		//pasamos un objeto en nuevo de cliente
		if (addCliente == false) {
			clientep = new Cliente();
		}
		LOG.info("Nombre: " + nombre);
		LOG.info("Precio maximo: " + pMax);
		LOG.info("Precio minimo: " + pMin);

		//En caso de que algun campo de busqueda esté escrito muestra los datos 
		if (id != null || pMax != null || pMin != null || !nombre.equals("")) {
			LOG.info("Ha entrado en searchMaterialesByNombre:" + " searchMateriales()");
			// Creamos un objeto ModelAndView y le pasamos la vista de compras
			ModelAndView mav = new ModelAndView(ViewConstant.FACTURAR);
			//Asignamos el total de la compra
			mav.addObject("compra", new Compra(c.getTotal()));
			//Mostramos los datos de la vista(es decir, clientes y compras)
			mav.addObject("compras", Compra.getListaCompra());
			mav.addObject("cliente", clientep);// Aqui podemos utilizar el convertidor
			mav.addObject("clientes", clienteService.listAllClientes());
			mav.addObject("material", new Materiales());
			//Llamamos al método searchMateriales y le pasamos por parametro los campos de busqueda a traves del 
			//repositorio MaterialQueryDslRepository
			mav.addObject("materiales", materialQuery.searchMateriales(id, nombre, pMax, pMin));
			return mav;
		//En caso de que todos los campos estén vaciós
		} else {
			ModelAndView mav = new ModelAndView("redirect:/compras/listclientes");
			//Retornamos la vista listar cliente (listclientes)
			return mav;
		}
	}

	/**
	 * Realizar compra.
	 *
	 * @return the model and view
	 */
	//Establecemos un GetMapping para el metodo, en este caso "/realizarcompra"
	@GetMapping("/realizarcompra")
	public ModelAndView realizarCompra() {
		LOG.info("COMPROBAMOS CUANTOS MATERIALES HAY EN LA COMPRA: " +  Compra.getListaCompra().size());
		LOG.info("Confiramos la compra");
		//Creamos un objeto ModelAndView
		ModelAndView mav = new ModelAndView();
		//Creamos un if para comprobar si no se ha elegido un cliente y si la compra es 0
		//Y en funcion de los datos oportunos incrementamos una variable para mostrar el error oportuno
		if (idCliente == null || Compra.getListaCompra().size() == 0) {
			if (Compra.getListaCompra().size() == 0 && idCliente == null) {
				errorTotal ="1";
			} else if (idCliente == null) {
				errorCliente = "1";
			} else {
				errorCompra = "1";
			}

			//Asignamos al ModelAndView una redirección a la vista para listar clientes
			mav = new ModelAndView("redirect:/compras/listclientes");

			//En caso de que los campos estén rellenos
		} else {
			//Cremos un nuevo objeto de cliente
			Cliente clientef = new Cliente();
			//Asignamos a dicho objeto los datos del cliente en función del ID
			clientef = clienteService.findClienteByDni(idCliente);
			//Creamos un objeto de Factura y le asignamos el total de la compra y los datos del cliente
			Factura factura = new Factura(c.getTotal(), clientef);			
			idCl = idCliente;
			//Asignamos la nueva factura mediante el metodo addFactura a traves del servicio facturaService
			facturaService.addFactura(factura);
			
			//Creamos un for para asignar todas las facturas(facturas materiales) en nuestra tabla de relación
			for (Compra c : Compra.getListaCompra()) {

				Materiales material = materialService.findMaterialByIdMaterial(c.getIdMat());
				FacturasMateriales facturamaterial = new FacturasMateriales(factura, material, 1);
				facturasMaterialesService.addFacturasMateriales(facturamaterial);
				idFc = facturamaterial.getRelacionIdFactura().getIdFactura();
			}
			//Limpiamos los datos y variables
			idCliente = null;
			addCliente = false;
			exito = "1";
			Compra.getListaCompra().clear();
			c.setTotal(0.00);
			mav = new ModelAndView(ViewConstant.FACTURAR);
			mav.addObject("exito", exito);
			mav.addObject("compra", new Compra(c.getTotal()));
			mav.addObject("compras", Compra.getListaCompra());
			mav.addObject("material", new Materiales());
			mav.addObject("materiales", materialService.listAllMateriales());
			mav.addObject("cliente", new Cliente());// Aqui podemos utilizar el convertidor
			mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor

		}
		return mav;

	}

	/**
	 * Report.
	 *
	 * @return the model and view
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/report"
	@GetMapping("/report")
	public ModelAndView report() {
		//Creamos un objeto JasperReport
		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setUrl("classpath:/reports/report2.jrxml");
		view.setApplicationContext(applicationContext);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("datasource", facturasMaterialesService.reportFactura(idFc, idCl));
		return new ModelAndView(view, params);

	}
}
