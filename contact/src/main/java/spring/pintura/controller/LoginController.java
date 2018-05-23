package spring.pintura.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.pintura.constant.ViewConstant;
import spring.pintura.entity.Materiales;
import spring.pintura.entity.User;
import spring.pintura.service.impl.UsuarioServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller // Indica que la clase es un bean controlador
public class LoginController {
	
	@Autowired
	@Qualifier("UsuarioService")
	private UsuarioServiceImpl usuarioService;
	
	
	/** The Constant LOG. */
	// Creamos un objeto log para crear informes(logs) y obtener cierta informacion
	// por consola
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	
	/**
	 * Show login form.
	 *
	 * @param model the model
	 * @param error the error
	 * @param logaut the logaut
	 * @return the string
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/login"
	@GetMapping("/login")
	// @RequestParam se usa para obtener los parámetros de solicitud, en este caso
	// obtener un error en caso de que los datos sean erroneos y un mensaje al hacer un logaut
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logaut", required=false) String logaut) {
		LOG.info("METHOD: showLoginForm() -- Params: error= " + error + ", logaut= " + logaut );
		model.addAttribute("error", error);
		model.addAttribute("logaut", logaut);
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	
	/**
	 * Login check.
	 *
	 * @return the string
	 */
	// Establecemos un GetMapping para el metodo, en este caso "/loginsuccess" o "/"
	@GetMapping({ "/loginsuccess", "/" })
	public String loginCheck(@ModelAttribute("usuario") User usuario) {
		LOG.info("METHOD:  loginCheck()");
		LOG.info("Returning to contacts view");
		//Si el logeo es satisfactorio devolvemos la vista de listar clientes(listclientes)
		return "redirect:/clientes/listclientes";
	}

}
