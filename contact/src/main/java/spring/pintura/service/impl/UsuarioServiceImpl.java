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
import spring.pintura.entity.User;
import spring.pintura.repository.UserRepository;
import spring.pintura.service.UsuarioService;

//TODO: Auto-generated Javadoc
/**
* The Class MaterialServiceImpl.
*/
//La clase define un servicio
@Service("UsuarioService")
//Implementamos la interfaz UsuarioService donde se encuentran definidos los metodos
public class UsuarioServiceImpl implements UsuarioService{
	/** The user repository. */
	// Realizamos una inyección de dependencias del repositorio
	// UserRepository(userRepository)
	// UserRepository será el repositorio donde tenemos los metodos para hacer la busqueda de usuarios
	// por su nombre
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public User addUsuarios(User usuario) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return userRepository.save(usuario);
	}

	@Override
	public List<User> listAllUsuarios() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Iterable<User> findAll() {

		//Nos retorna una llamada al metodo que nos devolverá el datos buscado
		return userRepository.findAll();
	}

	@Override
	public List<Map<String, Object>> reportUsuarios() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (User users : this.findAll()) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("Dni", users.getUsername());
			item.put("Nombre", users.getPassword());
			//item.put("Apellidos", users.getUserRole());
			result.add(item);
		}
		//Nos devuelve un arraylist con los datos buscados
		return result;
	}

	@Override
	public User findUsuarioById(int idUsuarios) {
		//Usamos el metodo findUsuarioByNombre() gracias a que el repositorio hereda de Jpa
		return userRepository.findByidUsuarios(idUsuarios);
	}

	@Override
	public int removeUsuario(int idUsuarios) {
		//Usamos el metodo delete() gracias a que el repositorio hereda de Jpa
		userRepository.delete(idUsuarios);
		return 0;
	}

	@Override
	public User updateUsuarios(User user) {
		//Usamos el metodo save() gracias a que el repositorio hereda de Jpa
		return userRepository.save(user);
	}

}
