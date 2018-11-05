package sellerFrame;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dataBase.CategoryTable;
import dataBase.ProductTable;
import sellerFrame.CategoryTableFrame;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class CategoryAdderFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;


	public static void main(String[] args) {
		new CategoryAdderFrame();
	}

	
	public CategoryAdderFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 689, 376);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(513, 121, 125, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterProductFeature = new JLabel("Enter Category Features");
		lblEnterProductFeature.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEnterProductFeature.setBounds(209, 28, 286, 26);
		getContentPane().add(lblEnterProductFeature);
		
		JLabel lblId = new JLabel("Category Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(71, 120, 89, 25);
		getContentPane().add(lblId);
		
		JLabel lblProductName = new JLabel("Category Name:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductName.setBounds(384, 120, 111, 25);
		getContentPane().add(lblProductName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 121, 125, 26);
		getContentPane().add(textField_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setBounds(309, 189, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField_1.getText()).intValue();
				String name = textField.getText();
				new CategoryTable().insertIntoCategoryTable(id, name);
				dispose();
				try {
					new CategoryTableFrame();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnOk);
		
		setVisible(true);
		
	}
}
