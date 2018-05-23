//Esta clase modelo se usa para coger los datos necesarios que serán usados por otras clase
package spring.pintura.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class MaterialModel.
 */
public class MaterialModel {
	
	//Definimos los datos de nuestra tabla material
	//Establecemos que no puedan ser datos nulos y un tamaño minimo y maximo
	/** The nombre. */
	@NotNull
	@Size(min=2, max=10)
	private String nombre;
	
	/** The precio. */
	@NotNull
	//@Min(18)
	private double precio;
	
	/** The id materiales. */
	@NotNull
	//@Min(18)
	private int idMateriales;
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	//Metodos get y set
	//********************NOMBRE****************
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//******************FIN NOMBRE**************
	
	//*******************PRECIO*****************
	
	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
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
	//******************FIN PRECIO**************
	
	//**********************ID******************
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getIdMateriales() {
		return idMateriales;
	}

	/**
	 * Sets the id.
	 *
	 * @param id_materiales the new id
	 */
	public void setIdMateriales(int idMateriales) {
		this.idMateriales = idMateriales;
	}
	//********************FIN ID*******************
	
	
	/**
	 * Instantiates a new material model.
	 */
	//Constructor por defecto sin datos usado por hibernate
	public MaterialModel() {

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//Sobreescribimos el metodo toString para mostrar la información deseada
	@Override
	public String toString() {
		return "MaterialModel [nombre=" + nombre + ", precio=" + precio + ", ID="+idMateriales+ "]";
	}
	
	
	
	
	
	

}
