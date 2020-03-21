package loginwindow;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class Researcher extends JPanel {

	/**
	 * Create the panel.
	 */
	public Researcher(JFrame frame, Authenticator auth) {
		setBackground(Color.LIGHT_GRAY);
		
		JButton btnback = new JButton("Back");
		btnback.setBounds(227, 52, 75, 29);
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
		lblresearchpage.setBounds(314, 42, 193, 41);
		add(lblresearchpage);
		
		JLabel lblupload = new JLabel("Upload my paper:");
		lblupload.setBounds(90, 170, 121, 29);
		add(lblupload);
		
		JLabel lblPdfpath = new JLabel(".pdf path");
		lblPdfpath.setBounds(453, 170, 179, 29);
		add(lblPdfpath);
		
		JButton btnselectpaper = new JButton("Select paper");
		btnselectpaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = null;
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				
                FileNameExtensionFilter extension = new FileNameExtensionFilter("*Paper", "pdf");   
                chooser.addChoosableFileFilter(extension);
                
                int filestate = chooser.showOpenDialog(null);
                if(filestate == JFileChooser.APPROVE_OPTION) {
                		
                        File selectPaper = chooser.getSelectedFile();
                        path = chooser.getSelectedFile().getName();
                        lblPdfpath.setText(path);
                }
			}
		});
		btnselectpaper.setBounds(227, 171, 214, 29);
		add(btnselectpaper);
		
		
		
		JLabel lblSelectReviewer = new JLabel("select reviewer:");
		lblSelectReviewer.setBounds(90, 248, 102, 29);
		add(lblSelectReviewer);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"abc", "def", "ghi"}));
		comboBox.setBounds(227, 250, 214, 27);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(270, 344, 117, 29);
		add(btnNewButton);

	}
}
