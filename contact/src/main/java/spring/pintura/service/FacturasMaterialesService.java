//Creamos la interfaz FacturasMaterialesService donde definiremos los metodos, que seran usados en los servicios
package spring.pintura.service;

import java.util.List;
import java.util.Map;

import spring.pintura.entity.FacturasMateriales;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturasMaterialesService.
 */
public interface FacturasMaterialesService {
	
	/**
	 * Lista all facturas.
	 *
	 * @return the list
	 */
	//Definimos un metodo para listar todas las facturas
	public abstract List<FacturasMateriales> listaAllFacturas();
	
	/**
	 * Adds the facturas materiales.
	 *
	 * @param FacturasMateriales the facturas materiales
	 * @return the facturas materiales
	 */
	//Definimos un metodo para añadir facturas
	public abstract FacturasMateriales addFacturasMateriales(FacturasMateriales facturasMateriales);
	
	/**
	 * Removes the facturas materiales.
	 *
	 * @param id the id
	 * @return the int
	 */
	//Definimos un metodo para eliminar facturas
	public abstract int removeFacturasMateriales(int id);
	
	/**
	 * Update facturas materiales.
	 *
	 * @param FacturasMateriales the facturas materiales
	 * @return the facturas materiales
	 */
	//Definimos un metodo para actualizar facturas
	public abstract FacturasMateriales updateFacturasMateriales(FacturasMateriales facturasMateriales);
	
	/**
	 * Find facturas materiales by id.
	 *
	 * @param id the id
	 * @return the facturas materiales
	 */
	//Definimos un metodo para buscar facturas por su id
	public abstract FacturasMateriales findFacturasMaterialesById(int id);
	
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	//Definimos un metodo para encontrar todos los datos(será usado por JasperReports)
	public abstract Iterable<FacturasMateriales> findAll();
	
	/**
	 * Report.
	 *
	 * @return the list
	 */
	//Definimos un metodo que usaremos para el JasperReports
	public abstract List<Map<String, Object>> report();
	
	/**
	 * Report factura.
	 *
	 * @param idFactura the id factura
	 * @param idCliente the id cliente
	 * @return the list
	 */
	//Definimos un metodo que usaremos para el JasperReports y le pasamos los datos idFactura e idCliente
	public abstract List<Map<String, Object>> reportFactura(int idFactura, String idCliente);

}
