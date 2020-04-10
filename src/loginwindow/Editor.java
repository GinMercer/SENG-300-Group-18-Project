package loginwindow;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import java.util.ArrayList;

public class Editor extends JPanel {
	
	private String reviewer1 = "None";
	private String reviewer2 = "None";
	private String reviewer3 = "None";

	/**
	 * Create the panel.
	 */
	
	public Editor(JFrame frame, Authenticator auth) {
		
		setBackground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 11, 75, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login panel = new login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		setLayout(null);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Editor Page");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(342, 2, 137, 39);
		lblNewLabel.setForeground(Color.BLACK);
		add(lblNewLabel);
		
		JComboBox comboBoxforpaperchooser = new JComboBox();
		
		ArrayList<String> dropDown = new ArrayList();
		dropDown.add("None");
		
		// This is for making a new ArrayList of all the accounts that are Reviewers, that way the editor can choose them.
		for (int i = 0; i < auth.allAccounts().size(); i++) {
			Account accountIteration = new Account();
			accountIteration = (Account)auth.allAccounts().get(i);
			if (accountIteration.getAccountType() == "Reviewer") {
				String name = accountIteration.getUsername();
				dropDown.add(name);
			}
		}
		
		comboBoxforpaperchooser.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxforpaperchooser.setModel(new DefaultComboBoxModel(new String[] {"haskell", "prolog", "java"}));
		comboBoxforpaperchooser.setBounds(10, 140, 200, 39);
		add(comboBoxforpaperchooser);
		
		JComboBox comboBoxfor1reveiwer = new JComboBox();
		comboBoxfor1reveiwer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JComboBox<String> combo1 = (JComboBox<String>) e.getSource();
			     String selectedReviewer1 = (String) combo1.getSelectedItem();
			     System.out.println(selectedReviewer1);
			     reviewer1 = selectedReviewer1;
			}
		});
		comboBoxfor1reveiwer.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxfor1reveiwer.setModel(new DefaultComboBoxModel(dropDown.toArray()));
		comboBoxfor1reveiwer.setBounds(537, 71, 200, 39);
		add(comboBoxfor1reveiwer);
		
		JComboBox comboBoxfor2reviewer = new JComboBox();
		comboBoxfor2reviewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo2 = (JComboBox<String>) e.getSource();
			     String selectedReviewer2 = (String) combo2.getSelectedItem();
			     System.out.println(selectedReviewer2);
			     reviewer2 = selectedReviewer2;
			}
		});
		comboBoxfor2reviewer.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxfor2reviewer.setModel(new DefaultComboBoxModel(dropDown.toArray()));
		comboBoxfor2reviewer.setBounds(537, 140, 200, 39);
		add(comboBoxfor2reviewer);
		
		JComboBox comboBoxfor3reviewer = new JComboBox();
		comboBoxfor3reviewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo3 = (JComboBox<String>) e.getSource();
			     String selectedReviewer3 = (String) combo3.getSelectedItem();
			     System.out.println(selectedReviewer3);
			     reviewer3 = selectedReviewer3;
			}
		});
		comboBoxfor3reviewer.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxfor3reviewer.setModel(new DefaultComboBoxModel(dropDown.toArray()));
		comboBoxfor3reviewer.setBounds(537, 208, 200, 39);
		add(comboBoxfor3reviewer);
		
		JLabel lblpaperchooser = new JLabel("Please choose a paper");
		lblpaperchooser.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblpaperchooser.setBounds(10, 95, 200, 29);
		add(lblpaperchooser);
		
		JLabel lblChoosereviewer = new JLabel("Please choose three reviewers");
		lblChoosereviewer.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChoosereviewer.setBounds(537, 17, 263, 29);
		add(lblChoosereviewer);
		
		JLabel lblfirstreviewer = new JLabel("1");
		lblfirstreviewer.setBounds(509, 84, 18, 16);
		add(lblfirstreviewer);
		
		JLabel lblsecondreviewer = new JLabel("2");
		lblsecondreviewer.setBounds(509, 153, 18, 16);
		add(lblsecondreviewer);
		
		JLabel lblthirdreviewer = new JLabel("3");
		lblthirdreviewer.setBounds(509, 221, 18, 16);
		add(lblthirdreviewer);
		
		JButton btnfinishassign = new JButton("DONE");
		btnfinishassign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (((reviewer1 == reviewer2) || (reviewer1 == reviewer3) || (reviewer2 == reviewer3))&&((reviewer1 != "None")&&(reviewer2 != "None")&&(reviewer3 != "None"))) {
					JOptionPane.showMessageDialog(null, "You cannot select more than one of the same paper, please select None in where you wish to not edit a paper", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnfinishassign.setBounds(579, 282, 117, 29);
		add(btnfinishassign);

	}
}
