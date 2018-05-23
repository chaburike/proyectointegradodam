//Esta clase es la encargada de convertir un objeto de entidad a modelo y viceversa
package spring.pintura.converter;

import org.springframework.stereotype.Component;

import spring.pintura.entity.Cliente;
import spring.pintura.model.ClienteModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteConverter.
 */
//Establecemos como @Component, que es un estereotipo general y permite anotar un bean 
//para que Spring lo considere uno de sus objetos.
@Component("clienteConverter")
public class ClienteConverter {
	
	/**
	 * Entity model.
	 *
	 * @param clientes the clientes
	 * @return the cliente model
	 */
	//Creamos el metodo entityModel que recibirá por parametro un cliente entidad y lo transformará a un objeto cliente modelo
	//Convertimos de entity a model
	public ClienteModel entityModel(Cliente clientes) {
		//Creamos un nuevo objeto clientemodel
		ClienteModel clienteModel = new ClienteModel();
		//Asignamos al nuevo objeto cliente los datos pertinentes(nombre, apellidos, dni y telefono)
		clienteModel.setNombre(clientes.getNombre());
		clienteModel.setApellidos(clientes.getApellidos());
		clienteModel.setdni(clientes.getDni());
		clienteModel.setTelefono(clientes.getTelefono());
		//Devolvemos el objeto clienteModel(hemos convertido una entidad cliente a un modelo cliente)
		return clienteModel;
	}
	
	/**
	 * Model entity.
	 *
	 * @param clienteModel the cliente model
	 * @return the cliente
	 */
	//Creamos el metodo modelEntity que recibirá por parametro un cliente modelo y lo transformará a un objeto cliente entidad
	//Convertimos de model a entity
		public Cliente modelEntity(ClienteModel clienteModel) {
			//Creamos un nuevo objeto clienteentity
			Cliente clientesEntity = new Cliente();
			//Asignamos al nuevo objeto cliente los datos pertinentes(nombre, apellidos, dni y telefono)
			clientesEntity.setNombre(clienteModel.getNombre());
			clientesEntity.setApellidos(clienteModel.getApellidos());
			clientesEntity.setDni(clienteModel.getdni());
			clientesEntity.setTelefono(clienteModel.getTelefono());
			//Devolvemos el objeto clientesEntity(hemos convertido un modelo cliente a una entidad cliente)
			return clientesEntity;
		}


}
