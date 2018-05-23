//Esta clase modelo se usa para coger los datos necesarios que serán usados por otras clase
package spring.pintura.model;

import javax.validation.constraints.NotNull;

import spring.pintura.entity.Factura;
import spring.pintura.entity.Materiales;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaMaterialModel.
 */
public class FacturaMaterialModel {
	
	//Definimos los datos de nuestra tabla FacturaMateriales
	//Establecemos que no puedan ser datos nulos
	/** The idmaterial. */
	@NotNull
	private int idmaterial;
	
	/** The idfactura. */
	@NotNull
	private int idfactura;
	
	/** The cantidad. */
	@NotNull
	private int cantidad;
	
	
	
	/**
	 * Gets the idfactura.
	 *
	 * @return the idfactura
	 */
	//Metodos get y set
	//**************IDFACTURA*************
	public int getIdfactura() {
		return idfactura;
	}

	/**
	 * Sets the idfactura.
	 *
	 * @param idfactura the new idfactura
	 */
	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}
	//**************FIN IDFACTURA**********

	/**
	 * Gets the idmaterial.
	 *
	 * @return the idmaterial
	 */
	//****************IDMATERIAL****************

	public int getIdmaterial() {
		return idmaterial;
	}

	public void setIdmaterial(int idmaterial) {
		this.idmaterial = idmaterial;
	}
	//****************FIN ID***************
	
	

	/**
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 */
	//*****************CANTIDAD***************
	public int getCantidad() {
		return cantidad;
	}

	

	/**
	 * Sets the cantidad.
	 *
	 * @param cantidad the new cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	//***************FIN CANTIDAD************
	
	/** The fac. */
	//************FACTURA***************
	//Creamos un objeto de Factura
	Factura fac= new Factura();
	
	/**
	 * Gets the fac.
	 *
	 * @return the fac
	 */
	//Metodos get y set de factura
	public Factura getFac() {
		return fac;
	}

	/**
	 * Sets the fac.
	 *
	 * @param fac the new fac
	 */
	public void setFac(Factura fac) {
		this.fac = fac;
	}
	//*************FACTURA**************

	
	/** The com. */
	//************MATERIAL***********
	//Creamos un objeto de com
	Materiales com = new Materiales();
	
	/**
	 * Gets the com.
	 *
	 * @return the com
	 */
	//Metodos get y set de Material
	public Materiales getCom() {
		return com;
	}

	/**
	 * Sets the com.
	 *
	 * @param com the new com
	 */
	public void setCom(Materiales com) {
		this.com = com;
	}
	//**************FIN MATERIAL************

}
