//Clase creada para controlar la seguridad de la aplicacion
package spring.pintura.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfiguration.
 */
@Configuration// Especificamos que es una clase de configuracion (se crea cuando algun tipo de
				// configuracion no se puede especifcar en el yml)
@EnableWebSecurity// Esta etiqueta sirve para habilitar la seguridad web
//Al usar @EnableGlobalMethodSecurity, podemos asegurar fácilmente nuestros métodos con la configuración de Java
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{// extendiendo la clase
																		// WebSecurityConfigurerAdapter podemos
																		// configurar y activar la seguridad

	
	/** The user service. */
	// Hacemos una inyección de dependencias del servicio userService
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;
	
	/**
	 * Configure global.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());// BCryptPasswordEncoder() encripta la clave password
		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	// Metodo para configurar diversos apartados sobre la seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {// Sobre-escribimos configure() para habilitar la
																	// protección de las URL,
																	// .anyRequest().authenticated()
		// indica que todas las peticiones estarán protegidas, es decir requerimos
		// autenticarnos para poder acceder a cualquier parte del sitio, httpBasic(),etc
		http.authorizeRequests()
		.antMatchers("/css/*", "/imgs/*").permitAll()// Esto permitira que se carguen los
													// recursos estaticos(css y imagenes)
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/loginsuccess").permitAll()
		.and()
		.logout().logoutUrl("/logaut").logoutSuccessUrl("/login?logaut")
		.permitAll();
	}

}
