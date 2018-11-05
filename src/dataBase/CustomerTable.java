package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import sellerFrame.CustomerSearchOutPutFrame;
import sellerFrame.ProductSearchOutPutFrame;

public class CustomerTable {

	public void createNewCustomerTable() {
	       // SQL statement for creating a new table
		String tableName = "CustomerTable";
	
		POSdatabase database = new POSdatabase();
	        String sql = "CREATE TABLE IF NOT EXISTS " +tableName+ " (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text,\n"
	                + "	phone text,\n"
	                +" balence real NOT NULL,\n"
	                +" type text NOT NULL,\n"
	                +" password text NOT NULL\n"
	                + ");"; 
	        
	        try (Connection conn = database.connect();
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql);
	            System.out.println("Table created sucessfully.");
	            System.out.println(sql);
	           // conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        
	    }
	
	public void insertIntoCustomerTable(int id, String name, String phone,double balence,char[] password) {
        String sql = "INSERT INTO " + "CustomerTable"+ " (id,name,phone,type,balence,password) VALUES(?,?,?,?,?,?)";
		String type;
        POSdatabase database = new POSdatabase();
		if(balence<=1000) type = "classic";
		else if(balence >1000 && balence <=10000) type = "premium";
		else type = "platinum";

        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setDouble(4, balence);
            pstmt.setString(5, type);
            pstmt.setString(6, String.valueOf(password));
            
            pstmt.executeUpdate();
          //  conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public ResultSet getAllData(){
		String sql = "SELECT id, name, phone, balence, type, password FROM " + "CustomerTable";
		ResultSet rs=null;
		POSdatabase database = new POSdatabase();
        try{
        		Connection conn = database.connect();
        		Statement stmt  = conn.createStatement();
            	 rs    = stmt.executeQuery(sql);
            // loop through the result set
         /*  while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name")+  "\t"+rs.getString("phone") +  "\t" +
                                   rs.getDouble("balence") +  "\t" +
                                   rs.getString("type") +  "\t" +
                                   rs.getString("password") 
                			);
            }   */
           //conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	 return rs;
        
	}
	public void searchCustomerInformation(int id)
    {
		//id, name, phone, balence, type, 
    	 String sql = "SELECT id,name, phone,type,balence FROM CustomerTable "+ " WHERE id = ?";
     	;
         POSdatabase database = new POSdatabase();
    	 try (Connection conn = database.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
  
             // set the corresponding param
             pstmt.setInt(1, id);
               ResultSet rs  = pstmt.executeQuery();
              int cusId;
				String name,phone,type;
				double balence;
             // execute the delete statement
            if(rs.next()) {
            	
            	cusId = rs.getInt("id");
				System.out.println("\n\n\n");
				System.out.println(cusId);
				name = rs.getString("name");
				
				phone = rs.getString("phone");
				balence= Double.valueOf(rs.getString("type"));
				
				type	 = String.valueOf(rs.getDouble("balence"));
				if(balence<=1000) type = "classic";
				else if(balence >1000 && balence <=10000) type = "premium";
				else type = "platinum";
				
				System.out.println(type);
				CustomerSearchOutPutFrame a=new CustomerSearchOutPutFrame(cusId, name, phone, type ,balence);
				//new ProductSearchOutPutFrame(proId,name,category,price,unit,quantity);
            
            }
    	 
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
		 
    }
    
	public boolean isPasswordExistInTable(int enteredId , String enteredPassword){
		String sql = "SELECT id, name, phone, balence, type, password FROM " + "CustomerTable";
		ResultSet rs=null;
		System.out.println(enteredPassword);
		JOptionPane.showMessageDialog(null, enteredPassword);
		JOptionPane.showMessageDialog(null, enteredId);
		POSdatabase database = new POSdatabase();
     try{
     		Connection conn = database.connect();
     		Statement stmt  = conn.createStatement();
         	 rs    = stmt.executeQuery(sql);
         // loop through the result set
        while (rs.next()) {
           /*  System.out.println(rs.getInt("id") +  "\t" + 
                                rs.getString("name")+"\t"+rs.getString("password"));
             					*/
             int id = rs.getInt("id");
             String password = rs.getString("password");
             if(enteredPassword.equals(password) && (enteredId == id) )return true;
         }   
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
	 return false;
	}
	
	
	public void update(int id, String name, String phone,double balence,char[] password,int toChangeId) {
        String sql = "UPDATE " + "CustomerTable"+ " SET  name = ? , "
                + "id = ? ,"
        		+"phone = ? ,"
                +"balence = ? ,"
        		+"type = ? ,"
                +"password=? "
                + "WHERE id = ?";
        String type;
        if(balence<=1000) type = "classic";
		else if(balence >1000 && balence <=10000) type = "premium";
		else type = "platinum";
        
        POSdatabase database = new POSdatabase();
 
        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, phone);
            pstmt.setDouble(4, balence);
            pstmt.setString(5, type);
            pstmt.setString(6, password.toString());
            pstmt.setInt(7, toChangeId);


            // update 
            pstmt.executeUpdate();
           // conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void delete(int id) {
        String sql = "DELETE FROM " + "CustomerTable"+ " WHERE id = ?";
        POSdatabase database = new POSdatabase();

        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
         //   conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	public boolean SearchCustomerId(int id) {
        String sql = "SELECT id FROM " + "CustomerTable"+ " WHERE id = ?";
        POSdatabase database = new POSdatabase();

        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
            	return true;
            }
            // execute the delete statement
            pstmt.executeUpdate();
         //   conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return false;
    }
	
	public String getPassword(int id){
		  String sql = "SELECT id,password FROM " + "CustomerTable"+ " WHERE id = ?";
	        POSdatabase database = new POSdatabase();

	        try (Connection conn = database.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setInt(1, id);
	            ResultSet rs=pstmt.executeQuery();
	            if(rs.next()){
	            	return rs.getString("password");
	            }
	            // execute the delete statement
	            pstmt.executeUpdate();
	         //   conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
			return null;
	}
	
	 public void deleteTable(){
	    	String sql = "DROP TABLE CustomerTable";
	    	
			POSdatabase database = new POSdatabase();
	         
	         try (Connection conn = database.connect();
	                 Statement stmt = conn.createStatement()) {
	             // create a new table
	             stmt.execute(sql);
	             System.out.println("Table deleted sucessfully.");
	             System.out.println(sql);
	           //  conn.close();
	         } catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }
	         
	         
	     }
	 
		
	
	public static void main(String[] args) {
		POSdatabase database = new POSdatabase();
	//	database.createNewDatabase();
		CustomerTable table = new CustomerTable();
		//System.out.println(table.SearchCustomerId(4));
		//table.createNewCustomerTable();
		//table.insertIntoCustomerTable(0004, "Tulshi", "01857580099", 1000, "tld".toCharArray());
		//table.update(1111, "jddj", "03937374", 884, "sd", "kdjdjd".toCharArray(),484888);
		//table.getAllData();
		//table.deleteTable();
	}
	
}
