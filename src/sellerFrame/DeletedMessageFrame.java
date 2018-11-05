package sellerFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sellerFrame.CategoryTableFrame;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class DeletedMessageFrame extends JFrame {

	
	public static void main(String[] args) {
		
	}

	public DeletedMessageFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 356);
		getContentPane().setLayout(null);
		
		JLabel lblUpdatedSuccessful = new JLabel("Deleted Successful");
		lblUpdatedSuccessful.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblUpdatedSuccessful.setBounds(174, 69, 262, 34);
		getContentPane().add(lblUpdatedSuccessful);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnOk.setBounds(246, 162, 129, 41);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
