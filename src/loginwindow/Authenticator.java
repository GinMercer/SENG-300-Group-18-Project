/**
 * 
 */
package loginwindow;

import java.util.HashMap;


public class Authenticator {
	
	private HashMap<String, Account> accounts = new HashMap<String, Account>();

	/**
	 * Default constructor for authenticator
	 */
	public Authenticator() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Registers a new Account given a username and password
	 * 
	 * @param username
	 * @param password
	 * @return checks the inputs against the database and outputs if the registration was a success or if there exists an issue 
	 */
	public String register(String username, String password, String acctType) {
		boolean correctuser = Account.checkUsername(username);
		boolean correctpass = Account.checkPassword(password);
		boolean notsameuser = !accounts.containsKey(username);
		if(correctuser && correctpass && notsameuser) {
			accounts.put(username, new Account(username, password, acctType));
			System.out.println("Works");
			return "Works";
		}
		if(!correctuser) {
			System.out.println("Invalid username");
			return "Invalid username";
		}
		if(!correctpass) {
			System.out.println("Invalid password");
			return "Invalid password";
		}
		if(!notsameuser) {
			System.out.println("Username taken");
			return "Username taken";
		}
		return "Unknown issue"; 
	}
	
	/**
	 * Takes a username and a password and attempts a login into the system
	 * 
	 * @param username
	 * @param password
	 * @return if the login was successful or null (either when username is not found or password is incorrect)
	 */
	public Account login(String username, String password) {
		if(accounts.containsKey(username)) {
			System.out.println("found users");
			if(accounts.get(username).getPassword().equals(password)) {
				return accounts.get(username);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

}
