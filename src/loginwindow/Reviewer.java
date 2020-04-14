package loginwindow;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Reviewer extends JPanel {
	private JTextField txtNowReviewing;
	private ArrayList<String> researcherPapers = new ArrayList<>();
	private ArrayList<String> allEditor = new ArrayList<>();
	private Paper thePaper = new Paper();
	private String selectedEditor = "null";
	
	

	/**
	 * Create the panel.
	 */
	
	public Reviewer(JFrame frame, Authenticator auth, String name) {
		setBackground(Color.GRAY);
		
		allEditor = auth.getEditorList();
		
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
		
		if (auth.getAccountNameReview() != null) {
			if ((auth.getAccountNameReview().equals(name))) {
				researcherPapers.add(auth.getFileName());
				
			}
		}
		
		// This is the label for the title, Reviewer Page
		JLabel lblreveiwerpage = new JLabel("Reviewer Page");
		lblreveiwerpage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblreveiwerpage.setBounds(306, 11, 194, 40);
		add(lblreveiwerpage);
		
		// Create a new comboBox, for the dropDownReviewer menu to select what to review
		JComboBox viewTab = new JComboBox();
		
		// This checks for the event that if you selected a new item on the combo box
		viewTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				String selectedPaper = (String) combo.getSelectedItem();
				
				txtNowReviewing = new JTextField();
				txtNowReviewing.setText(selectedPaper);
				txtNowReviewing.setBounds(464, 132, 86, 20);
				add(txtNowReviewing);
				txtNowReviewing.setColumns(10);
				
				System.out.println(selectedPaper);
			}
		});
		viewTab.setFont(new Font("Dialog", Font.PLAIN, 14));
		viewTab.setModel(new DefaultComboBoxModel(researcherPapers.toArray()));
		viewTab.setBounds(20, 120, 220, 40);
		add(viewTab);
		
		JLabel lblpapershouldview = new JLabel("Select which Paper to view");
		lblpapershouldview.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblpapershouldview.setBounds(20, 80, 220, 29);
		add(lblpapershouldview);
		
		JButton btnDone = new JButton("DOWNLOAD");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnDone.setBounds(20, 186, 128, 37);
		add(btnDone);

		
		JLabel nowView = new JLabel("Now viewing");
		nowView.setFont(new Font("Dialog", Font.PLAIN, 20));
		nowView.setBounds(454, 90, 159, 37);
		add(nowView);
		
		JComboBox editorBox = new JComboBox();
		editorBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo3 = (JComboBox<String>) e.getSource();
			     String selected = (String) combo3.getSelectedItem();
			     selectedEditor = selected;
			     System.out.println(selectedEditor);
			}
		});
		editorBox.setBounds(20, 357, 234, 40);
		editorBox.setModel(new DefaultComboBoxModel(allEditor.toArray()));
		add(editorBox);
		
		
		JLabel editor = new JLabel("Select which Editor to edit the paper");
		editor.setFont(new Font("Dialog", Font.PLAIN, 16));
		editor.setBounds(20, 316, 290, 29);
		add(editor);
		
		JButton btnDone_2 = new JButton("DONE");
		btnDone_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedEditor.equals("null")) {
					JOptionPane.showMessageDialog(null, "Please select an Editor to review the paper", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else
				
				JOptionPane.showMessageDialog(null, "You have selected " + selectedEditor, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				auth.setAccountNameEditor(selectedEditor);
			}
		});
		btnDone_2.setBounds(20, 425, 128, 37);
		add(btnDone_2);
		
	}
	}
