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

public class CategorySearchOutPutFrame extends JFrame {

	
	public static void main(String[] args) {
		//new ProductSearchOutPutFrame(id, name, category, price, unit, quantity)
	}

	
	public CategorySearchOutPutFrame(int id,String name) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblId_1 = new JLabel(String.valueOf(id));
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblId_1.setBounds(152, 69, 144, 33);
		getContentPane().add(lblId_1);
		
		JLabel lblName_1 = new JLabel(name);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName_1.setBounds(440, 69, 137, 33);
		getContentPane().add(lblName_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(272, 147, 89, 33);
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
