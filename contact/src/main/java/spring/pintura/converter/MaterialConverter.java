//Esta clase es la encargada de convertir un objeto de entidad a modelo y viceversa
package spring.pintura.converter;


import org.springframework.stereotype.Component;

import spring.pintura.entity.Materiales;
import spring.pintura.model.ClienteModel;
import spring.pintura.model.MaterialModel;

// TODO: Auto-generated Javadoc
/**
 * The Class MaterialConverter.
 */
//Establecemos como @Component, que es un estereotipo general y permite anotar un bean 
//para que Spring lo considere uno de sus objetos.
@Component("materialConverter")
public class MaterialConverter {
	
	/**
	 * Entity model.
	 *
	 * @param material the material
	 * @return the material model
	 */
	//Creamos el metodo entityModel que recibirá por parametro un material entidad y lo transformará a un objeto material modelo
	//Convertimos de entity a model
		public MaterialModel entityModel(Materiales material) {
			//Creamos un nuevo objeto materialModel
			MaterialModel materialModel = new MaterialModel();
			//Asignamos al nuevo objeto material los datos pertinentes(nombre, precio, y id)
			materialModel.setNombre(material.getNombre());
			materialModel.setPrecio(material.getPrecio());
			materialModel.setIdMateriales(material.getIdMateriales());
			//Devolvemos el objeto materialModel(hemos convertido una entidad material a un modelo material)
			return materialModel;
		}
		
		/**
		 * Model entity.
		 *
		 * @param materialModel the material model
		 * @return the material
		 */
		//Creamos el metodo modelEntity que recibirá por parametro un material modelo y lo transformará a un objeto material entidad
		//Convertimos de model a entity
		public Materiales modelEntity(MaterialModel materialModel) {
			//Creamos un nuevo objeto materialesEntity
			Materiales materialesEntity = new Materiales();
			//Asignamos al nuevo objeto material los datos pertinentes(nombre, precio, y id)
			materialesEntity.setNombre(materialModel.getNombre());
			materialesEntity.setPrecio(materialModel.getPrecio());
			materialesEntity.setIdMateriales(materialModel.getIdMateriales());
			//Devolvemos el objeto materialesEntity(hemos convertido un modelo cliente a una entidad cliente)
			return materialesEntity;
					
		}
		


}
