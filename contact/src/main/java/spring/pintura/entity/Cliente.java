package spring.pintura.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
@Entity // Especifica que voy a crear una entidad. Se coloca al inicio de la definición
		// de la clase.
@Table (name="cliente")// Especificamos el nombre de la tabla que se va a crear, en este caso "cliente"
public class Cliente {
	
	/** The dni. */
	@Id// Nombramos la id(dni) con la anotación de spring @Id(Primary key de la
		// entidad.)
	@Column(name="dni", nullable=false, unique=true)// Lo anotamos con @Column(anotaremos así todos los atributos
													// de nuestras entidades)
													// y nullable(que no puede ser nulo)
													// y con los atributos unique(que no se pueda repetir)
	private String dni;
	
	/** The nombre. */
	@Column(name="nombre")
	private String nombre;
	
	/** The apellidos. */
	@Column(name="apellidos")
	private String apellidos;
	
	/** The telefono. */
	@Column(name="telefono")
	private String telefono;
	
	/** The facturas. */
	@OneToMany(targetEntity=Factura.class, mappedBy="cliente", fetch=FetchType.EAGER, cascade=CascadeType.ALL)// Hacemos una relación
																												// @OneToMany(es decir, un
																												// solo usuario puede tener
																												// varias facturas)
	private Set<Factura> facturas=new HashSet<Factura>();
	
	/**
	 * Instantiates a new cliente.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public Cliente() {
		
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param dni the dni
	 * @param nombre the nombre
	 * @param apellidos the apellidos
	 * @param telefono the telefono
	 */
	// Creamos un constructor con todos los parametros
	public Cliente(String dni, String nombre, String apellidos, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	// Metodos get y set sobre los datos
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
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

	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientesEntity [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
}
