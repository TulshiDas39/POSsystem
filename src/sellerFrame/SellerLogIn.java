package sellerFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;

import dataBase.SellerTable;
import frames.LogInFrame;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class SellerLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	
	public static void main(String[] args) {
		new SellerLogIn();
	}

	
	public SellerLogIn() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("      Point of Sell System");
		lblNewLabel.setFont(new Font("Blackadder ITC", Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(566, 21, 274, 41);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(532, 195, 170, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCustomerId = new JLabel("   Seller Id:");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerId.setBounds(418, 192, 104, 25);
		getContentPane().add(lblCustomerId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(789, 192, 89, 25);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(888, 192, 143, 25);
		getContentPane().add(passwordField);
		
		

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFocusPainted(false);
		btnLogIn.setForeground(Color.MAGENTA);
		btnLogIn.setBackground(Color.DARK_GRAY);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogIn.setBounds(640, 281, 151, 41);
		btnLogIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(passwordField.getPassword());
				System.out.println(textField.getText());
				if(new SellerTable().isPasswordExistInTable(Integer.valueOf(textField.getText())
						.intValue(), String.valueOf(passwordField.getPassword()))){setVisible(false); new SellerHomePage(); new LogInFrame(); }
				else JOptionPane.showMessageDialog(null, "Wrong Password","error",JOptionPane.ERROR_MESSAGE);
			}
		});
		getContentPane().add(btnLogIn);
		
		JLabel lblSeller = new JLabel("Seller");
		lblSeller.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeller.setBounds(682, 111, 47, 27);
		getContentPane().add(lblSeller);
		
		setVisible(true);  
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(660, 170, 760, 170);
	}
}
