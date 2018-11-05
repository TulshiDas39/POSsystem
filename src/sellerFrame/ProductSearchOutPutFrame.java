package sellerFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ProductSearchOutPutFrame extends JFrame {

	
	public static void main(String[] args) {
		//new ProductSearchOutPutFrame(id, name, category, price, unit, quantity)
	}

	
	public ProductSearchOutPutFrame(int id,String name,String category,double price,String unit,double quantity) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 300);
		getContentPane().setLayout(null);
		
		JLabel lblSearchOutput = new JLabel("Search Output");
		lblSearchOutput.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSearchOutput.setBounds(263, 27, 144, 33);
		getContentPane().add(lblSearchOutput);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblId.setBounds(109, 69, 33, 33);
		getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(367, 71, 56, 33);
		getContentPane().add(lblName);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCategory.setBounds(109, 118, 78, 33);
		getContentPane().add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrice.setBounds(377, 115, 46, 33);
		getContentPane().add(lblPrice);
		
		JLabel lblUnit = new JLabel("Unit:");
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUnit.setBounds(109, 162, 46, 33);
		getContentPane().add(lblUnit);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuantity.setBounds(375, 159, 78, 33);
		getContentPane().add(lblQuantity);
		
		JLabel lblId_1 = new JLabel(String.valueOf(id));
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblId_1.setBounds(152, 69, 144, 33);
		getContentPane().add(lblId_1);
		
		JLabel lblCategory_1 = new JLabel(category);
		lblCategory_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCategory_1.setBounds(195, 118, 144, 33);
		getContentPane().add(lblCategory_1);
		
		JLabel lblUnit_1 = new JLabel(unit);
		lblUnit_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUnit_1.setBounds(176, 159, 111, 33);
		getContentPane().add(lblUnit_1);
		
		JLabel lblName_1 = new JLabel(name);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName_1.setBounds(440, 69, 137, 33);
		getContentPane().add(lblName_1);
		
		JLabel lblPrice_1 = new JLabel(String.valueOf(price));
		lblPrice_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrice_1.setBounds(435, 115, 125, 33);
		getContentPane().add(lblPrice_1);
		
		JLabel lblQuantity_1 = new JLabel(String.valueOf(quantity));
		lblQuantity_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQuantity_1.setBounds(462, 159, 137, 33);
		getContentPane().add(lblQuantity_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(270, 217, 89, 33);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
				
			}
		});
		getContentPane().add(btnOk);
		
		setVisible(true);
		
	}

}
