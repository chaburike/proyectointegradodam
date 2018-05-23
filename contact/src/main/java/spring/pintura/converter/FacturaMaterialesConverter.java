//Esta clase es la encargada de convertir un objeto de entidad a modelo y viceversa
package spring.pintura.converter;

import spring.pintura.entity.Factura;
import spring.pintura.entity.FacturasMateriales;
import spring.pintura.model.FacturaMaterialModel;
import spring.pintura.model.FacturaModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaMaterialesConverter.
 */
public class FacturaMaterialesConverter {
	
	/**
	 * Entity model.
	 *
	 * @param faccom the faccom
	 * @return the factura material model
	 */
	//Creamos el metodo entityModel que recibirá por parametro una factura(FacturasMateriales) entidad y lo transformará a un objeto factura(facturamaterialModel) modelo
	//Convertimos de entity a model
	public FacturaMaterialModel entityModel(FacturasMateriales faccom) {
		//Creamos un nuevo objeto facturamaterialModel
		FacturaMaterialModel facturamaterialModel = new FacturaMaterialModel();
		//Asignamos al nuevo objeto factura(facturamaterialModel) los datos pertinentes(id de factura e id de material)
		facturamaterialModel.setIdfactura(faccom.getRelacionIdFactura().getIdFactura());
		facturamaterialModel.setIdmaterial(faccom.getRelacionIdMateriales().getIdMateriales());
		//Devolvemos el objeto facturamaterialModel(hemos convertido una entidad factura(FacturasMateriales) a un modelo factura(FacturasMateriales))
		return facturamaterialModel;
	}
	
	/**
	 * Model entity.
	 *
	 * @param facturamaterialModel the facturamaterialModel
	 * @return the facturas materiales
	 */
	//Creamos el metodo modelEntity que recibirá por parametro una factura(facturamaterialModel) modelo y lo transformará a un objeto factura(facturamateriales) entidad
	//Convertimos de model a entity
	public FacturasMateriales modelEntity(FacturaMaterialModel facturamaterialModel) {
		//Creamos un nuevo objeto facturamateriales
		FacturasMateriales facturamateriales = new FacturasMateriales();
		//Asignamos al nuevo objeto factura(facturamateriales) los datos pertinentes(id de factura e id de material)
		facturamateriales.setRelacionIdFactura(facturamaterialModel.getFac());
		facturamateriales.setRelacionIdMateriales(facturamaterialModel.getCom());
		//Devolvemos el objeto facturamaterialModel(hemos convertido una entidad factura(FacturasMateriales) a un modelo factura(FacturasMateriales))
		return facturamateriales;			
	}
}
