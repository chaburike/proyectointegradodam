//Creamos una clase que hace la funcionalidad de Spring Batch, es decir, es una aplicación que hace una actividad repetitiva de forma
//iterativa, en este caso nos muestra la hora y la fecha del sistema refrescandose cada 5 segundos
package spring.pintura.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//Establecemos como @Component, que es un estereotipo general y permite anotar un bean 
//para que Spring lo considere uno de sus objetos.
@Component("taskComponent")
public class TaskComponent {

	// Creamos un Log en el que mostraremos los mensajes por consola
		private static final Log LOG= LogFactory.getLog(TaskComponent.class);
		
		//Si necesitamos ejecutar tareas automáticamente y de forma periódica, es recomendable usar la anotación @Scheduled
		//Definimos un tiempo de 5000 milisegundos(5 segundos)
		@Scheduled(fixedDelay=5000)
		public void doTask() {
			//Creamos un log para que nos muestre los datos
			LOG.info("TIME IS: "+ new Date());
		}
	
}
