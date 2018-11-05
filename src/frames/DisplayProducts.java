package frames;


import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dataBase.CategoryTable;
import dataBase.ProductTable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class DisplayProducts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public DisplayProducts(String catName, int id) throws SQLException {
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel lblCategorisOfProducts = new JLabel("Category: ");
		lblCategorisOfProducts.setFont(new Font("Californian FB", Font.BOLD, 21));
		lblCategorisOfProducts.setBounds(650, 40, 103, 26);
		getContentPane().add(lblCategorisOfProducts);
		
		
		
		createTableOfProducts(catName);
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(46, 139, 87));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBounds(1263, 7, 89, 23);
		getContentPane().add(btnLogOut);
		
		JButton btnShowProducts = new JButton("OK");
		btnShowProducts.setToolTipText("You will set the number of each product");
		btnShowProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowProducts.setFocusPainted(false);
		btnShowProducts.setBackground(new Color(160, 82, 45));
		btnShowProducts.setBounds(1221, 114, 131, 30);
		btnShowProducts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(table.getSelectedRow());
				
			}
		});
		getContentPane().add(btnShowProducts);
		
		JLabel lblId = new JLabel("Id: ");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(698, 65, 30, 14);
		getContentPane().add(lblId);
		
		JLabel label_3 = new JLabel(String.valueOf(id));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(738, 65, 46, 14);
		getContentPane().add(label_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\back.PNG"));
		btnNewButton.setBounds(0, 0, 37, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					new FrameAfteLogIn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnNewButton);
		
		JLabel lblCategory = new JLabel(catName);
		lblCategory.setFont(new Font("Californian FB", Font.BOLD, 21));
		lblCategory.setBounds(751, 40, 103, 26);
		getContentPane().add(lblCategory);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}


	@SuppressWarnings("serial")
	private void createTableOfProducts(String catName) throws SQLException {
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new ProductTable().getProductsOfCategory(catName)
			,
			new String[] {
				"Product Id", "Product Name", "Price per unit", "Unit", "Total Quantity", "Choose"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, String.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(83);
		table.getColumnModel().getColumn(5).setResizable(false);

		JScrollPane jsP = new JScrollPane(table);
		jsP.setAutoscrolls(true);
		jsP.setBounds(312,119,880,575);
		jsP.getViewport().setBackground(new Color(85,107,47));
		jsP.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(jsP);
		table.setRowHeight(30);
		table.getTableHeader().setPreferredSize(new Dimension(jsP.getWidth(), 40));
		table.getTableHeader().setFont(new Font("Sherif",Font.BOLD,20));
		table.getTableHeader().setBackground(Color.GREEN);
	}
}
