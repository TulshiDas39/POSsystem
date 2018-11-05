package frames;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class RecievedFrame extends JFrame {

	public static void main(String[] args) {
		new RecievedFrame();
	}

	public RecievedFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblRecieved = new JLabel("Recieved?");
		lblRecieved.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRecieved.setBounds(177, 49, 98, 25);
		getContentPane().add(lblRecieved);
		
		JButton btnYeas = new JButton("Yes");
		btnYeas.setBounds(89, 108, 89, 23);
		btnYeas.setFocusPainted(false);
		getContentPane().add(btnYeas);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(263, 108, 89, 23);
		btnNo.setFocusPainted(false);
		getContentPane().add(btnNo);
		
		setVisible(true);
		
		
	}

}
