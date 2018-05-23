package spring.pintura.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.pintura.constant.ViewConstant;

@Controller
@RequestMapping("/otros")
public class ConocenosController {
	
	// Establecemos un GetMapping para el metodo, en este caso "/conocenos"
	@GetMapping("/conocenos")
	public String showConocenos() {
		//Retornamos la vista conocenos
		return ViewConstant.CONOCENOS;
	}
	
	// Establecemos un GetMapping para el metodo, en este caso "/logout"
	@GetMapping("/logout")
	public ModelAndView logout(String logout) {
		//Creamos un objeto ModelAndView y le pasamos la vista de Login
		ModelAndView mav = new ModelAndView(ViewConstant.LOGIN);
		//Con este metodo de Security limpiamos el contenido para evitar que al pulsar atras nos lleve de nuevo a nuestra aplicación
		SecurityContextHolder.clearContext();
		logout ="1";
		mav.addObject("logout", logout);
		return mav;
	}

}
