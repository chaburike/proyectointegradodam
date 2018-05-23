//Esta es una clase creada para cotnrolar y ofrecer seguridad, en este caso al logeo
package spring.pintura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


// TODO: Auto-generated Javadoc
/**
 * The Class UserRole.
 */
@Entity// Especifica que voy a crear una entidad. Se coloca al inicio de la definición
		// de la clase.	
@Table(name="user_roles", uniqueConstraints = @UniqueConstraint(// uniqueConstraints para garantizar que no se
		// escriben valores duplicados en columnas específicas que no forman parte de una clave principal
		columnNames= {"role", "username"}))// Colocamos las columnas a las que hará referencia
public class UserRole {
	
	/** The user role id. */
	@Id// Nombramos la id(user_role_id) con la anotación de spring @Id(Primary key de
	// la entidad.)
	@GeneratedValue// Indica que esa clave(el Id) se auto genera por medio de auto increment
	@Column(name="user_role_id", unique=true, nullable=false)// Lo anotamos con @Column(anotaremos así todos los
	// atributos de nuestras entidades) y con los atributos unique(que no se pueda repetir) y nullable(que no puede ser nulo)
	
	private int userRoleId;// El id de dicho usuario(roleId)
	
	/** The user. */
	@ManyToOne(fetch = FetchType.EAGER)// Hacemos una relación ManyToOne(es decir, varios roles pueden pertenecer a un
	// solo usuario)
	@JoinColumn(name="username", nullable=false)// Indicamos la tabla con la que queremos hacer la relación, en
	// este caso "username"
	
	private User user;// Es el user al que hace referencia
	
	/** The role. */
	@Column(name="role", nullable=false, length=45)// Rol de usuario(Por ejemplo, usuario, administrador, etc)
	private String role;
	
	/**
	 * Instantiates a new user role.
	 *
	 * @param user the user
	 * @param role the role
	 */
	// Constructor con los parametros user y role
	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}
	
	/**
	 * Instantiates a new user role.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public UserRole() {}

	/**
	 * Gets the user role id.
	 *
	 * @return the user role id
	 */
	// Metodos get y set sobre los datos
	public int getUserRoleId() {
		return userRoleId;
	}

	/**
	 * Sets the user role id.
	 *
	 * @param userRoleId the new user role id
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
