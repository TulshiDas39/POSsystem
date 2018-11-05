package sellerFrame;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dataBase.ProductTable;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class ProductAdderFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	public static void main(String[] args) {
		new ProductAdderFrame();
	}

	
	public ProductAdderFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 689, 376);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(513, 121, 125, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterProductFeature = new JLabel("Enter Product Features");
		lblEnterProductFeature.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEnterProductFeature.setBounds(209, 28, 264, 26);
		getContentPane().add(lblEnterProductFeature);
		
		JLabel lblId = new JLabel("Product Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(71, 120, 89, 25);
		getContentPane().add(lblId);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductName.setBounds(384, 120, 111, 25);
		getContentPane().add(lblProductName);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategory.setBounds(71, 169, 89, 25);
		getContentPane().add(lblCategory);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 121, 125, 26);
		getContentPane().add(textField_1);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(447, 169, 48, 25);
		getContentPane().add(lblPrice);
		
		JLabel lblUnit = new JLabel("Unit:");
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnit.setBounds(106, 215, 39, 25);
		getContentPane().add(lblUnit);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(425, 215, 70, 25);
		getContentPane().add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 170, 125, 26);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 214, 125, 26);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(513, 170, 125, 26);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(513, 216, 125, 26);
		getContentPane().add(textField_5);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setBounds(304, 288, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField_1.getText()).intValue();
				String name = textField.getText();
				String category = textField_2.getText();
				String unit = textField_3.getText();
				double price = Double.valueOf( textField_4.getText());
				double quantity = Double.valueOf(textField_5.getText());
				new ProductTable().insertIntoProductTable(id, name, category, price, unit, quantity);
				dispose();
				try {
					new ProductTableFrame();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnOk);
		
		setVisible(true);
		
	}
}
