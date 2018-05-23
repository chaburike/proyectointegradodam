//Creamos un servicio que hará uso de los metodos definidos en su correspondiente interfaz
package spring.pintura.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.FacturasMateriales;
import spring.pintura.repository.ClienteRepository;
import spring.pintura.service.ClienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteServiceImpl.
 */
//La clase define un servicio
@Service("clienteServiceImpl")
//Implementamos la interfaz ClienteService donde se encuentran definidos los metodos
public class ClienteServiceImpl implements ClienteService {

	/** The cliente repository. */
	// Realizamos una inyección de dependencias del repositorio
	// ClienteRepository(clienteRepository)
	// ClienteRepository será el repositorio donde tenemos los metodos para hacer la busqueda de clientes
	// por su dni
	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;

	/* (non-Javadoc)
	 * @see spring.pintura.service.ClienteService#listAllClientes()
	 */
	//Implementamos el metodo listAllClientes(para listar todos los clientes)
	@Override
	public List<Cliente> listAllClientes() {
		//Usamos el metodo findAll() gracias a que el repositorio hereda de Jpa
		return clienteRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.ClienteService#addCliente(spring.pintura.entity.Cliente)
	 */
	//Implementamos el metodo addCliente(para añadir un cliente)
	@Override
	public Cliente addCliente(Cliente cliente) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return clienteRepository.save(cliente);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.ClienteService#removeCliente(java.lang.String)
	 */
	//Implementamos el metodo removeCliente(para eliminar un cliente)
	@Override
	public int removeCliente(String dni) {
		//Usamos el metodo delete() gracias a que el repositorio hereda de Jpa
		clienteRepository.delete(dni);
		return 0;
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.ClienteService#updateCliente(spring.pintura.entity.Cliente)
	 */
	//Implementamos el metodo updateCliente(para modificar un cliente)
	@Override
	public Cliente updateCliente(Cliente cliente) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return clienteRepository.save(cliente);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.ClienteService#findClienteByDni(java.lang.String)
	 */
	
	//Implementamos el metodo findClienteByDni(para buscar un cliente por su dni)
	@Override
	public Cliente findClienteByDni(String dni) {
		//Usamos el metodo findByDni() gracias a que el repositorio hereda de Jpa
		return clienteRepository.findByDni(dni);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.ClienteService#findAll()
	 */
	
	//Creamos un metod iterable que nos retornará todos los clientes
	@Override
	public Iterable<Cliente> findAll() {

		//Nos retorna una llamada al metodo que nos devolverá el datos buscado
		return clienteRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.ClienteService#reportClientes()
	 */
	
	//Creamos un metodo que usará Jasper para recoger mediante un for todos los datos de los clientes
	@Override
	public List<Map<String, Object>> reportClientes() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Cliente cliente : this.findAll()) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("Dni", cliente.getDni());
			item.put("Nombre", cliente.getNombre());
			item.put("Apellidos", cliente.getApellidos());
			item.put("Telefono", cliente.getTelefono());
			result.add(item);
		}
		//Nos devuelve un arraylist con los datos buscados
		return result;
	}

	@Override
	public boolean comprobarDni(String dni) {
		// TODO Auto-generated method stub
	      boolean comprobador=true;
	      String numeros[]={"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};
	      
	      for (int i=0;i<numeros.length;i++){
	          if (String.valueOf(dni.charAt(8)).equals(numeros[i])){
	              comprobador=false;
	          }
	      }
	      return comprobador;
	}

}
