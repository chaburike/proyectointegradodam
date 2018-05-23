//Esta clase modelo se usa para coger los datos necesarios que serán usados por otras clase
package spring.pintura.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Compra.
 */
public class Compra {
	

	/** The df. */
	//Establecemos un formato a la hora de ingresar numeros
	DecimalFormat df = new DecimalFormat("####.####");

	/** The lista compra. */
	//Creamos un ArrayList temporal que almacenará los datos de las compras

	public static ArrayList<Compra> listaCompra = new ArrayList<>();

	/** The id material. */
	private int idMat;
	
	/** The nombre. */
	private String nombre;
	
	/** The precio. */
	private double precio;

	/** The total. */
	public Double total = 0.00;

	/**
	 * Instantiates a new compra.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public Compra() {

	}

	/**
	 * Instantiates a new compra.
	 *
	 * @param total the total
	 */
	//Creamos un constructor con el parametro total
	public Compra(Double total) {
		this.total = total;
	}

	/**
	 * Instantiates a new compra.
	 *
	 * @param idMat the id materiales
	 * @param nombre the nombre
	 * @param precio the precio
	 */
	//Creamos un constructor con los parametros idMat, nombre y precio
	public Compra(int idMat, String nombre, double precio) {
		super();
		this.idMat = idMat;
		this.nombre = nombre;
		this.precio = precio;
		//Añadimos los datos a nuestro arraylist
		listaCompra.add(this);

	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	//Metodo que nos devuelve el total con un replace para sustituir comas por puntos
	public Double getTotal() {
		return Double.parseDouble(df.format(total).replace(",","."));
	}

	/**
	 * Sets the total.
	 *
	 * @param total the new total
	 */
	//Metodo que nos devuelve un total
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * Gets the lista compra.
	 *
	 * @return the lista compra
	 */
	//Creamos un metodo con nuestro arraylist llamado getListaCompra 
	public static ArrayList<Compra> getListaCompra() {
		//Nos devuelve el propio arraylist con todos los datos
		return listaCompra;
	}

	

	public int getIdMat() {
		return idMat;
	}

	public void setIdMat(int idMat) {
		this.idMat = idMat;
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

	/**
	 * Removes the.
	 *
	 * @param id the id
	 */
	//Creamos un metodo para eliminar la compra deseada en funcion de su id
	public static void remove(int id) {
		//Hacemos un bucle for para eliminar las compras que coincidan en funcion del id
		for (Compra c : listaCompra) {
			if (c.getIdMat() == id) {
				listaCompra.remove(c);
				break;
			}

		}

	}

	/**
	 * Total suma.
	 *
	 * @param precio the precio
	 * @return the double
	 */
	//Método para saber el total del pedido
	public Double totalSuma(Double precio) {

		total += precio;
		//Return que nos devuelve el total con un replace para sustituir comas por puntos
		return Double.parseDouble(df.format(total).replace(",", "."));
	}

	/**
	 * Total resta.
	 *
	 * @param precio the precio
	 * @return the double
	 */
	//Metodo que usamos para restar al total del precio el precio de un producto eliminado de nuestra compra
	public Double totalResta(Double precio) {

		total -= precio;

		return Double.parseDouble(df.format(total).replace(",","."));
	}

}
