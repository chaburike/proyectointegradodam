package spring.pintura.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.pintura.constant.ViewConstant;
import spring.pintura.entity.Cliente;
import spring.pintura.model.ClienteModel;
import spring.pintura.service.ClienteService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	private static final Log LOG = LogFactory.getLog(RestController.class);
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	@GetMapping("/checkrest")
	public ResponseEntity<String> checkRest(){
		
		ModelAndView mav = new ModelAndView(ViewConstant.CLIENTES);
		mav.addObject("cliente", new Cliente());// Aqui podemos utilizar el convertidor
		mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor
		
		
		//ClienteModel cliente = new ClienteModel(clienteService.listAllClientes());
		ClienteModel cliente = new ClienteModel();
		cliente = new ClienteModel(clienteService.listAllClientes().toString());
		LOG.info("MMMMMMMMMMMMMMMMMMMMMMMMMM MMM"+clienteService.listAllClientes().toString()+"\n");
		return new ResponseEntity<String>(clienteService.listAllClientes().toString()+"\n", HttpStatus.OK);
	}
	
	@GetMapping("/listclientes")
	public ModelAndView listAllClientes(@RequestParam(name="var", required=false) Integer var) {
		//LOG.info("Call: " + "listAllClientes()");
		ModelAndView mav = new ModelAndView(ViewConstant.CLIENTES);
		mav.addObject("cliente", new Cliente());// Aqui podemos utilizar el convertidor
		//mav.addObject("var", funcionContarClientes.getContarClientes(var));
		mav.addObject("clientes", clienteService.listAllClientes());// Aqui podemos utilizar el convertidor
		return mav;
	}

}

