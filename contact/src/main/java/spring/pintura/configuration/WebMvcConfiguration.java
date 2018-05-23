package spring.pintura.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import spring.pintura.component.RequestTimeInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class WebMvcConfiguration.
 */
@Configuration// Especificamos que es una clase de configuracion (se crea cuando algun tipo de
				// configuracion no se puede especifcar en el yml)
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	/** The request time interceptor. */
	// Hacemos una inyección de dependencias de la clase requestTimeInterceptor
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	// Implementamos el metodo addInterceptors, donde añadiremos el interceptor
	// creado anteriormente para controlar
	// el tiempo en que se sirven las peticiones, dicho metodo añadirá
	// requestTimeInterceptor para que se pueda configurar
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(requestTimeInterceptor);
	}
	

}
