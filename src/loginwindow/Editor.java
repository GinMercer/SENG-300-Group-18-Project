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

import java.util.ArrayList;

public class Editor extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public Editor(JFrame frame, Authenticator auth) {
		
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
		
		JLabel lblNewLabel = new JLabel("Editor Page");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(314, 43, 137, 39);
		lblNewLabel.setForeground(Color.BLACK);
		add(lblNewLabel);
		
		JComboBox comboBoxforpaperchooser = new JComboBox();
		
		ArrayList<String> dropDown = new ArrayList();
		
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
		comboBoxforpaperchooser.setBounds(120, 170, 200, 39);
		add(comboBoxforpaperchooser);
		
		JComboBox comboBoxfor1reveiwer = new JComboBox();
		comboBoxfor1reveiwer.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxfor1reveiwer.setModel(new DefaultComboBoxModel(dropDown.toArray()));
		comboBoxfor1reveiwer.setBounds(396, 170, 200, 39);
		add(comboBoxfor1reveiwer);
		
		JComboBox comboBoxfor2reviewer = new JComboBox();
		comboBoxfor2reviewer.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxfor2reviewer.setModel(new DefaultComboBoxModel(dropDown.toArray()));
		comboBoxfor2reviewer.setBounds(396, 234, 200, 39);
		add(comboBoxfor2reviewer);
		
		JComboBox comboBoxfor3reviewer = new JComboBox();
		comboBoxfor3reviewer.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxfor3reviewer.setModel(new DefaultComboBoxModel(dropDown.toArray()));
		comboBoxfor3reviewer.setBounds(396, 300, 200, 39);
		add(comboBoxfor3reviewer);
		
		JLabel lblpaperchooser = new JLabel("Please choose a paper");
		lblpaperchooser.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblpaperchooser.setBounds(120, 140, 200, 29);
		add(lblpaperchooser);
		
		JLabel lblChoosereviewer = new JLabel("Please choose three reviewers");
		lblChoosereviewer.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChoosereviewer.setBounds(396, 140, 263, 29);
		add(lblChoosereviewer);
		
		JLabel lblfirstreviewer = new JLabel("1");
		lblfirstreviewer.setBounds(366, 180, 18, 16);
		add(lblfirstreviewer);
		
		JLabel lblsecondreviewer = new JLabel("2");
		lblsecondreviewer.setBounds(366, 244, 18, 16);
		add(lblsecondreviewer);
		
		JLabel lblthirdreviewer = new JLabel("3");
		lblthirdreviewer.setBounds(366, 310, 18, 16);
		add(lblthirdreviewer);
		
		JButton btnfinishassign = new JButton("DONE");
		btnfinishassign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnfinishassign.setBounds(286, 378, 117, 29);
		add(btnfinishassign);

	}
}
