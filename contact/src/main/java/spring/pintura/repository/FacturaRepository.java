//Creamos una clase repositorio donde tendremos un metodo para buscar un material por su Id
package spring.pintura.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.pintura.entity.Factura;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaRepository.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("facturaRepository")
//Extendemos de JpaRepository para tener toda la funcionalidad y metodos que nos ofrece Jpa
//sobre la clase Factura
public interface FacturaRepository extends JpaRepository<Factura, Serializable>{
	
	/**
	 * Find by id factura.
	 *
	 * @param id the id
	 * @return the factura
	 */
	//Definimos un metodo abstracto Factura para buscar por id
	public abstract Factura findByIdFactura(int id);

}
