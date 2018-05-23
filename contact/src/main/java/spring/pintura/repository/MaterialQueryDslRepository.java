//Esta clase es la utilizada para realizar un busqueda de materiales mediante QueryDSL
package spring.pintura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

import spring.pintura.entity.Materiales;
import spring.pintura.entity.QMaterial;

// TODO: Auto-generated Javadoc
/**
 * The Class MaterialQueryDslRepository.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("materialesQueryDslRepository")
public class MaterialQueryDslRepository {

	/** The material. */
	// Creamos un objeto de QMaterial que usaremos para las busquedas
	private QMaterial material = QMaterial.material;

	/** The em. */
	// @PersistenceContext representa las entidades que contienen datos y
	// están calificadas para persistir en algún almacenamiento persistente como una
	// base de datos
	@PersistenceContext
	private EntityManager em;


	/**
	 * Search materiales.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param pMin the min
	 * @param pMax the max
	 * @return the list
	 */
	//Creamos un metodo de busqueda donde recibimos por parametro el/los datos por los que buscar
	public List<Materiales> searchMateriales(Integer id, String nombre, Double pMin, Double pMax) {

		List<Materiales> searchMateriales = null;

		//Creamos un objeto JPAQuery con el cual podremos acceder a algunos metodos para realizar acciones con los datos(base de datos)
		JPAQuery<Materiales> query = new JPAQuery<Materiales>(em);

		//Creamos una serie de if para saber que campo de busqueda es null, y en caso de que no lo sea armamos la consulta
		//usando QueryDsl para buscar el material por los datos pasado
		if (id != null) {

			searchMateriales = (List<Materiales>) query.select(material).from(material).where(material.idMateriales.eq(id)).fetch();

		}
		
		if (!nombre.equals("") && pMax != null && pMin != null) {

			searchMateriales = (List<Materiales>) query.select(material).from(material).where(material.nombre.containsIgnoreCase(nombre).and(material.precio.between(pMax, pMin)))
					.fetch();

		}

		if (!nombre.equals("")) {

			searchMateriales = (List<Materiales>) query.select(material).from(material).where(material.nombre.containsIgnoreCase(nombre))
					.fetch();

		}

		if (pMax != null && pMin != null) {
			searchMateriales = (List<Materiales>) query.select(material).from(material).where(material.precio.between(pMax, pMin))
					.fetch();

		}

		//Y retornamos el listado de materiales(List)
		return searchMateriales;

		// List <Course> courses
		// =query.select(com).from(qCourse).where(qCourse.hours.between(10,
		// 30)).fetch();
	}

}
