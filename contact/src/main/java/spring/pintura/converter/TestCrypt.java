//Esta clase es la encargada de encriptar la clave del usuario
package spring.pintura.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCrypt.
 */
public class TestCrypt {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creamos un objeto BCryptPasswordEncoder para encriptar nuestra contraseña
		BCryptPasswordEncoder pe=new BCryptPasswordEncoder();
		//Llamamos al objeto creado y encriptamos la contraseña pasada
		System.out.println(pe.encode("prueba"));

	}

}
