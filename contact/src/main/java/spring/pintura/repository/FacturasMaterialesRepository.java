//Creamos una clase repositorio donde tendremos un metodo para buscar un material por su Id
package spring.pintura.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.pintura.entity.FacturasMateriales;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturasMaterialesRepository.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("facturaMaterialesRepository")
//Extendemos de JpaRepository para tener toda la funcionalidad y metodos que nos ofrece Jpa
//sobre la clase FacturasMateriales
public interface FacturasMaterialesRepository extends JpaRepository<FacturasMateriales, Serializable>{

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the facturas materiales
	 */
	//Definimos un metodo abstracto FacturasMateriales para buscar por id
	public abstract FacturasMateriales findById(int id);
	
	/**
	 * Find all by id.
	 *
	 * @param id the id
	 * @return the list
	 */
	//Definimos un metodo abstracto con un listado de FacturasMateriales para buscar por id
	public abstract List<FacturasMateriales> findAllById(int id);
	
	
	
}
