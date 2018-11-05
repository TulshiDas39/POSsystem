package sellerFrame;


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

public class SupplierTableFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) {
		new SupplierTableFrame();
	}

	
	public SupplierTableFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel lblCategorisOfProducts = new JLabel("Supplier Table");
		lblCategorisOfProducts.setFont(new Font("Californian FB", Font.BOLD, 21));
		lblCategorisOfProducts.setBounds(673, 49, 142, 26);
		getContentPane().add(lblCategorisOfProducts);
		
		
		
		createTableOfProducts();
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(46, 139, 87));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBounds(1263, 7, 89, 23);
		getContentPane().add(btnLogOut);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\back.PNG"));
		btnNewButton.setBounds(0, 0, 37, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(873, 7, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(985, 7, 89, 23);
		getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(1103, 7, 89, 23);
		getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(1263, 85, 89, 23);
		getContentPane().add(btnSearch);
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
				{null, "n1", null},
				{null, "n2", null},
				{null, "n3", null},
				{null, "n4", null},
				{null, "n5", null},
				{null, "n6", null},
				{null, "n7", null},
				{null, "n8", null},
				{null, "n9", null},
				{null, "n10", null},
				{null, "n11", null},
				{null, "n12", null},
				{null, "n13", null},
				{null, "n14", null},
				{null, "n15", null},
				{null, "n16", null},
				{null, "n17", null},
				{null, "n18", null},
				{null, "n19", null},
				{null, "n20", null},
				{null, "n21", null},
			},
			new String[] {
				"Date", "Supplier Name", "Address"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setMinWidth(25);

		JScrollPane jsP = new JScrollPane(table);
		jsP.setAutoscrolls(true);
		jsP.setBounds(426,119,648,575);
		jsP.getViewport().setBackground(new Color(85,107,47));
		jsP.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(jsP);
		table.setRowHeight(30);
		table.getTableHeader().setPreferredSize(new Dimension(jsP.getWidth(), 40));
		table.getTableHeader().setFont(new Font("Sherif",Font.BOLD,20));
		table.getTableHeader().setBackground(Color.GREEN);
	}
}
