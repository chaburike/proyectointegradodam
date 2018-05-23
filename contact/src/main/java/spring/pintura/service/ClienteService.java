//Creamos la interfaz ClienteService donde definiremos los metodos, que seran usados en los servicios
package spring.pintura.service;

import java.util.List;
import java.util.Map;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.FacturasMateriales;



// TODO: Auto-generated Javadoc
/**
 * The Interface ClienteService.
 */
public interface ClienteService {

	/**
	 * List all clientes.
	 *
	 * @return the list
	 */
	//Definimos un metodo para listar todos los clientes
	public abstract List<Cliente> listAllClientes();
	
	/**
	 * Adds the cliente.
	 *
	 * @param cliente the cliente
	 * @return the cliente
	 */
	//Definimos un metodo para añadir cliente
	public abstract Cliente addCliente(Cliente cliente);
	
	/**
	 * Removes the cliente.
	 *
	 * @param dni the dni
	 * @return the int
	 */
	//Definimos un metodo para eliminar clientes
	public abstract int removeCliente(String dni);
	
	/**
	 * Update cliente.
	 *
	 * @param cliente the cliente
	 * @return the cliente
	 */
	//Definimos un metodo para actualizar clientes
	public abstract Cliente updateCliente(Cliente cliente);
	
	/**
	 * Find cliente by dni.
	 *
	 * @param dni the dni
	 * @return the cliente
	 */
	//Definimos un metodo para buscar clientes por su dni
	public abstract Cliente findClienteByDni(String dni);
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	//Definimos un metodo para encontrar todos los datos(será usado por JasperReports)
	public abstract Iterable<Cliente> findAll();
	
	/**
	 * Report clientes.
	 *
	 * @return the list
	 */
	//Definimos un metodo que usaremos para el JasperReports
	public abstract List<Map<String, Object>> reportClientes();
	
	public abstract boolean comprobarDni(String dni);
		
	
}
