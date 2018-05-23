//Creamos una funcion(varias) para contar la cantidad de X cosa, por ejemplo contar la cantidad de clientes
package spring.pintura.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class FuncionContarClientes.
 */
//Spring permite la creación automática de beans de acceso a datos mediante la anotación @Repository
@Repository("funcionContarClientes")
public class FuncionContarClientes {
	
	//Definimos las variables para llamar a la base de datos en función de cada metodo a contar
	/** The call funcion clientes. */
	private SimpleJdbcCall callFuncionClientes;
	
	/** The call funcion facturas. */
	private SimpleJdbcCall callFuncionFacturas;
	
	/** The call funcion materiales. */
	private SimpleJdbcCall callFuncionMateriales;
	
	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	//Creamos un metodo setDataSource que harán la llamada a la base de datos para ejecutar el metodo
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		jdbc.setResultsMapCaseInsensitive(true);
		//Hacemos la llamada a la función de la base de datos y se lo asignamos a la variable
		this.callFuncionClientes=new SimpleJdbcCall(jdbc).withFunctionName("contarClientes");
	}
	
	/**
	 * Sets the data source 2.
	 *
	 * @param dataSource the new data source 2
	 */
	//Creamos un metodo setDataSource que harán la llamada a la base de datos para ejecutar el metodo
	@Autowired
	public void setDataSource2(DataSource dataSource) {
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		jdbc.setResultsMapCaseInsensitive(true);
		//Hacemos la llamada a la función de la base de datos y se lo asignamos a la variable
		this.callFuncionFacturas=new SimpleJdbcCall(jdbc).withFunctionName("contarFacturas");
	}
	
	/**
	 * Sets the data source 3.
	 *
	 * @param dataSource the new data source 3
	 */
	//Creamos un metodo setDataSource que harán la llamada a la base de datos para ejecutar el metodo
	@Autowired
	public void setDataSource3(DataSource dataSource) {
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		jdbc.setResultsMapCaseInsensitive(true);
		//Hacemos la llamada a la función de la base de datos y se lo asignamos a la variable
		this.callFuncionMateriales=new SimpleJdbcCall(jdbc).withFunctionName("contarMateriales");
	}
	
	/**
	 * Gets the contar clientes.
	 *
	 * @param var the var
	 * @return the contar clientes
	 */
	//Metodo para contar los clientes
	public Integer getContarClientes(Integer var) {
		//Asignamos a la variable total el resultado al ejecutar la función de contar clientes
		Integer total=callFuncionClientes.executeFunction(Integer.class, 0);		
		return total;
	}
	
	/**
	 * Gets the contar materiales.
	 *
	 * @param var the var
	 * @return the contar materiales
	 */
	//Metodo para contar los materiales
	public Integer getContarMateriales(Integer var) {
		//Asignamos a la variable total el resultado al ejecutar la función de contar clientes
		Integer total=callFuncionMateriales.executeFunction(Integer.class, 0);
		//Retornamos el resultado de la función
		return total;
	}
	
	/**
	 * Gets the contar factura.
	 *
	 * @param var the var
	 * @return the contar factura
	 */
	//Metodo para contar las facturas
	public Integer getContarFactura(Integer var) {
		//Asignamos a la variable total el resultado al ejecutar la función de contar facturas
		Integer total=callFuncionFacturas.executeFunction(Integer.class, 0);
		//Retornamos el resultado de la función
		return total;
	}
	
	
	
}
