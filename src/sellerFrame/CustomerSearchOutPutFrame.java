package sellerFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CustomerSearchOutPutFrame extends JFrame {

	
	public CustomerSearchOutPutFrame(int id,String name,String phone,String type,double balence) {
		System.out.println(type);
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
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone.setBounds(109, 118, 78, 33);
		getContentPane().add(lblPhone);
		
		JLabel lblBalence = new JLabel("Balence:");
		lblBalence.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBalence.setBounds(109, 162, 109, 33);
		getContentPane().add(lblBalence);
		
		JLabel lblId_1 = new JLabel(String.valueOf(id));
		lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblId_1.setBounds(152, 69, 144, 33);
		getContentPane().add(lblId_1);
		
		JLabel lblPhone_1 = new JLabel(phone);
		lblPhone_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPhone_1.setBounds(195, 118, 144, 33);
		getContentPane().add(lblPhone_1);
		
		JLabel lblBalence_1 = new JLabel(String.valueOf(balence));
		lblBalence_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBalence_1.setBounds(228, 162, 111, 33);
		getContentPane().add(lblBalence_1);
		
		JLabel lblName_1 = new JLabel(name);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName_1.setBounds(440, 69, 137, 33);
		getContentPane().add(lblName_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(270, 217, 89, 33);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
				
			}
		});
		getContentPane().add(btnOk);
		
		JLabel lblType = new JLabel("type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblType.setBounds(354, 115, 46, 33);
		getContentPane().add(lblType);
		
		JLabel lblType_1 = new JLabel(type);
		lblType_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblType_1.setBounds(424, 118, 144, 33);
		getContentPane().add(lblType_1);
		
		setVisible(true);
		
		
	}
}
