//Creamos una clase repositorio donde tendremos un metodo para buscar un usuarios por su nombre
package spring.pintura.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.pintura.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("userRepository")
//Extendemos de JpaRepository para tener toda la funcionalidad y metodos que nos ofrece Jpa
//sobre la clase User
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	//Definimos un metodo abstracto User para buscar por su nombre
	public abstract User findByidUsuarios(int idUsuarios);

	public abstract User findByUsername(String username);

}
