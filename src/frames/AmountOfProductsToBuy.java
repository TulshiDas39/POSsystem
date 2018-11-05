package frames;


import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AmountOfProductsToBuy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) {
		new AmountOfProductsToBuy();
	}

	
	public AmountOfProductsToBuy() {
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel lblCategorisOfProducts = new JLabel("Enter Amount of Product");
		lblCategorisOfProducts.setFont(new Font("Californian FB", Font.BOLD, 21));
		lblCategorisOfProducts.setBounds(637, 52, 231, 26);
		getContentPane().add(lblCategorisOfProducts);
		
		
		
		createTableOfProducts();
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(46, 139, 87));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBounds(1263, 7, 89, 23);
		getContentPane().add(btnLogOut);
		
		JButton btnShowProducts = new JButton("Buy");
		btnShowProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowProducts.setFocusPainted(false);
		btnShowProducts.setBackground(new Color(160, 82, 45));
		btnShowProducts.setBounds(1221, 103, 131, 30);
		btnShowProducts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(table.getSelectedRow());
				new BalanceMessageFrame();
			}
		});
		getContentPane().add(btnShowProducts);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\back.PNG"));
		btnNewButton.setBounds(0, 0, 37, 23);
		getContentPane().add(btnNewButton);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}


	@SuppressWarnings("serial")
	private void createTableOfProducts() {
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBackground(Color.WHITE);
		//jsP.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"n1", "1", "", "", "", ""},
				{"n2", "2", null, null, null, null},
				{"n3", "3", null, null, null, null},
				{"n4", "4", null, null, null, null},
				{"n5", "5", null, null, null, null},
				{"n6", "6", null, null, null, null},
				{"n7", "7", null, null, null, null},
				{"n8", "8", null, null, null, null},
				{"n9", "9", null, null, null, null},
				{"n10", "10", null, null, null, null},
				{"n11", "11", null, null, null, null},
				{"n12", "12", null, null, null, null},
				{"n13", "13", null, null, null, null},
				{"n14", "14", null, null, null, null},
				{"n15", "15", null, null, null, null},
				{"n16", "16", null, null, null, null},
				{"n17", "17", null, null, null, null},
				{"n18", "18", null, null, null, null},
				{"n19", "19", null, null, null, null},
				{"n20", "20", null, null, null, null},
				{"n21", null, null, null, null, null},
			},
			new String[] {
				"Product Id", "Product Name", "Price per unit", "Unit", "Total Quantity", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
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
