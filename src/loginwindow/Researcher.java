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
		btnselectpaper.setBounds(141, 92, 214, 29);
		add(btnselectpaper);
		
		
		
		JLabel lblSelectReviewer = new JLabel("select reviewer:");
		lblSelectReviewer.setBounds(10, 132, 102, 29);
		add(lblSelectReviewer);
		
		JComboBox reviewerBox = new JComboBox();
		reviewerBox.setFont(new Font("Dialog", Font.PLAIN, 14));
		reviewerBox.setModel(new DefaultComboBoxModel(new String[] {"abc", "def", "ghi"}));
		reviewerBox.setBounds(141, 132, 214, 27);
		add(reviewerBox);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(186, 170, 117, 29);
		add(btnNewButton);

	}
}
