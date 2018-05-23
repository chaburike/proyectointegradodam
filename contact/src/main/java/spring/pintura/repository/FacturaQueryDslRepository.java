//Creamos una clase repositorio donde tendremos un metodo que hará las funciones de un buscador para facturas
package spring.pintura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import spring.pintura.entity.Factura;
import spring.pintura.entity.QFactura;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaQueryDslRepository.
 */
@Repository("facturaQueryDslRepository")
public class FacturaQueryDslRepository {
	
	/** The factura. */
	private QFactura factura=QFactura.factura;
	
	/** The em. */
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Search facturas.
	 *
	 * @param id the id
	 * @param precio the precio
	 * @param dni the dni
	 * @return the list
	 */
	//Creamos un metodo de busqueda donde recibimos por parametro el/los datos por los que buscar
	public List<Factura> searchFacturas(Integer id, Double precio, String dni){
		List<Factura> searchFacturas = null;

		//Creamos un objeto JPAQuery con el cual podremos acceder a algunos metodos para realizar acciones con los datos(base de datos)
		JPAQuery<Factura> query = new JPAQuery<Factura>(em);
		
		//Creamos una serie de if para saber que campo de busqueda es null, y en caso de que no lo sea armamos la consulta
		//usando QueryDsl para buscar al factura por los datos pasados
		if (id!=null) {
			searchFacturas= (List<Factura>) query.select(factura).from(factura).where(factura.idFactura.eq(id)).fetch();
		}
		
		if (precio!=null) {
			searchFacturas=(List<Factura>) query.select(factura).from(factura).where(factura.precio.eq(precio)).fetch();
		}
		
		if (!dni.equalsIgnoreCase("")) {
			searchFacturas=(List<Factura>) query.select(factura).from(factura).where(factura.cliente.dni.eq(dni))
					.fetch();
		}
		if (!dni.equalsIgnoreCase("") && precio!=null && id!=null) {
			searchFacturas=(List<Factura>) query.select(factura).from(factura).where(factura.cliente.dni.eq(dni).and(factura.precio.eq(precio).and(factura.idFactura.eq(id))))
					.fetch();
			
		}
		//Y retornamos el listado de facturas(List)
		return searchFacturas;
	}

}
