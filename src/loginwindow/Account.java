package loginwindow;

public class Account {

	private String username;
	
	private String password;

	/**
	 * Checks if given input is a valid input for a username.
	 * 
	 * @param username
	 * @return false if not a valid input, true if valid
	 */
	public static boolean checkUsername(String username) {
		if(username.length() <= 16) {
			return true;
		}
		return false; 
	}
	
	/**
	 * Checks if given string is a valid length to be taken as a password.
	 * 
	 * @param pass
	 * @return true if length is greater than or equal to 8, false otherwise
	 */
	public static boolean checkPassword(String pass) {
		if(pass.length() >= 8) {
			return true;
		}
		return false; 
	}
	
	/**
	 * Constructor for Account object taking a username and password as arguments.
	 * 
	 * @param user
	 * @param pass
	 */
	public Account(String user, String pass) {
		this.username = user;
		this.password = pass;
	}

	/**
	 * Gets the username of an Account object.
	 * 
	 * @return username value of Account instance
	 */
	protected String getUsername() {
		return username;
	}

	/**
	 * Sets the username of an Account instance
	 * 
	 * @param username
	 * @return updates username value of an Account
	 */
	protected boolean setUsername(String username) {
		if(Account.checkUsername(username)) {
			this.username = username;
			return true;
		}
		return false;
	}

	/**
	 * Gets the password of an Account object.
	 * 
	 * @return password value of an Account instance
	 */
	protected String getPassword() {
		return password;
	}

	/**
	 * Sets the password of an Account instance
	 * 
	 * @param password
	 * @return updates password value of an Account
	 */
	protected boolean setPassword(String password) {
		if(Account.checkPassword(password)) {
			this.password = password;
			return true;
		}
		return false;
	}

}
