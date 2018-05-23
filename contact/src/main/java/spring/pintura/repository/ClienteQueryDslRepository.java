//Esta clase es la utilizada para realizar un busqueda de clientes mediante QueryDSL
package spring.pintura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import spring.pintura.entity.Cliente;
import spring.pintura.entity.QCliente;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteQueryDslRepository.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("clienteQueryDslRepository")

public class ClienteQueryDslRepository {
	
	/** The q cliente. */
	//Creamos un objeto de QCliente que usaremos para las busquedas
	private QCliente qCliente = QCliente.cliente;
	 
	 /** The em. */
	//@PersistenceContext representa las entidades que contienen datos y
	//están calificadas para persistir en algún almacenamiento persistente como una base de datos
 	@PersistenceContext
	 private EntityManager em;
	 
		/**
		 * Search clientes.
		 *
		 * @param busqueda the busqueda
		 * @return the list
		 */
 	//Creamos un metodo de busqueda donde recibimos por parametro el/los datos por los que buscar
		public List<Cliente> searchClientes(String busqueda) {
			//Creamos un objeto JPAQuery con el cual podremos acceder a algunos metodos para realizar acciones con los datos(base de datos)
			JPAQuery<Cliente> query = new JPAQuery<Cliente>(em);

	
			//Añadimos a nuestro list de Cliente los datos del cliente buscado en función de la busqueda
			List<Cliente> searchClientes = (List<Cliente>) query.select(qCliente).from(qCliente).where(qCliente.dni.containsIgnoreCase(busqueda).or(qCliente.nombre.containsIgnoreCase(busqueda).or(qCliente.apellidos.containsIgnoreCase(busqueda)).or(qCliente.telefono.containsIgnoreCase(busqueda)))).fetch();
			
			//Retornamos el List con los datos del cliente buscado
			return searchClientes;
		}

}
