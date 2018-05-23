package spring.pintura.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Materiales.
 */
@Entity// Especifica que voy a crear una entidad. Se coloca al inicio de la definición
		// de la clase.
@Table(name="materiales") // Especificamos el nombre de la tabla que se va a crear, en este caso "pintura"
public class Materiales {
	
	/** The id materiales. */
	@Id // Nombramos la id(idMateriales) con la anotación de spring @Id(Primary key de la
		// entidad.)
	@GeneratedValue (strategy=GenerationType.IDENTITY)// Indica que esa clave(el Id) se auto genera por medio de auto
													// increment
	@Column(name="idMateriales")// Lo anotamos con @Column(anotaremos así todos los atributos de nuestras
							// entidades)
	private int idMateriales;//Columna id de la base de datos
	
	/** The nombre. */
	@Column(name="nombre")
	private String nombre;//Columna nombre de la base de datos
	
	/** The precio. */
	@Column(name="precio")
	private double precio;//Columna precio de la base de datos
	
	/** The materiales facturas entity. */
	@OneToMany(fetch=FetchType.EAGER, targetEntity=FacturasMateriales.class, mappedBy="relacionIdMateriales", cascade=CascadeType.ALL)// Hacemos
	// una relación @OneToMany(es  decir, un solo material puede tener pertenecer a varias facturas)
	
	// Creamos una colección temporal que almacenará las facturasmateriales
	private Set<FacturasMateriales> materialesFacturasEntity=new HashSet<FacturasMateriales>();
	
	/**
	 * Instantiates a new material.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public Materiales() {
		
	}
	
	/**
	 * constructor para los parametros de la base de datos.
	 *
	 * @param nombre parametro nombre de la base de datos
	 * @param precio parametro precio de la base de datos
	 */
	// Creamos un constructor con todos los parametros
	public Materiales(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		
	}



	public int getIdMateriales() {
		return idMateriales;
	}

	public void setIdMateriales(int idMateriales) {
		this.idMateriales = idMateriales;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	// Sobreescribimos el metodo toString() para devolver dicha información
	@Override
	public String toString() {
		return "MaterialesEntity [id=" + idMateriales + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	
	
	
	

	
}
