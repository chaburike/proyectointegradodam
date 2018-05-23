//Creamos la interfaz FacturasService donde definiremos los metodos, que seran usados en los servicios
package spring.pintura.service;

import java.util.List;

import spring.pintura.entity.Factura;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaService.
 */
public interface FacturaService {
	
	/**
	 * Lista all facturas.
	 *
	 * @return the list
	 */
	//Definimos un metodo para listar todas las facturas
	public abstract List<Factura> listaAllFacturas();
	
	/**
	 * Adds the factura.
	 *
	 * @param factura the factura
	 * @return the factura
	 */
	//Definimos un metodo para añadir facturas
	public abstract Factura addFactura(Factura factura);
	
	/**
	 * Removes the factura.
	 *
	 * @param id the id
	 * @return the int
	 */
	//Definimos un metodo para eliminar facturas
	public abstract int removeFactura(int id);
	
	/**
	 * Update factura.
	 *
	 * @param factura the factura
	 * @return the factura
	 */
	//Definimos un metodo para actualizar facturas
	public abstract Factura updateFactura(Factura factura);
	
	/**
	 * Find factura by id.
	 *
	 * @param id the id
	 * @return the factura
	 */
	//Definimos un metodo para buscar facturas por su id
	public abstract Factura findFacturaById(int id);
	

}
