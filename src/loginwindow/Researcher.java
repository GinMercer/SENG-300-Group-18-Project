package loginwindow;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class Researcher extends JPanel {
	
	private ArrayList<String> dropDownResearcher = new ArrayList();
	private String selectedReviewer = "None";
	private String alreadySelect = "None";
	private Account selectedAccount = new Account();
	private File thisFile = new File("null");
	private String fileName = "null";

	/**
	 * Create the panel.
	 */
	
	
	public Researcher(JFrame frame, Authenticator auth) {
		setBackground(Color.LIGHT_GRAY);
		
		dropDownResearcher = auth.getReviewerList();
		
		JButton btnback = new JButton("Back");
		btnback.setBounds(10, 11, 75, 29);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login panel = new login(frame, auth);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		setLayout(null);
		add(btnback);
		
		JLabel lblresearchpage = new JLabel("Researcher Page");
		lblresearchpage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblresearchpage.setBounds(318, 11, 193, 41);
		add(lblresearchpage);
		
		JLabel lblupload = new JLabel("Upload my paper:");
		lblupload.setBounds(10, 92, 121, 29);
		add(lblupload);
		
		JLabel lblPdfpath = new JLabel(".pdf path");
		lblPdfpath.setBounds(365, 92, 179, 29);
		add(lblPdfpath);
		
		JButton btnselectpaper = new JButton("Select paper");
		btnselectpaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = null;
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				
                FileNameExtensionFilter extension = new FileNameExtensionFilter("*pdf", "pdf");   
                chooser.addChoosableFileFilter(extension);
                
                int filestate = chooser.showOpenDialog(null);
                if(filestate == JFileChooser.APPROVE_OPTION) {
                		
                        File selectPaper = chooser.getSelectedFile();
                        path = chooser.getSelectedFile().getName();
                        lblPdfpath.setText(path);
                        thisFile = selectPaper;
                        fileName = selectPaper.getName();
                        
                }
			}
		});
		btnselectpaper.setBounds(141, 92, 214, 29);
		add(btnselectpaper);
		
		dropDownResearcher.add("None");
		
		JLabel lblSelectReviewer = new JLabel("select reviewer:");
		lblSelectReviewer.setBounds(10, 132, 102, 29);
		add(lblSelectReviewer);
		
		JComboBox reviewerBox = new JComboBox();
		reviewerBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> combo3 = (JComboBox<String>) e.getSource();
			     String selected = (String) combo3.getSelectedItem();
			     selectedReviewer = selected;
			     System.out.println(selectedReviewer);
			}
		});
		reviewerBox.setFont(new Font("Dialog", Font.PLAIN, 14));
		reviewerBox.setModel(new DefaultComboBoxModel(dropDownResearcher.toArray()));
		reviewerBox.setBounds(141, 132, 214, 27);
		add(reviewerBox);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (fileName.equals("null")) {
					JOptionPane.showMessageDialog(null, "Please select a paper", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else
				
				if ((alreadySelect == selectedReviewer)&&(selectedReviewer != "None")) {
					JOptionPane.showMessageDialog(null, "You have already selected this reviewer", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (selectedReviewer == "None") {
					JOptionPane.showMessageDialog(null, "Please select a reviewer", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "You have selected " + selectedReviewer, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					alreadySelect = selectedReviewer;
					auth.changeFile(thisFile);
					auth.setAccountNameReviewer(selectedReviewer);
				}
			}
		});
		btnNewButton.setBounds(186, 170, 117, 29);
		add(btnNewButton);

	}
}


