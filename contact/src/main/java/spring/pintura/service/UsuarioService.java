//Creamos la interfaz MaterialService donde definiremos los metodos, que seran usados en los servicios
package spring.pintura.service;

import java.util.List;
import java.util.Map;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.Materiales;
import spring.pintura.entity.User;

//TODO: Auto-generated Javadoc
/**
* The Interface UsuarioService.
*/
public interface UsuarioService {
	
	//public boolean password(String password);
	
	/**
	 * List all clientes.
	 *
	 * @return the list
	 */
	//Definimos un metodo para listar todos los usuarios
	public abstract List<User> listAllUsuarios();
	
	/**
	 * Adds the usuarios.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 */
	//Definimos un metodo para añadir materiales
	public abstract User addUsuarios(User usuario);
	
	/**
	 * Removes the cliente.
	 *
	 * @param dni the dni
	 * @return the int
	 */
	//Definimos un metodo para eliminar usuarios
	public abstract int removeUsuario(int idUsuarios);
	
	//Definimos un metodo para actualizar usuarios
	public abstract User updateUsuarios(User user);
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	//Definimos un metodo para encontrar todos los datos(será usado por JasperReports)
	public abstract Iterable<User> findAll();
	
	
	/**
	 * Find usuario by nombre.
	 *
	 * @param nombre the nombre
	 * @return the usuario
	 */
	//Definimos un metodo para buscar clientes por su dni
	public abstract User findUsuarioById(int idUsuarios);
	
	/**
	 * Report clientes.
	 *
	 * @return the list
	 */
	//Definimos un metodo que usaremos para el JasperReports
	public abstract List<Map<String, Object>> reportUsuarios();
	

}
