//Esta clase modelo se usa para coger los datos necesarios que serán usados por otras clase
package spring.pintura.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import spring.pintura.entity.Cliente;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaModel.
 */
public class FacturaModel {
	
	//Definimos los datos de nuestra tabla FacturaModel
	//Establecemos que no puedan ser datos nulos
	/** The precio. */
	@NotNull
	//@Min(18)
	private double precio;
	
	/** The id factura. */
	@NotNull
	//@Min(18)
	private int id_factura;
	
	/** The clien. */
	//Creamos un nuevo objeto de cliente
	Cliente clien = new Cliente();
	
	//**************CLIENTE**************
	
	/**
	 * Gets the clien.
	 *
	 * @return the clien
	 */
	//Metodos get y set de cliente
	public Cliente getClien() {
		return clien;
	}

	/**
	 * Sets the clien.
	 *
	 * @param clien the new clien
	 */
	public void setClien(Cliente clien) {
		this.clien = clien;
	}
	//****************CLIENTE************
	
	//**************PRECIO***********
	
	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	//Metodos get y set
	public double getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	//*************FIN PRECIO**********
	
	
	//*************ID******************
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getid() {
		return id_factura;
	}

	/**
	 * Sets the id.
	 *
	 * @param id_factura the new id
	 */
	public void setid(int id_factura) {
		this.id_factura = id_factura;
	}
	//***************FIN ID***********
	
	/**
	 * Instantiates a new factura model.
	 */
	//Constructor por defecto sin datos usado por hibernate
	public FacturaModel() {

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//Sobreescribimos el metodo toString para mostrar la información deseada
	@Override
	public String toString() {
		return "FacturasModel [cliente=" + clien + ", precio=" + precio + ", id_factura="+id_factura+ "]";
	}
	

}
