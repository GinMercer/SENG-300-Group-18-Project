/**
 * 
 */
package loginwindow;

import java.util.HashMap;


public class authenticator {
	
	private HashMap<String, Account> accounts = new HashMap<String, Account>();

	/**
	 * Default constructor for authenticator
	 */
	public authenticator() {
		//Auto-generated constructor stub
	}
	
	/**
	 * Registers a new Account given a username and password
	 * 
	 * @param username
	 * @param password
	 * @return checks the inputs against the database and outputs if the registration was a success or if there exists an issue 
	 */
	public String register(String username, String password) {
		
		boolean correctuser = Account.checkUsername(username);
		boolean correctpass = Account.checkPassword(password);
		boolean notsameuser = !accounts.containsKey(username);
		
		if(correctuser && correctpass && notsameuser) {
			accounts.put(username, new Account(username, password));
			return "Works";
		}
		if(!correctuser) {
			return "Invalid username";
		}
		if(!correctpass) {
			return "Invalid password";
		}
		if(!notsameuser) {
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
				System.out.println("fall to login, please check your password");
				return null;
			}
		}
		else {
			System.out.println("cannot find user, please click register to create a new account");
			return null;
		}
	}

}
