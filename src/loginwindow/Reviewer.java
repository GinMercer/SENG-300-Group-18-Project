package loginwindow;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Reviewer extends JPanel {

	/**
	 * Create the panel.
	 */
	public Reviewer(JFrame frame, Authenticator auth) {
		setBackground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(227, 52, 75, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login panel = new login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		setLayout(null);
		add(btnNewButton);
		
		JLabel lblreveiwerpage = new JLabel("Reviewer Page");
		lblreveiwerpage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblreveiwerpage.setBounds(310, 42, 194, 40);
		add(lblreveiwerpage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"haskell", "prolog", "java"}));
		comboBox.setBounds(170, 150, 220, 40);
		add(comboBox);
		
		JLabel lblpapershouldview = new JLabel("Paper should view");
		lblpapershouldview.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblpapershouldview.setBounds(180, 125, 220, 29);
		add(lblpapershouldview);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnDone.setBounds(421, 156, 117, 29);
		add(btnDone);

	}

}
