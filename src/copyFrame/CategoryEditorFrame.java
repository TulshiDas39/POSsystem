package copyFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import dataBase.CategoryTable;
import dataBase.ProductTable;
import sellerFrame.CategoryTableFrame;
import sellerFrame.ProductTableFrame;

public class CategoryEditorFrame extends JFrame {
	private JTextField textField;
	private JTextField textField0;
	private JTextField textField_1;

	public static void main(String[] args) {
		new CategoryEditorFrame();
	}

	public CategoryEditorFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 458);
		getContentPane().setLayout(null);
		
		JLabel lblProductEditor = new JLabel("Categoryt Editor");
		lblProductEditor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProductEditor.setBounds(239, 34, 183, 29);
		getContentPane().add(lblProductEditor);
		
		JLabel lblIdOfSelected = new JLabel("Category id of selected row:");
		lblIdOfSelected.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdOfSelected.setBounds(123, 93, 232, 29);
		getContentPane().add(lblIdOfSelected);
		
		textField0 = new JTextField();
		textField0.setBounds(383, 93, 164, 27);
		//textField0.setColumns(10);
		getContentPane().add(textField0);
		
		JLabel lblEnterNewFeatures = new JLabel("Enter new features");
		lblEnterNewFeatures.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNewFeatures.setBounds(275, 173, 164, 27);
		getContentPane().add(lblEnterNewFeatures);
		
		textField = new JTextField();
		textField.setBounds(513, 229, 125, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblId = new JLabel("Category Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(57, 228, 89, 25);
		getContentPane().add(lblId);
		
		JLabel lblProductName = new JLabel("Category Name:");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductName.setBounds(402, 228, 111, 25);
		getContentPane().add(lblProductName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 229, 125, 26);
		getContentPane().add(textField_1);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOk.setBounds(301, 299, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int toChangeId = Integer.valueOf(textField0.getText());
				int id = Integer.valueOf(textField_1.getText()).intValue();
				String name = textField.getText();
				
				CategoryTable cTable = new CategoryTable();
				if(cTable.SearchCategoryId(id) !=true){
					JOptionPane.showMessageDialog(null,"Id not found","error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					
					new CategoryTable().update(id, name,toChangeId);
				}
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
