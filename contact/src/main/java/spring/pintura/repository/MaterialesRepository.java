//Creamos una clase repositorio donde tendremos un metodo para buscar un material por su Id
package spring.pintura.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.pintura.entity.Materiales;

// TODO: Auto-generated Javadoc
/**
 * The Interface MaterialesRepository.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("materialesRepository")
//Extendemos de JpaRepository para tener toda la funcionalidad y metodos que nos ofrece Jpa
//sobre la clase Materiales
public interface MaterialesRepository extends JpaRepository<Materiales, Serializable>   {
	
	/**
	 * Find by id materiales.
	 *
	 * @param id the id
	 * @return the materiales
	 */
	//Definimos un metodo abstracto Materiales para buscar por id
	public abstract Materiales findByIdMateriales(int id);

}
