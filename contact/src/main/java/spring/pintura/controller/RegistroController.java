package spring.pintura.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.pintura.constant.ViewConstant;
import spring.pintura.converter.UserConverter;
import spring.pintura.entity.Cliente;
import spring.pintura.entity.User;
import spring.pintura.model.UserCredential;
import spring.pintura.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	@Qualifier("UsuarioService")
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	
	/** The Constant LOG. */
	// Creamos un objeto log para crear informes(logs) y obtener cierta informacion
	// por consola
	private static final Log LOG = LogFactory.getLog(RegistroController.class);

	//Creamos mediante @PreAuthorize una autorización para que solo el usuario Administrador pueda acceder a dicho metodo
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	// Establecemos un GetMapping para el metodo, en este caso "/listclientes"
	@GetMapping("/listusuarios")
	// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
	// con nombre listAllClientes()
	public ModelAndView listAllUsuarios() {
		LOG.info("Call: " + "listAllUsuarios()");
		// Creamos un objeto ModelAndView y le pasamos la vista de clientes
		ModelAndView mav = new ModelAndView(ViewConstant.USUARIOS);
		// Añadimos al ModelAndView un objeto usuario
		mav.addObject("users", new User());
		// Añadimos al ModelAndView un objeto usuarios con todos los datos y llamamos al
		// metodo "listAllUsuarios" a traves
		// de la inyeccion de clienteService
		mav.addObject("usuarios", usuarioService.listAllUsuarios());
		// Y retornamos dicho objeto ModelAndView, es decir, retornamos la vista con los
		// datos
		return mav;

	}
	
	
	// Metodo para añadir clientes
		@PostMapping("/addUsuarios")
		public String addUsuarios(@ModelAttribute("usuario") User usuario) {
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			String password = pe.encode(usuario.getPassword());
			boolean activo = usuario.isEnabled();
			activo=true;
			LOG.info("Call: "+" addUsuarios()"+usuario);
			LOG.info("este es el objeto USUARIO que estoy modificando "+usuario.toString()+"NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
			UserCredential trabajadoradd = new UserCredential(usuario.getUsername(),password,activo);
			usuarioService.addUsuarios(userConverter.userModeltoUser(trabajadoradd));
			return "redirect:/registro/listusuarios";
			
		}
		
		
		// Establecemos un GetMapping para el metodo, en este caso "/listusuariosUpdate"
		@GetMapping("/listusuariosUpdate")
		// Creamos un metodo ModelAndView (nos devuelve tanto un modelo como una vista)
		// con nombre listusuariosUpdate()
		// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
		// obtener un nombre para realizar una modificación
		public ModelAndView listAllUsuariosUpdate(@RequestParam(name="idUsuarios", required = false) int idUsuarios) {
			// Creamos un nuevo objeto usuario
			User usuario = new User();
			// Añadimos a nuestro nuevo usuario el resultado del metodo findUsuarioByNombre del
			// servicio usuarioService
			// a dicho metodo le pasamos el nombre pasado a traves del @RequestParam
			usuario = usuarioService.findUsuarioById(idUsuarios);
			LOG.info("Call: " + "listAllUsuariosUpdate()" + usuario.toString());
			// Creamos un objeto ModelAndView y le pasamos la vista de usuarios
			ModelAndView mav = new ModelAndView(ViewConstant.USUARIOS);
			// Añadimos al ModelAndView un objeto users con los datos del usuario buscado
			// por id
			mav.addObject("users", usuario);
			// Añadimos al ModelAndView un objeto usuarios y llamamos al metodo
			// listAllUsuarios() del servicio usuarioService
			mav.addObject("usuarios", usuarioService.listAllUsuarios());
			return mav;
		}
		
		
		// Establecemos un GetMapping para el metodo, en este caso "/removecliente"
		@GetMapping("/removeusuarios")
		// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
		// obtener un DNI para realizar una
		// eliminación
		public String removeUsuarios(@RequestParam(name = "idUsuarios", required = true) int idUsuarios) {
			// Llamamos al metodo removeCliente a traves del servicio clienteService y le
			// pasamos el dni que hemos recibido
			usuarioService.removeUsuario(idUsuarios);// Aqui podemos utilizar el convertidor
			// Hacemos un return al metodo de listar clientes (listclientes)
			return "redirect:/registro/listusuarios";
		}
		

}
