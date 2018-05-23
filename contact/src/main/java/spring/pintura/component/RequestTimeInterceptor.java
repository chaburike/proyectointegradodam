//requestTimeInterceptor es un componente usado para controlar el tiempo que tarda en realizar una petición y en ser
//atendida
package spring.pintura.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestTimeInterceptor.
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	/** The Constant LOG. */
	// Creamos un Log en el que mostraremos los mensajes por consola
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	// primero: al entrar en el metodo, justo en su ejecucion
	@Override
	// Se ejecuta Primero: al entrar en el metodo, justo en su ejecucion
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	//segundo: antes del return
	@Override
	// Se ejecuta Segundo una vez se ha completado la petición
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("Url to:'" + request.getRequestURL().toString() + "' in: '" + (System.currentTimeMillis()-startTime + "'ms"));
	}


	
	

}
