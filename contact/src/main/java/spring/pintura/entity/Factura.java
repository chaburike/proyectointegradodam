package spring.pintura.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Factura.
 */
@Entity// Especifica que voy a crear una entidad. Se coloca al inicio de la definición
		// de la clase.
@Table(name="facturas")// Especificamos el nombre de la tabla que se va a crear, en este caso
					  // "facturas"
public class Factura {
	
	/** The id factura. */
	@Id // Nombramos la id(Id) con la anotación de spring @Id(Primary key de la
		// entidad.)
	@GeneratedValue(strategy=GenerationType.IDENTITY)// Indica que esa clave(el Id) se auto genera por medio de auto increment
	@Column(name="")// Lo anotamos con @Column(anotaremos así todos los atributos de nuestras entidades)
	int idFactura;
	
	/** The precio. */
	@Column (name="precio")
	double precio;
	
	/** The cliente. */
	@ManyToOne(cascade=CascadeType.REMOVE)// Hacemos una relación ManyToOne(es decir, varias facturas pueden pertenecer a
										 // un solo cliente)
	@JoinColumn(name="dni", nullable=false)// Indicamos la tabla con la que queremos hacer la
										  // relación, en este caso "dni"
	private Cliente cliente;
	
	/** The facturas materiales entity. */
	@OneToMany(fetch=FetchType.EAGER, targetEntity=FacturasMateriales.class, mappedBy="relacionIdFactura", cascade=CascadeType.ALL)// ¿?¿??¿?¿?¿?¿?¿?¿??¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?¿?
	private Set<FacturasMateriales> facturasmaterialesEntity=new HashSet<FacturasMateriales>();
	
	/**
	 * Instantiates a new factura.
	 *
	 * @param precio the precio
	 * @param cliente the cliente
	 */
	// Creamos un constructor con el parametro precio y un objeto (entidad cliente)
	public Factura(double precio, Cliente cliente) { //idFactura, precio, idCliente
		super();
		this.precio = precio;
		this.cliente = cliente;
	}

	

	/**
	 * Instantiates a new factura.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public Factura() {
		
	}

	/**
	 * Gets the id factura.
	 *
	 * @return the id factura
	 */
	//Metodos get y set
	public int getIdFactura() {
		return idFactura;
	}

	/**
	 * Sets the id.
	 *
	 * @param idFactura the new id
	 */
	public void setId(int idFactura) {
		this.idFactura = idFactura;
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

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//Sobreescribimos el metodo toString para que nos muestre la información
	@Override
	public String toString() {
		return "FacturasEntity [id=" + idFactura + ", precio=" + precio + ", cliente=" + cliente + "]";
	}
	
	

}
