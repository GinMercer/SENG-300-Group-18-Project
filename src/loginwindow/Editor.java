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
	private ArrayList<String> dropDown = new ArrayList<String>();

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
		
		// Create a new editor page and everything that is associated with it
		JLabel lblNewLabel = new JLabel("Editor Page");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(342, 2, 137, 39);
		lblNewLabel.setForeground(Color.BLACK);
		add(lblNewLabel);
		
		// Create a combo box to choose the reviewers for the paper
		JComboBox comboBoxforpaperchooser = new JComboBox();
		
		// Initialize the dropDown arrayList to have none, as there are no reviewers to select yet
		dropDown.add("None");
		
		// This is for making a new ArrayList of all the accounts that are Reviewers, that way the editor can choose them.
		// We will add applicable reviewers to dropDown
		for (int i = 0; i < auth.allAccounts().size(); i++) {
			Account accountIteration = new Account();
			accountIteration = (Account)auth.allAccounts().get(i);
			if (accountIteration.getAccountType() == "Reviewer") {
				String name = accountIteration.getUsername();
				dropDown.add(name);
			}
		}
		
		// This is a combo box for choosing which paper to view.
		// This combo box will have all the papers that are submitted by a particular Researcher.
		// As soon as you select an item from the combobox, the reviewer1 variable in Editor class becomes that item.
		comboBoxforpaperchooser.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBoxforpaperchooser.setModel(new DefaultComboBoxModel(new String[] {"haskell", "prolog", "java"}));
		comboBoxforpaperchooser.setBounds(10, 140, 200, 39);
		add(comboBoxforpaperchooser);
		
		// This is the combo box for reviewer 1
		// The top combobox, it will drop down and show all the applicable reviewers for this paper.
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
		
		// This is the combo box for reviewer 2
		// The top combobox, it will drop down and show all the applicable reviewers for this paper.
		// As soon as you select an item from the combobox, the reviewer2 variable in Editor class becomes that item.
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
		
		
		// This is the combo box for reviewer 1
		// The top combobox, it will drop down and show all the applicable reviewers for this paper.
		// As soon as you select an item from the combobox, the reviewer3 variable in Editor class becomes that item.
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
		
		// The label for choosing a reviewer
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
		
		// The button is either confirming and denying the action taken, below is a proccess of steps to trap errors.
		JButton btnfinishassign = new JButton("DONE");
		btnfinishassign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(dropDown);
				// Cant select more than one of the same paper
				if (((reviewer1 == reviewer2) || (reviewer1 == reviewer3) || (reviewer2 == reviewer3))&&((reviewer1 != "None")&&(reviewer2 != "None")&&(reviewer3 != "None"))) {
					JOptionPane.showMessageDialog(null, "You cannot select more than one of the same paper, please select None in where you wish to not edit a paper", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else
				// Currently, there are no papers to review
				if (dropDown.size() == 1) {
					JOptionPane.showMessageDialog(null, "There are no papers to review", "ERROR", JOptionPane.ERROR_MESSAGE);
					// You must select at least one paper to review if you want to press the done button
				} else if ((reviewer1 == "None")&&(reviewer2 == "None")&&(reviewer3 == "None")) {
					JOptionPane.showMessageDialog(null, "Please select at least one paper to review", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnfinishassign.setBounds(579, 282, 117, 29);
		add(btnfinishassign);

	}
}
