package sellerFrame;


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

import dataBase.CustomerTable;
import dataBase.ProductTable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class CustomerTableFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) throws SQLException {
		new CustomerTableFrame();
	}

	
	public CustomerTableFrame() throws SQLException {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel lblCategorisOfProducts = new JLabel("Customer Table");
		lblCategorisOfProducts.setFont(new Font("Californian FB", Font.BOLD, 21));
		lblCategorisOfProducts.setBounds(637, 52, 149, 26);
		getContentPane().add(lblCategorisOfProducts);
		
		
		
		createTableOfProducts();
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(46, 139, 87));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBounds(1263, 7, 89, 23);
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new SellerLogIn();
			}
		});
		getContentPane().add(btnLogOut);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\back.PNG"));
		btnNewButton.setBounds(0, 0, 37, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SellerHomePage();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(1263, 85, 89, 23);
        btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new ProductTable().insertIntoProductTable(id, name, category, price, unit, quantity);
				/*int proId;
				String name,category,unit;
				double price, quantity;*/
				int id = Integer.valueOf(JOptionPane.showInputDialog("Enter id to search")).intValue();
				boolean t = new CustomerTable().SearchCustomerId(id);
				if(t){
					new CustomerTable().searchCustomerInformation(id);
				}
				else{
					JOptionPane.showMessageDialog(null, "Id is not in the table","error",JOptionPane.ERROR_MESSAGE);
				}
				
				/*try {
					if(rs.next()){
						
						try {
							proId = rs.getInt("id");
							System.out.println("\n\n\n");
							System.out.println(proId);
							name = rs.getString("name");
							category = rs.getString("category");
							unit = rs.getString("unit");
							price = rs.getDouble("price");
							quantity = rs.getDouble("quantity");
							new ProductSearchOutPutFrame(proId,name,category,price,unit,quantity);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Not found");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		getContentPane().add(btnSearch);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}


	@SuppressWarnings("serial")
	private void createTableOfProducts() throws SQLException {
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBackground(Color.WHITE);
		//jsP.setViewportView(table);
		table.setModel(new DefaultTableModel(getObjectOfData(),
			/*new Object[][] {
				{"n1", "1", "", null, ""},
				{"n2", "2", null, null, null},
				{"n3", "3", null, null, null},
				{"n4", "4", null, null, null},
				{"n5", "5", null, null, null},
				{"n6", "6", null, null, null},
				{"n7", "7", null, null, null},
				{"n8", "8", null, null, null},
				{"n9", "9", null, null, null},
				{"n10", "10", null, null, null},
				{"n11", "11", null, null, null},
				{"n12", "12", null, null, null},
				{"n13", "13", null, null, null},
				{"n14", "14", null, null, null},
				{"n15", "15", null, null, null},
				{"n16", "16", null, null, null},
				{"n17", "17", null, null, null},
				{"n18", "18", null, null, null},
				{"n19", "19", null, null, null},
				{"n20", "20", null, null, null},
				{"n21", null, null, null, null},
			},*/
			new String[] {
				"Customer Id", "Customer Name", "Phone Number", " Type", "Balance"
			}
		) {
			
			
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class
			};
			boolean[] columnEditables = new boolean[]{
					true,true,true,true,true
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setResizable(false);

		JScrollPane jsP = new JScrollPane(table);
		jsP.setAutoscrolls(true);
		jsP.setBounds(208,119,880,575);
		jsP.getViewport().setBackground(new Color(85,107,47));
		jsP.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(jsP);
		table.setRowHeight(30);
		table.getTableHeader().setPreferredSize(new Dimension(jsP.getWidth(), 40));
		table.getTableHeader().setFont(new Font("Sherif",Font.BOLD,20));
		table.getTableHeader().setBackground(Color.GREEN);
	}
	public Object [][] getObjectOfData() throws SQLException{
		ResultSet rs = null;
		rs=new CustomerTable().getAllData();
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
			obj[k][2]=rs.getString(3);
			obj[k][3]=rs.getString(4);
			obj[k][4]=rs.getDouble(5);
			k++;
		}
		return obj;
		
	}

}

