package sellerFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import dataBase.ProductTable;

public class ProductEditorFrame extends JFrame {
	private JTextField textField;
	private JTextField textField0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String[] args) {
		new ProductEditorFrame();
	}

	public ProductEditorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 458);
		getContentPane().setLayout(null);
		
		JLabel lblProductEditor = new JLabel("Product Editor");
		lblProductEditor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProductEditor.setBounds(258, 34, 164, 29);
		getContentPane().add(lblProductEditor);
		
		JLabel lblIdOfSelected = new JLabel("product id of selected row:");
		lblIdOfSelected.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdOfSelected.setBounds(123, 93, 221, 29);
		getContentPane().add(lblIdOfSelected);
		
		textField0 = new JTextField();
		textField0.setBounds(354, 93, 164, 27);
		textField0.setColumns(10);
		getContentPane().add(textField0);
		
		JLabel lblEnterNewFeatures = new JLabel("Enter new features");
		lblEnterNewFeatures.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNewFeatures.setBounds(275, 173, 164, 27);
		getContentPane().add(lblEnterNewFeatures);
		
		textField = new JTextField();
		textField.setBounds(513, 229, 125, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblId = new JLabel("Product Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(57, 228, 89, 25);
		getContentPane().add(lblId);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductName.setBounds(402, 228, 111, 25);
		getContentPane().add(lblProductName);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategory.setBounds(71, 264, 75, 25);
		getContentPane().add(lblCategory);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 229, 125, 26);
		getContentPane().add(textField_1);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(433, 264, 48, 25);
		getContentPane().add(lblPrice);
		
		JLabel lblUnit = new JLabel("Unit:");
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnit.setBounds(106, 300, 39, 25);
		getContentPane().add(lblUnit);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(433, 300, 70, 25);
		getContentPane().add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(156, 264, 125, 26);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 301, 125, 26);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(513, 265, 125, 26);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(513, 301, 125, 26);
		getContentPane().add(textField_5);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setBounds(312, 362, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int toChangeId = Integer.valueOf(textField0.getText());
				int id = Integer.valueOf(textField_1.getText()).intValue();
				String name = textField.getText();
				String category = textField_2.getText();
				String unit = textField_3.getText();
				double price = Double.valueOf( textField_4.getText());
				double quantity = Double.valueOf(textField_5.getText());
				ProductTable pTable = new ProductTable();
				if(!pTable.SearchProductId(id)){
					JOptionPane.showMessageDialog(null,"Id not found","error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					
					new ProductTable().update(id, name, category, price,unit, quantity, toChangeId);
				}
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
