//Creamos la interfaz MaterialService donde definiremos los metodos, que seran usados en los servicios
package spring.pintura.service;

import java.util.List;
import java.util.Map;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.Materiales;

// TODO: Auto-generated Javadoc
/**
 * The Interface MaterialService.
 */
public interface MaterialService {
	
	/**
	 * List all materiales.
	 *
	 * @return the list
	 */
	//Definimos un metodo para listar todos los materiales
	public abstract List<Materiales> listAllMateriales();
	
	/**
	 * Adds the materiales.
	 *
	 * @param material the material
	 * @return the material
	 */
	//Definimos un metodo para añadir materiales
	public abstract Materiales addMateriales(Materiales material);
	
	/**
	 * Removes the materiales.
	 *
	 * @param id the id
	 * @return the int
	 */
	//Definimos un metodo para eliminar materiales
	public abstract int removeMateriales(int id);
	
	/**
	 * Update materiales.
	 *
	 * @param material the material
	 * @return the material
	 */
	//Definimos un metodo para actualizar materiales
	public abstract Materiales updateMateriales(Materiales material);
	
	/**
	 * Find material by id material.
	 *
	 * @param id the id
	 * @return the material
	 */
	//Definimos un metodo para buscar materiales por su id
	public abstract Materiales findMaterialByIdMaterial(int id);
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	//Definimos un metodo para encontrar todos los datos(será usado por JasperReports)
	public abstract Iterable<Materiales> findAll();
	
	/**
	 * Report materiales.
	 *
	 * @return the list
	 */
	//Definimos un metodo que usaremos para el JasperReports
	public abstract List<Map<String, Object>> reportMateriales();

}
