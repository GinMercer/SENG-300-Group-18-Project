package loginwindow;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Mainframe {

	private JFrame frame;
	private authenticator auth = new authenticator();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe window = new Mainframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Mainframe() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		login panel = new login(frame, auth);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.revalidate();
	}

}
