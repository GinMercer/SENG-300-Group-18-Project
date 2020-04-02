package loginwindow;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Reviewer extends JPanel {
	private JTextField txtNowReviewing;
	private JTextField chosenBy;

	/**
	 * Create the panel.
	 */
	public Reviewer(JFrame frame, Authenticator auth) {
		setBackground(Color.GRAY);
		
		// Adds the back button
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(20, 11, 75, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login panel = new login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		setLayout(null);
		add(btnNewButton);
		
		// This is the label for the title, Reviewer Page
		JLabel lblreveiwerpage = new JLabel("Reviewer Page");
		lblreveiwerpage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblreveiwerpage.setBounds(306, 11, 194, 40);
		add(lblreveiwerpage);
		
		// Create a new comboBox, for the dropdown menu to select what to review
		JComboBox viewTab = new JComboBox();
		
		// This checks for the event that if you selected a new item on the combo box
		viewTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selectedReviewer = (String) combo.getSelectedItem();
				
				viewTab.removeItem("none");
				
				txtNowReviewing = new JTextField();
				txtNowReviewing.setText(selectedReviewer);
				txtNowReviewing.setBounds(464, 132, 86, 20);
				add(txtNowReviewing);
				txtNowReviewing.setColumns(10);
				
				System.out.println(selectedReviewer);
			}
		});
		viewTab.setFont(new Font("Dialog", Font.PLAIN, 14));
		viewTab.setModel(new DefaultComboBoxModel(new String[] {"none","Haskell", "Prolog", "Java"}));
		viewTab.setBounds(20, 120, 220, 40);
		add(viewTab);
		
		JLabel lblpapershouldview = new JLabel("Select which Paper to view");
		lblpapershouldview.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblpapershouldview.setBounds(20, 80, 220, 29);
		add(lblpapershouldview);
		
		JButton btnDone = new JButton("DONE");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnDone.setBounds(20, 266, 128, 37);
		add(btnDone);
		
		JLabel nowView = new JLabel("Now viewing");
		nowView.setFont(new Font("Dialog", Font.PLAIN, 20));
		nowView.setBounds(454, 90, 159, 37);
		add(nowView);
		
		chosenBy = new JTextField();
		chosenBy.setBounds(485, 20, 86, 20);
		add(chosenBy);
		chosenBy.setColumns(10);
		
		

	}
}
