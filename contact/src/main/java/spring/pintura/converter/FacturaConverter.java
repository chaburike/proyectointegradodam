//Esta clase es la encargada de convertir un objeto facturaModel a un objeto facturaEntity
package spring.pintura.converter;


import org.springframework.stereotype.Component;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.Factura;
import spring.pintura.model.FacturaModel;
import spring.pintura.model.MaterialModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaConverter.
 */
//Establecemos como @Component, que es un estereotipo general y permite anotar un bean 
//para que Spring lo considere uno de sus objetos.
@Component("facturaConverter")
public class FacturaConverter {
	
	/**
	 * Entity model.
	 *
	 * @param factura the factura
	 * @return the factura model
	 */
	//Creamos el metodo entityModel que recibirá por parametro una factura entidad y lo transformará a un objeto factura modelo
	//Convertimos de entity a model
		public FacturaModel entityModel(Factura factura) {
			//Creamos un nuevo objeto facturaModel
			FacturaModel facturaModel = new FacturaModel();
			//Asignamos al nuevo objeto facturaModel los datos pertinentes(un objeto cliente, un objeto factura, y el precio)
			facturaModel.setClien(factura.getCliente());
			facturaModel.setid(factura.getIdFactura());
			facturaModel.setPrecio(factura.getPrecio());
			//Devolvemos el objeto facturaModel(hemos convertido una entidad factura a un modelo factura)
			return facturaModel;
		}
		
		/**
		 * Model entity.
		 *
		 * @param facturaModel the factura model
		 * @return the factura
		 */
		//Creamos el metodo modelEntity que recibirá por parametro una factura modelo y lo transformará a un objeto factura entidad
		//Convertimos de model a entity
			public Factura modelEntity(FacturaModel facturaModel) {
				//Creamos un nuevo objeto facturaEntity
				Factura facturaEntity = new Factura();
				//Asignamos al nuevo objeto facturaEntity los datos pertinentes(un objeto cliente, un objeto factura, y el precio)
				facturaEntity.setCliente(facturaModel.getClien());
				facturaEntity.setId(facturaModel.getid());
				facturaEntity.setPrecio(facturaModel.getPrecio());
				//Devolvemos el objeto facturaEntity(hemos convertido un modelo factura a una entidad factura)
				return facturaEntity;			
			}

}
