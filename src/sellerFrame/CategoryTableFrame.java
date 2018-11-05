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

import copyFrame.CategoryEditorFrame;
import dataBase.CategoryTable;
import dataBase.CustomerTable;
import dataBase.ProductTable;
import dataBase.UpdatedMessageFrame;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class CategoryTableFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public static void main(String[] args) throws SQLException {
		new CategoryTableFrame();
	}

	
	public CategoryTableFrame() throws SQLException {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 400));
		getContentPane().setBackground(new Color(128, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel lblCategorisOfProducts = new JLabel("Category Table");
		lblCategorisOfProducts.setFont(new Font("Californian FB", Font.BOLD, 21));
		lblCategorisOfProducts.setBounds(673, 49, 155, 26);
		getContentPane().add(lblCategorisOfProducts);
		
		
		
		createTableOfProducts();
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(new Color(46, 139, 87));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBounds(1263, 7, 89, 23);
		btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CategoryAdderFrame();
			}
		});
		btnAdd.setBounds(873, 7, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(985, 7, 89, 23);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
				int toChangeId,id;
				String name;
				toChangeId= Integer.valueOf(JOptionPane.showInputDialog("Enter the id of row you want od update")).intValue();
				id = Integer.valueOf(JOptionPane.showInputDialog("Enter updated id")).intValue();
				name = JOptionPane.showInputDialog("Enter updated Category name");
				new CategoryTable().update(id, name, toChangeId);
				dispose();
				new UpdatedMessageFrame();
				//new CategoryEditorFrame();
			}
		});
		getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(1103, 7, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int toDeleteId = Integer.valueOf(JOptionPane.showInputDialog("Enter id of row to delete ")).intValue();
				new CategoryTable().delete(toDeleteId);
				new DeletedMessageFrame();
			}
		});
		getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(1263, 85, 89, 23);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//new ProductTable().insertIntoProductTable(id, name, category, price, unit, quantity);
				/*int proId;
				String name,category,unit;
				double price, quantity;*/
				int id = Integer.valueOf(JOptionPane.showInputDialog("Enter id to search")).intValue();
				boolean t = new CategoryTable().SearchCategoryId(id);
				if(t){
					new CategoryTable().searchCategoryInformation(id);
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
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(25);

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
		
		/*
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
	/*		new String[] {
				"Customer Id", "Customer Name", "Phone Number", " Type", "Balance"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class
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
		 */
		 
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
