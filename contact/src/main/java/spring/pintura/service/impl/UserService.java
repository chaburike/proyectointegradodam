//Creamos un servicio que hará uso de los metodos definidos en su correspondiente interfaz
package spring.pintura.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.pintura.entity.User;
import spring.pintura.entity.UserRole;
import spring.pintura.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
//La clase define un servicio
@Service("userService")
//Implementamos la clase UserDetailsService
public class UserService implements UserDetailsService{
	
	/** The user repository. */
	// Realizamos una inyección de dependencias del repositorio
	// UserRepository(userRepository)
	// UserRepository será el repositorio donde tenemos los metodos para hacer la busqueda de usuarios
	// por su nombre
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	//Implementamos el metodo loadUserByUsername para comprobar que el usuario es correcto y existe en la
	//base de datos
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		spring.pintura.entity.User user= userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	/**
	 * Builds the user.
	 *
	 * @param user the user
	 * @param authorities the authorities
	 * @return the org.springframework.security.core.userdetails. user
	 */
	//Comprobamos la autoridad que tiene dicho usuario y lo "creamos"
	private org.springframework.security.core.userdetails.User buildUser(User user,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	/**
	 * Builds the authorities.
	 *
	 * @param userRoles the user roles
	 * @return the list
	 */
	//Asignamos el role de usuario que disponga
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(UserRole userRole: userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}

}
