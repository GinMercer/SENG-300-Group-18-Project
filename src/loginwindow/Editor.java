package basicloginapp;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editor extends JPanel {

	/**
	 * Create the panel.
	 */
	public Editor(JFrame frame, Authenticator auth) {
		setBackground(Color.BLACK);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login panel = new Login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Editor Page");
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);

	}

}
