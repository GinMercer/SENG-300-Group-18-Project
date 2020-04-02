package loginwindow;

public class Account {
	
	private String username;
	
	private String password;
	
	private String accountType;
	
	/**
	 * Checks if given input is a valid input for a username (username should not be longer than 16).
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
	 * Checks if given string is a valid length to be taken as a password (password should not be shorter than 8).
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
	public Account(String user, String pass, String accountType) {
		this.username = user;
		this.password = pass;
		this.accountType = accountType;
	}

	public Account() {
		// TODO Auto-generated constructor stub
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
	
	/**
	 * Gets the account type of an Account object
	 * 
	 * @return account type
	 */
	protected String getAccountType() {
		return accountType;
	}
	
	/**
	 * Sets the account type of an Account object
	 * 
	 * @param accountType
	 */
	protected void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
