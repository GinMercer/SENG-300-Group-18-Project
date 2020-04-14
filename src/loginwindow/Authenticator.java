/**
 * 
 */
package loginwindow;

import java.util.HashMap;
import java.io.File;
import java.util.ArrayList;


public class Authenticator {
	
	private HashMap<String, Account> accounts = new HashMap<String, Account>();
	
	private Paper thePaper = new Paper();
	
	private File theFile = new File("None");
	
	private String accountNameForResearch;
	
	private String accountNameForEditor;
	
	private ArrayList<String> editorList = new ArrayList();
	
	private ArrayList<String> reviewerList = new ArrayList();

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
	
	/**
	 * Checks to see if the account is in the database
	 * @param key
	 * @return Returns the account name
	 */
	public String checkAccountName(String key) {
		if (accounts.containsKey(key)) {
			System.out.println("true");
			return accounts.get(key).getUsername();
		} else {
			System.out.println("false");
			return null;
		}
	}
	
	public ArrayList allAccounts() {
		ArrayList<Account> allaccount = new ArrayList<Account>();
		for (Account i : accounts.values()) {
			allaccount.add(i);
		}
		return allaccount;
	}
	
	public void changeFile(File theFile2) {
		this.theFile = theFile2;
	}
	
	public Paper getPaper() {
		return this.thePaper;
	}
	
	public String getFileName() {
		return this.theFile.getName();
	}
	
	public void setAccountNameReviewer(String name) {
		this.accountNameForResearch = name;
	}
	
	public String getAccountNameReview( ) {
		return this.accountNameForResearch;
	}
	
	public String getAccountNameEditor() {
		return this.accountNameForEditor;
	}
	
	public void setAccountNameEditor(String name) {
		this.accountNameForEditor = name;
	}
	
	public ArrayList getEditorList() {
		for (int i = 0; i < this.allAccounts().size(); i++) {
			Account accountIteration = new Account();
			accountIteration = (Account)this.allAccounts().get(i);
			if (accountIteration.getAccountType() == "Editor") {
				String nameEditor = accountIteration.getUsername();
				this.editorList.add(nameEditor);
			}
		}
		
		return editorList;
	}
	
	public ArrayList getReviewerList() {
		for (int i = 0; i < this.allAccounts().size(); i++) {
			Account accountIteration = new Account();
			accountIteration = (Account)this.allAccounts().get(i);
			if (accountIteration.getAccountType() == "Reviewer") {
				String name = accountIteration.getUsername();
				reviewerList.add(name);
			}
		}
		
		return reviewerList;
	}

}
