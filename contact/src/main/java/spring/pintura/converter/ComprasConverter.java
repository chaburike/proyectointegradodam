//Esta clase es la encargada de convertir un objeto Material a un objeto Compra
package spring.pintura.converter;

import org.springframework.stereotype.Component;

import spring.pintura.entity.Materiales;
import spring.pintura.model.Compra;

// TODO: Auto-generated Javadoc
/**
 * The Class ComprasConverter.
 */
//Establecemos como @Component, que es un estereotipo general y permite anotar un bean 
//para que Spring lo considere uno de sus objetos.
@Component("comprasConverter")
public class ComprasConverter {
	
	/**
	 * De material A compra.
	 *
	 * @param material the material
	 * @return the compra
	 */
	//Creamos el metodo deMaterialACompra que recibirá por parametro un material y lo transformará a un objeto Compra
	public Compra deMaterialACompra(Materiales material) {
		//Creamos un nuevo objeto compra
		Compra compra = new Compra();
		//Asignamos al nuevo objeto compra los datos pertinentes(Id, nombre y precio)
		compra.setIdMat(material.getIdMateriales());
		compra.setNombre(material.getNombre());
		compra.setPrecio(material.getPrecio());
		//Devolvemos dicho objeto compra
		return compra;
	}
	

}
