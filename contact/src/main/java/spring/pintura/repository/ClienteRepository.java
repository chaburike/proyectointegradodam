//Creamos una clase repositorio donde tendremos un metodo para buscar un cliente por su Id
package spring.pintura.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.pintura.entity.Cliente;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClienteRepository.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("clienteRepository")
//Extendemos de JpaRepository para tener toda la funcionalidad y metodos que nos ofrece Jpa
//sobre la clase Cliente
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {
	
	/**
	 * Find by dni.
	 *
	 * @param dni the dni
	 * @return the cliente
	 */
	//Definimos un metodo abstracto Cliente para buscar por dni
	public abstract Cliente findByDni(String dni);

}
