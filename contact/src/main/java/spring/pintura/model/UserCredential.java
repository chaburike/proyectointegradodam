//Esta clase modelo se usa para coger los datos necesarios que serán usado por otras clase
package spring.pintura.model;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCredential.
 */
public class UserCredential {
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The enable. */
	private boolean enable;
	
	/**
	 * Instantiates a new user credential.
	 */
	// Constructor por defecto sobre el que trabaja hibernate
	public UserCredential() {
		
	}
	
	/**
	 * Instantiates a new user credential.
	 *
	 * @param username the username
	 * @param password the password
	 */
	// Creamos un constructor con todos los parametros
	public UserCredential(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	//Metodos get y set sobre los datos
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
	
	

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "UserCredential [username=" + username + ", password=" + password + ", enable=" + enable + "]";
	}
	
	
	


}
