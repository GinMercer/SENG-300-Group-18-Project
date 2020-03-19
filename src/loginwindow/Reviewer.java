package basicloginapp;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reviewer extends JPanel {

	/**
	 * Create the panel.
	 */
	public Reviewer(JFrame frame, authenticator auth) {
		setBackground(Color.DARK_GRAY);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login panel = new login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Reviewer Page");
		add(lblNewLabel);

	}

}
