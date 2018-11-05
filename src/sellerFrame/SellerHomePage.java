package sellerFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;


public class SellerHomePage extends JFrame {


	public static void main(String[] args) {
		new SellerHomePage();
	}

	public SellerHomePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		
		JLabel lblHomePage = new JLabel("Home");
		lblHomePage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHomePage.setBounds(638, 26, 88, 37);
		getContentPane().add(lblHomePage);
		
		JButton btnCustomerTable = new JButton("Customer Table");
		btnCustomerTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCustomerTable.setBounds(335, 146, 182, 33);
		btnCustomerTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CustomerTableFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnCustomerTable);
		
		JButton btnProductTable = new JButton("Product Table");
		btnProductTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnProductTable.setBounds(604, 146, 182, 33);
		btnProductTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ProductTableFrame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnProductTable);
		
		JButton btnCategoryTable = new JButton("Category Table");
		btnCategoryTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCategoryTable.setBounds(875, 146, 182, 33);
		btnCategoryTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					new CategoryTableFrame();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnCategoryTable);
		
		JButton btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistory.setBounds(780, 243, 154, 37);
		getContentPane().add(btnHistory);
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSupplier.setBounds(475, 243, 182, 33);
		getContentPane().add(btnSupplier);
		
		setVisible(true);
		
	}

}
