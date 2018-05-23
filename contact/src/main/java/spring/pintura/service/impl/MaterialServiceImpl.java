//Creamos un servicio que hará uso de los metodos definidos en su correspondiente interfaz
package spring.pintura.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.Materiales;
import spring.pintura.repository.MaterialesRepository;
import spring.pintura.service.MaterialService;

// TODO: Auto-generated Javadoc
/**
 * The Class MaterialServiceImpl.
 */
//La clase define un servicio
@Service("MaterialService")
//Implementamos la interfaz MaterialService donde se encuentran definidos los metodos
public class MaterialServiceImpl implements MaterialService {
	
	/** The material repository. */
	// Realizamos una inyección de dependencias del repositorio
	// MaterialesRepository(materialRepository)
	// MaterialesRepository será el repositorio donde tenemos los metodos para hacer la busqueda de materiales
	// por su id
	@Autowired
	@Qualifier("materialesRepository")
	private MaterialesRepository materialRepository;

	/* (non-Javadoc)
	 * @see spring.pintura.service.MaterialService#listAllMateriales()
	 */
	//Implementamos el metodo listAllMateriales(para listar todos los materiales)
	@Override
	public List<Materiales> listAllMateriales() {
		//Usamos el metodo findAll() gracias a que el repositorio hereda de Jpa
		return materialRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.MaterialService#addMateriales(spring.pintura.entity.Materiales)
	 */
	//Implementamos el metodo addMateriales(para añadir un material)
	@Override
	public Materiales addMateriales(Materiales material) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return materialRepository.save(material);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.MaterialService#removeMateriales(int)
	 */
	//Implementamos el metodo removeMateriales(para eliminar un material)
	@Override
	public int removeMateriales(int id) {
		//Usamos el metodo delete() gracias a que el repositorio hereda de Jpa
		materialRepository.delete(id);
		return 0;
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.MaterialService#updateMateriales(spring.pintura.entity.Materiales)
	 */
	//Implementamos el metodo updateMateriales(para modificar un material)
	@Override
	public Materiales updateMateriales(Materiales material) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return materialRepository.save(material);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.MaterialService#findMaterialByIdMaterial(int)
	 */
	//Implementamos el metodo findMaterialByIdMaterial(para buscar un material por su id)
	@Override
	public Materiales findMaterialByIdMaterial(int id) {
		//Usamos el metodo findMaterialByIdMaterial() gracias a que el repositorio hereda de Jpa
		return materialRepository.findByIdMateriales(id);
	}
	
	/* (non-Javadoc)
	 * @see spring.pintura.service.MaterialService#findAll()
	 */
	//Creamos un metod iterable que nos retornará todos los clientes
	public Iterable<Materiales> findAll() {

		//Nos retorna una llamada al metodo que nos devolverá el datos buscado
		return materialRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.MaterialService#reportMateriales()
	 */
	//Creamos un metodo que usará Jasper para recoger mediante un for todos los datos de los materiales
	@Override
	public List<Map<String, Object>> reportMateriales() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Materiales material : this.findAll()) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("Id", material.getIdMateriales());
			item.put("Nombre", material.getNombre());
			item.put("Precio", material.getPrecio());
			result.add(item);
		}
		//Nos devuelve un arrylis con los datos buscados
		return result;
	}

	

}
