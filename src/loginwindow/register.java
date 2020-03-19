package loginwindow;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class register extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private JPasswordField comfirmpass;
	private JComboBox acctType;

	/**
	 * Create the panel. Constructor for register that takes a JFrame and an authenticator.
	 */
	public register(JFrame frame, authenticator auth) {
		setBackground(new Color(255, 255, 153));
		setLayout(null);
		
		JLabel lblRegisterForAccount = new JLabel("Account Registration");
		lblRegisterForAccount.setBounds(185, 26, 301, 40);
		lblRegisterForAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterForAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		add(lblRegisterForAccount);
		
		JLabel usernamelbl = new JLabel("Username");
		usernamelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		usernamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		usernamelbl.setBounds(101, 120, 151, 40);
		add(usernamelbl);
		
		username = new JTextField();
		username.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		username.setBounds(280, 124, 245, 32);
		add(username);
		username.setColumns(10);
		
		JLabel passwordlbl = new JLabel("Password");
		passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		passwordlbl.setBounds(115, 168, 120, 40);
		add(passwordlbl);
		
		JLabel comfrimpasslbl = new JLabel("Confirm \r\nPassword");
		comfrimpasslbl.setHorizontalAlignment(SwingConstants.CENTER);
		comfrimpasslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		comfrimpasslbl.setBounds(79, 219, 176, 40);
		add(comfrimpasslbl);
		
		
		JButton btnLogin = new JButton("Back");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnLogin.setBounds(115, 346, 93, 40);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				login panel = new login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		add(btnLogin);
		
		password = new JPasswordField();
		password.setBounds(280, 175, 245, 31);
		add(password);
		
		comfirmpass = new JPasswordField();
		comfirmpass.setBounds(280, 226, 245, 31);
		add(comfirmpass);
		
		JButton btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				
				String pass = String.valueOf( password.getPassword());
				String confirm = String.valueOf( comfirmpass.getPassword());
				
				//username and password are both required
				String accountType = String.valueOf(acctType.getSelectedItem());
				System.out.println(accountType);
				
				//System.out.println(pass);
				if(!pass.equals(confirm)) {
					JOptionPane.showMessageDialog(null, "Please check password", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(user == null || user.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid username", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(pass == null || pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid password", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String tmp = auth.register(user, pass, accountType);
				//check if username and password is valid
				if(tmp == "Works") {
					JOptionPane.showMessageDialog(null, "You create your account successfully!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					login panel = new login(frame, auth);
					frame.setContentPane(panel);
					frame.revalidate();
				}
				else if(tmp == "Invalid username"){
					JOptionPane.showMessageDialog(null, "Invalid username", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(tmp == "Invalid password"){
					JOptionPane.showMessageDialog(null, "Invalid password", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(tmp == "Username taken"){
					JOptionPane.showMessageDialog(null, "Username taken", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{
					JOptionPane.showMessageDialog(null, "Unknown issue", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
		btnDone.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnDone.setBounds(425, 346, 100, 40);
		add(btnDone);
		
		acctType = new JComboBox();
		acctType.setFont(new Font("Dialog", Font.PLAIN, 14));
		acctType.setModel(new DefaultComboBoxModel(new String[] {"Researcher", "Reviewer", "Editor"}));
		acctType.setBounds(280, 292, 120, 32);
		add(acctType);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountType.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblAccountType.setBounds(79, 284, 176, 40);
		add(lblAccountType);
		
		

	}
}
