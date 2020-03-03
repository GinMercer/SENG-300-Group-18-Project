package basicloginapp;

public class Account {
	
	private String username;
	
	private String password;

	public static boolean checkUsername(String username) {
		if(username.length() <= 16) {
			return true;
		}
		return false; 
	}
	
	public static boolean checkPassword(String pass) {
		if(pass.length() >= 8) {
			return true;
		}
		return false; 
	}
	
	public Account(String user, String pass) {
		this.username = user;
		this.password = pass;
	}

	protected String getUsername() {
		return username;
	}

	protected boolean setUsername(String username) {
		if(Account.checkUsername(username)) {
			this.username = username;
			return true;
		}
		return false;
	}

	protected String getPassword() {
		return password;
	}

	protected boolean setPassword(String password) {
		if(Account.checkPassword(password)) {
			this.password = password;
			return true;
		}
		return false;
	}

}
