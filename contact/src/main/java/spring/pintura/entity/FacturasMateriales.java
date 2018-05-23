//Esta es la clase que contendrá los atributos asociados a FacturasMateriales
package spring.pintura.entity;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturasMateriales.
 */
@Entity// Especifica que voy a crear una entidad. Se coloca al inicio de la definición
		// de la clase.
@Table(name="FacturasMateriales")// Especificamos el nombre de la tabla que se va a crear, en este caso
							// "FacturasMateriales"
public class FacturasMateriales{
	
	/** The id. */
	@Id// Nombramos la id(id) con la anotación de spring @Id(Primary key de la
		// entidad.)
	@GeneratedValue(strategy=GenerationType.IDENTITY)// Indica que esa clave(el Id) se auto genera por medio de auto
													// increment
	@Column(name="idRelacion")// Lo anotamos con @Column(anotaremos así todos los atributos de nuestras
							 // entidades)
	private int id;
	
	/** The relacion id factura. */
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idFactura", nullable=false)// Indicamos la tabla con la que queremos hacer la relación, en
												// este caso "idFactura"
	private Factura relacionIdFactura;
	
	/** The relacion id material. */
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idmaterial", nullable=false)// Indicamos la tabla con la que queremos hacer la relación, en este
											  // caso "idmaterial"
	private Materiales relacionIdMateriales;
	
	/** The cantidad. */
	@Column(name="cantidad")
	private int cantidad;
	
	/**
	 * Instantiates a new facturas materiales.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public FacturasMateriales() {
		
	}

	/**
	 * Instantiates a new facturas materiales.
	 *
	 * @param relacionIdFactura the relacion id factura
	 * @param relacionIdMateriales the relacion id materiales
	 * @param cantidad the cantidad
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public FacturasMateriales(Factura relacionIdFactura, Materiales relacionIdMateriales, int cantidad) { //idFactura , idMateriales , cantidad total
		super();
		this.relacionIdFactura = relacionIdFactura;
		this.relacionIdMateriales = relacionIdMateriales;
		this.cantidad = cantidad;
	}

	/**
	 * Gets the relacion id factura.
	 *
	 * @return the relacion id factura
	 */
	// Metodos get y set sobre los datos
	public Factura getRelacionIdFactura() {
		return relacionIdFactura;
	}

	/**
	 * Sets the relacion id factura.
	 *
	 * @param relacionIdFactura the new relacion id factura
	 */
	public void setRelacionIdFactura(Factura relacionIdFactura) {
		this.relacionIdFactura = relacionIdFactura;
	}

	/**
	 * Gets the relacion id materiales.
	 *
	 * @return the relacion id materiales
	 */
	public Materiales getRelacionIdMateriales() {
		return relacionIdMateriales;
	}

	/**
	 * Sets the relacion id materiales.
	 *
	 * @param relacionIdmateriales the new relacion id materiales
	 */
	public void setRelacionIdMateriales(Materiales relacionIdMateriales) {
		this.relacionIdMateriales = relacionIdMateriales;
	}

	/**
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	// Sobreescribimos el metodo toString() para devolver dicha información
	@Override
	public String toString() {
		return "FacturasMaterialesEntity [relacionIdFactura=" + relacionIdFactura + ", relacionIdMateriales=" + relacionIdMateriales
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	

		
}