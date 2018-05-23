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
import spring.pintura.entity.Factura;
import spring.pintura.entity.FacturasMateriales;
import spring.pintura.repository.ClienteRepository;
import spring.pintura.repository.FacturaRepository;
import spring.pintura.repository.FacturasMaterialesRepository;
import spring.pintura.repository.MaterialesRepository;
import spring.pintura.service.FacturasMaterialesService;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturasMaterialesServiceImpl.
 */
//La clase define un servicio
@Service("facturasMaterialesServiceImpl")
//Implementamos la interfaz FacturasMaterialesService donde se encuentran definidos los metodos
public class FacturasMaterialesServiceImpl implements FacturasMaterialesService {

	/** The facturas materiales repository. */
	// Realizamos una inyección de dependencias del repositorio
	// FacturasMaterialesRepository(FacturasMaterialesRepository)
	// FacturasMaterialesRepository será el repositorio donde tenemos los metodos para hacer la busqueda de facturas
	// por su id
	@Autowired
	@Qualifier("facturaMaterialesRepository")
	public FacturasMaterialesRepository facturasMaterialesRepository;

	/** The cliente repository. */
	// Realizamos una inyección de dependencias del repositorio
	// ClienteRepository(clienteRepository)
	//ClienteRepository será el repositorio donde tenemos un metodo para buscar clientes por dni
	@Autowired
	@Qualifier("clienteRepository")
	private ClienteRepository clienteRepository;

	/** The materiales repository. */
	// Realizamos una inyección de dependencias del repositorio
	// MaterialesRepository(materialRepository)
	//MaterialesRepository será el repositorio donde tenemos un metodo para buscar materiales por id
	@Autowired
	@Qualifier("materialesRepository")
	private MaterialesRepository materialRepository;

	/** The factura repository. */
	// Realizamos una inyección de dependencias del repositorio
	// FacturaRepository(facturaRepository)
	//FacturaRepository será el repositorio donde tenemos un metodo para buscar facturas por id
	@Autowired
	@Qualifier("facturaRepository")
	public FacturaRepository facturaRepository;

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#listaAllFacturas()
	 */
	//Implementamos el metodo listaAllFacturas(para listar todas las facturas)
	@Override
	public List<FacturasMateriales> listaAllFacturas() {
		//Usamos el metodo findAll() gracias a que el repositorio hereda de Jpa
		return facturasMaterialesRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#addFacturasMateriales(spring.pintura.entity.FacturasMateriales)
	 */
	//Implementamos el metodo addFacturasMateriales(para añadir una factura)
	@Override
	public FacturasMateriales addFacturasMateriales(FacturasMateriales facturasMateriales) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return facturasMaterialesRepository.save(facturasMateriales);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#removeFacturasMateriales(int)
	 */
	//Implementamos el metodo removeFacturasMateriales(para eliminar una factura)
	@Override
	public int removeFacturasMateriales(int id) {
		//Usamos el metodo delete() gracias a que el repositorio hereda de Jpa
		facturasMaterialesRepository.delete(id);
		return 0;
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#updateFacturasMateriales(spring.pintura.entity.FacturasMateriales)
	 */
	//Implementamos el metodo updateFacturasMateriales(para modificar una factura)
	@Override
	public FacturasMateriales updateFacturasMateriales(FacturasMateriales facturasMateriales) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return facturasMaterialesRepository.save(facturasMateriales);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#findFacturasMaterialesById(int)
	 */
	//Implementamos el metodo findFacturasMaterialesById(para buscar una factura por su id)
	@Override
	public FacturasMateriales findFacturasMaterialesById(int id) {
		//Usamos el metodo findById() gracias a que el repositorio hereda de Jpa
		return facturasMaterialesRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#report()
	 */
	//Creamos un metodo que usará Jasper para recoger mediante un for todos los datos de las facturas
	@Override
	public List<Map<String, Object>> report() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (FacturasMateriales facturasMateriales : this.findAll()) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("IdFactura", facturasMateriales.getRelacionIdFactura());
			item.put("IdMateriales", facturasMateriales.getRelacionIdMateriales());
			item.put("Cantidad", facturasMateriales.getCantidad());
			result.add(item);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#findAll()
	 */
	//Creamos un metod iterable que nos retornará todos los clientes
	@Override
	public Iterable<FacturasMateriales> findAll() {

		//Nos retorna una llamada al metodo que nos devolverá el datos buscado
		return facturasMaterialesRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see spring.pintura.service.FacturasMaterialesService#reportFactura(int, java.lang.String)
	 */
	//Creamos un metodo que usará Jasper para recoger mediante un for todos los datos de los facturas
	@Override
	public List<Map<String, Object>> reportFactura(int idFactura, String idCliente) {
		Cliente cliente = clienteRepository.findByDni(idCliente);
		Factura factura = facturaRepository.findByIdFactura(idFactura);

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		for (FacturasMateriales facturasMateriales : this.findAll()) {
			Map<String, Object> item = new HashMap<String, Object>();
			if (facturasMateriales.getRelacionIdFactura().getIdFactura() == idFactura) {
				item.put("IdMateriales", facturasMateriales.getRelacionIdMateriales());
				item.put("Cantidad", facturasMateriales.getCantidad());
				item.put("Precio", facturasMateriales.getRelacionIdMateriales());
				item.put("Dni", cliente.getDni());
				item.put("Nombre", cliente.getNombre());
				item.put("Apellidos", cliente.getApellidos());
				item.put("Telefono", cliente.getTelefono());
				item.put("TOTAL", factura.getPrecio());
				result.add(item);
			}

		}
		//Nos devuelve un arrylis con los datos buscados
		return result;
	}

}
