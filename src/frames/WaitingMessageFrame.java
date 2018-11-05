package frames;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitingMessageFrame extends JFrame {
	
	public WaitingMessageFrame() {
		setLocation(new Point(500, 200));
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(350, 200, 621, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your request has been sent");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 34));
		lblNewLabel.setBounds(154, 41, 330, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPleaseWaitA = new JLabel("Please wait a while");
		lblPleaseWaitA.setForeground(new Color(106, 90, 205));
		lblPleaseWaitA.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblPleaseWaitA.setBounds(207, 111, 231, 38);
		getContentPane().add(lblPleaseWaitA);
		
		JButton btnOok = new JButton("ok");
		btnOok.setFocusPainted(false);
		btnOok.setBackground(new Color(46, 139, 87));
		btnOok.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOok.setBounds(266, 182, 89, 23);
		btnOok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		getContentPane().add(btnOok);
	}
	
	public static void main(String[] args) {
		new WaitingMessageFrame();
	}
}
