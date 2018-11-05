package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SellerTable {
	public void createNewSellerTable() {
	       // SQL statement for creating a new table
		String tableName = "SellerTable";
	
		POSdatabase database = new POSdatabase();
	        String sql = "CREATE TABLE IF NOT EXISTS " +tableName+ " (\n"
	                + "	id integer PRIMARY KEY,\n"
	                + "	name text,\n"
	                + "	phone text,\n"
	                + " address text NOT NULL,\n"
	                + "password text NOT NULL\n"
	                + ");"; 
	        
	        try (Connection conn = database.connect();
	                Statement stmt = conn.createStatement()) {
	            stmt.execute(sql);
	            System.out.println("Table created sucessfully.");
	            System.out.println(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	
	public void insertIntoSellerTable(int id, String name, String phone,String address,char[] password) {
     String sql = "INSERT INTO " + "SellerTable"+ "(id,name,phone,address,password) VALUES(?,?,?,?,?)";
		POSdatabase database = new POSdatabase();

     try (Connection conn = database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
         pstmt.setInt(1, id);
         pstmt.setString(2, name);
         pstmt.setString(3, phone);
         pstmt.setString(4, address);
         pstmt.setString(5, String.valueOf(password));
         
         pstmt.executeUpdate();
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 }
	public boolean isPasswordExistInTable(int enteredId , String enteredPassword){
		String sql = "SELECT id,name,phone,address,password FROM " + "SellerTable";
		ResultSet rs=null;
		System.out.println(enteredPassword);
		JOptionPane.showMessageDialog(null, enteredPassword);
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
	
	public ResultSet getAllData(){
		String sql = "SELECT id,name,phone,address,password FROM " + "SellerTable";
		ResultSet rs=null;
		POSdatabase database = new POSdatabase();
     try{
     		Connection conn = database.connect();
     		Statement stmt  = conn.createStatement();
         	 rs    = stmt.executeQuery(sql);
         // loop through the result set
        while (rs.next()) {
             System.out.println(rs.getInt("id") +  "\t" + 
                                rs.getString("name")+"\t"+rs.getString("password"));
         }   
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
	 return rs;
     
	}
	
	public void update(int id, String name, String phone,String address,char[] password,int toChangeId) {
     String sql = "UPDATE " + "SellerTable"+ " SET  name = ? , "
             + "id = ? ,"
     		+"phone = ? ,"
             +"address = ? ,"
             +"password= ? "
             + "WHERE id = ?";
     
     POSdatabase database = new POSdatabase();

     try (Connection conn = database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

         // set the corresponding param
         pstmt.setString(1, name);
         pstmt.setInt(2, id);
         pstmt.setString(3, phone);
         pstmt.setString(4, address);
         pstmt.setString(5, password.toString());
         pstmt.setInt(6, toChangeId);
         // update 
         pstmt.executeUpdate();
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 }
	
	public void delete(int id) {
     String sql = "DELETE FROM " + "SellerTable"+ " WHERE id = ?";
     POSdatabase database = new POSdatabase();

     try (Connection conn = database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

         // set the corresponding param
         pstmt.setInt(1, id);
         // execute the delete statement
         pstmt.executeUpdate();

     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 }
	public boolean SearchSellerId(int id) {
        String sql = "SELECT id FROM " + "Sellertable"+ " WHERE id = ?";
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
	
	 public void deleteTable(){
	    	String sql = "DROP TABLE SellerTable";
	    	
			POSdatabase database = new POSdatabase();
	         
	         try (Connection conn = database.connect();
	                 Statement stmt = conn.createStatement()) {
	             // create a new table
	             stmt.execute(sql);
	             System.out.println("Table deleted sucessfully.");
	             System.out.println(sql);
	         } catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }
	     }
		
	
	public static void main(String[] args) {
		POSdatabase database = new POSdatabase();
		database.createNewDatabase();
		SellerTable table = new SellerTable();
		//table.createNewSellerTable();
		//table.insertIntoSellerTable(2332, "ssad", "sdk", "dskd", "slkd".toCharArray());
		//table.update(234, "sdkl", "sdjsd", "sdsdk", "sdk;l".toCharArray(), 233);
		table.getAllData();
	}
	
	
}
