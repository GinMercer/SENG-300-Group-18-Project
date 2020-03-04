package loginwindow;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class login extends JPanel {
	/**
	 * 
	 */

	private JTextField textUser;
	private JPasswordField textPass;

	
	public login(JFrame frame, authenticator auth) {
		setBackground(Color.GRAY);
		
		JLabel lblWelcomeToOpen = new JLabel("Welcome to Open Journal Submission System");
		lblWelcomeToOpen.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOpen.setBounds(89, 53, 526, 30);
		lblWelcomeToOpen.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(195, 183, 92, 22);
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(195, 253, 87, 22);
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		textUser = new JTextField();
		textUser.setBounds(331, 178, 180, 32);
		textUser.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textUser.setColumns(10);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		loginbtn.setBounds(411, 339, 100, 40);
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String user = textUser.getText();
				String pass = String.valueOf( textPass.getPassword());
				auth.login(user, pass);
				
				
				if ((user == null || user.isEmpty()) && (pass == null || pass.isEmpty())) {
					JOptionPane.showMessageDialog(null, "Please enter username and password", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //JOptionPane.showMessageDialog(null, "Please enter username and password", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                } else if (user == null || user.isEmpty()){
                	JOptionPane.showMessageDialog(null, "Please enter username", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (pass == null || pass.isEmpty()){
                	JOptionPane.showMessageDialog(null, "Please enter password", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				register panel = new register(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
			
		btnRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnRegister.setBounds(220, 339, 120, 40);	
			
		setLayout(null);
		add(lblWelcomeToOpen);
		add(lblPassword);
		add(lblUsername);
		add(textUser);
		add(btnRegister);
		add(loginbtn);
		
		textPass = new JPasswordField();
		textPass.setBounds(331, 243, 180, 32);
		add(textPass);

	}
}
