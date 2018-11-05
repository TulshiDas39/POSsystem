package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class BalanceMessageFrame extends JFrame {

	
	public static void main(String[] args) {
		new BalanceMessageFrame();
	}

	
	public BalanceMessageFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("$1000");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(120, 51, 61, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblWillBeDeducted = new JLabel("will be deducted from your main balance");
		lblWillBeDeducted.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWillBeDeducted.setBounds(191, 51, 337, 22);
		getContentPane().add(lblWillBeDeducted);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setFocusPainted(false);
		btnYes.setBounds(149, 139, 89, 23);
		getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setFocusPainted(false);
		btnNo.setBounds(319, 139, 89, 23);
		getContentPane().add(btnNo);
		setVisible(true);

	}

}
