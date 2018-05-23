//Esta es una clase creada para cotnrolar y ofrecer seguridad, en este caso al logeo
package spring.pintura.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity// Especifica que voy a crear una entidad. Se coloca al inicio de la definición de la clase.
@Table(name="users")// Especificamos el nombre de la tabla que se va a crear, en este caso "users"
public class User {
	
	/** The id materiales. */
	@Id // Nombramos la id(idMateriales) con la anotación de spring @Id(Primary key de la
		// entidad.)
	@GeneratedValue (strategy=GenerationType.IDENTITY)// Indica que esa clave(el Id) se auto genera por medio de auto
													// increment
	@Column(name="idUsuarios")// Lo anotamos con @Column(anotaremos así todos los atributos de nuestras
							// entidades)
	public int idUsuarios;//Columna id de la base de datos
	
	/** The nombre. */
	@Column(name="username")
	private String username;//Columna username de la base de datos
	
	/** The password. */
	@Column(name="password", unique=true, nullable=false, length= 60)
	private String password;
	
	/** The enabled. */
	@Column(name="enable", nullable=false)
	private boolean enabled;
	
	/** The user role. */
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user")// Hacemos una relación @OneToMany(es decir, un solo usuario
														// puede tener varios roles)
	private Set<UserRole> userRole = new HashSet<UserRole>();// Creamos una colección temporal que almacenará los roles
	// de los usuarios
	
	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 */
	// Constructor con los parametros username, password y enabled
	public User(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 * @param userRole the user role
	 */
	// Creamos un constructor con todos los atributos
	public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	/**
	 * Instantiates a new user.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public User() {}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	// Metodos get y set sobre los datos
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	
	public int getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the user role
	 */
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole the new user role
	 */
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [idUsuarios=" + idUsuarios + ", username=" + username + ", password=" + password + ", enabled="
				+ enabled + ", userRole=" + userRole + "]";
	}
	
	
}
