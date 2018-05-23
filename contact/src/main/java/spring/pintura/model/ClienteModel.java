//Esta clase modelo se usa para coger los datos necesarios que serán usados por otras clase
package spring.pintura.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteModel.
 */
public class ClienteModel {
	
	//Definimos los datos de nuestra tabla clientes
	//Establecemos que no puedan ser datos nulos y un tamaño minimo y maximo
	/** The nombre. */
	@NotNull
	@Size(min=2, max=10)
	private String nombre;
	
	/** The apellidos. */
	@NotNull
	@Size(min=2, max=10)
	private String apellidos;
	
	/** The dni. */
	@NotNull
	@Size(min=9, max=9)
	private String dni;
	
	/** The telefono. */
	@NotNull
	private String telefono;
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public ClienteModel(String string) {
		
		
		
	}
	//Creamos los gets y sets
	//*************NOMBRE***************
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
	//**************FIN NOMBRE**********
	
	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	//**************APELLIDOS***********
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	//*************FIN APELLIDOS**********
	
	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	//**************DNI*****************
	public String getdni() {
		return dni;
	}
	
	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setdni(String dni) {
		this.dni = dni;
	}
	//******************FIN DNI**************
	
	/**
	 * Gets the telefono.
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Sets the telefono.
	 *
	 * @param telefono the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Instantiates a new cliente model.
	 */
	//Constructor por defecto sin datos usado por hibernate
	public ClienteModel() {

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//Sobreescribimos el metodo toString para mostrar la información deseada
	@Override
	public String toString() {
		return "ClienteModel [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono=" + telefono
				+ "]";
	}

	

	
	
	
	

}
