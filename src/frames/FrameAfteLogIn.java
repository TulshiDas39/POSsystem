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

public class FrameAfteLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) throws SQLException {
		new FrameAfteLogIn();
	}

	
	public FrameAfteLogIn() throws SQLException {
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(85, 107, 47));
		getContentPane().setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(10, 11, 105, 14);
		getContentPane().add(lblCustomerName);
		
		JLabel lblTulshi = new JLabel("Tulshi");
		lblTulshi.setBounds(125, 11, 46, 14);
		getContentPane().add(lblTulshi);
		
		JLabel lblCustomerId = new JLabel("Customer Id:");
		lblCustomerId.setBounds(10, 29, 80, 14);
		getContentPane().add(lblCustomerId);
		
		JLabel label = new JLabel("0183883");
		label.setBounds(109, 29, 62, 14);
		getContentPane().add(label);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(10, 48, 59, 14);
		getContentPane().add(lblBalance);
		
		JLabel label_1 = new JLabel("234341");
		label_1.setBounds(79, 48, 46, 14);
		getContentPane().add(label_1);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(10, 67, 56, 14);
		getContentPane().add(lblCategory);
		
		JLabel lblPlatinum = new JLabel("Platinum");
		lblPlatinum.setBounds(69, 67, 56, 14);
		getContentPane().add(lblPlatinum);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 87, 46, 14);
		getContentPane().add(lblPhone);
		
		JLabel label_2 = new JLabel("01857580099");
		label_2.setBounds(54, 87, 90, 14);
		getContentPane().add(label_2);
		
		JLabel lblCategorisOfProducts = new JLabel("Categories of Products");
		lblCategorisOfProducts.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblCategorisOfProducts.setBounds(510, 149, 251, 26);
		getContentPane().add(lblCategorisOfProducts);
		
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBackground(Color.WHITE);
		//jsP.setViewportView(table);
		table.setModel(new DefaultTableModel(getObjectOfData()
			/*new Object[][] {
				{"n1", "1"},
				{"n2", "2"},
				{"n3", "3"},
				{"n4", "4"},
				{"n5", "5"},
				{"n6", "6"},
				{"n7", "7"},
				{"n8", "8"},
				{"n9", "9"},
				{"n10", "10"},
				{"n11", "11"},
				{"n12", "12"},
				{"n13", "13"},
				{"n14", "14"},
				{"n15", "15"},
				{"n16", "16"},
				{"n17", "17"},
				{"n18", "18"},
				{"n19", "19"},
				{"n20", "20"},
				{"n21", null},
			}*/,
			new String[] {
				"Category Id", "Category Name"
			}
		) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		JScrollPane jsP = new JScrollPane(table);
		jsP.setAutoscrolls(true);
		jsP.setBounds(387,201,492,453);
		jsP.getViewport().setBackground(new Color(85,107,47));
		jsP.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(jsP);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(79);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.setRowHeight(30);
		table.getTableHeader().setPreferredSize(new Dimension(jsP.getWidth(), 40));
		table.getTableHeader().setFont(new Font("Sherif",Font.BOLD,20));
		table.getTableHeader().setBackground(Color.GREEN);
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(46, 139, 87));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBounds(1226, 44, 89, 23);
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new LogInFrame();
			}
		});
		getContentPane().add(btnLogOut);
		
		JButton btnShowProducts = new JButton("Show Products");
		btnShowProducts.setToolTipText("Show all products of selected category");
		btnShowProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowProducts.setFocusPainted(false);
		btnShowProducts.setBackground(new Color(160, 82, 45));
		btnShowProducts.setBounds(995, 196, 159, 30);
		btnShowProducts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(table.getSelectedRow());
				int rowIndex = table.getSelectedRow();
				System.out.println(rowIndex);
				String categoryName = (String)table.getValueAt(rowIndex, 1);
				int id = ((Integer)table.getValueAt(rowIndex, 0)).intValue();
				System.out.println("CateName="+categoryName);
				try {
					new DisplayProducts(categoryName,id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println(categoryName);
			}
		});
		getContentPane().add(btnShowProducts);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public Object [][] getObjectOfData() throws SQLException{
		ResultSet rs = null;
		rs=new CategoryTable().getAllData();
		//rs.last();
		//int totalrows=rs.getRow();
		Object[][] obj=new Object[1000][10000];
		//rs.first();
		int k=0;
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		while(rs.next()){
			obj[k][0]=rs.getInt(1);
			System.out.println(rs.getInt(1));
			//System.out.println(obj[k][0]);
			obj[k][1]=rs.getString(2);
			
			k++;
		}
		return obj;
		
	}

}
