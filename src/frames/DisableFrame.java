package frames;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

public class DisableFrame extends JFrame {


	public static void main(String[] args) {
		new DisableFrame();
	}

	public DisableFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblMarke = new JLabel("Disabled");
		lblMarke.setForeground(new Color(255, 69, 0));
		lblMarke.setFont(new Font("Tahoma", Font.PLAIN, 78));
		lblMarke.setBounds(593, 227, 353, 134);
		getContentPane().add(lblMarke);
		setVisible(true);
	}
}
