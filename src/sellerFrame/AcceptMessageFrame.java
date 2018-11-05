package sellerFrame;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcceptMessageFrame extends JFrame {
	
	public AcceptMessageFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Request");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 34));
		lblNewLabel.setBounds(493, 27, 217, 38);
		getContentPane().add(lblNewLabel);
		
		JButton btnOok = new JButton("Accept");
		btnOok.setFocusPainted(false);
		btnOok.setBackground(new Color(46, 139, 87));
		btnOok.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOok.setBounds(537, 346, 89, 23);
		btnOok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		getContentPane().add(btnOok);
		
		JLabel lblCustomerId = new JLabel("Customer Id:");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerId.setBounds(493, 118, 110, 23);
		getContentPane().add(lblCustomerId);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerName.setBounds(463, 166, 140, 23);
		getContentPane().add(lblCustomerName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(613, 118, 110, 23);
		getContentPane().add(lblName);
		
		JLabel label = new JLabel("3948");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(612, 166, 52, 23);
		getContentPane().add(label);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBalance.setBounds(512, 216, 76, 23);
		getContentPane().add(lblBalance);
		
		JLabel label_1 = new JLabel("91238");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(598, 216, 66, 23);
		getContentPane().add(label_1);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		new AcceptMessageFrame();
	}
}
