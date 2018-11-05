package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SuplierTable {
	public void createNewSuplierTable() {
	       // SQL statement for creating a new table
		String tableName = "SuplierTable";
	/*	String sql = "CREATE TABLE IF NOT EXISTS " + tableName+ " (\n"
             + "	id integer PRIMARY KEY,\n"
             + "	name text NOT NULL,\n"
             + "	points real\n"  
             + ");";    */
	//	String tableName = "CustomerTable";
		POSdatabase database = new POSdatabase();
	        String sql = "CREATE TABLE IF NOT EXISTS " +tableName+ " (\n"
	                + "	name text,\n"
	                + "	phone text,\n"
	                +"address text NOT NULL,\n"
	                +"date text NOT NULL \n "
	                + ");"; 
	        
	        try (Connection conn = database.connect();
	                Statement stmt = conn.createStatement()) {
	            // create a new table
	            stmt.execute(sql);
	            System.out.println("Table created sucessfully.");
	            System.out.println(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		
	 	}
	
	public void insertIntoSuplierTable(String name, String phone, String address, String date ) {
     String sql = "INSERT INTO " + "SuplierTable"+ " (name,phone,address,date) VALUES(?,?,?,?)";
		POSdatabase database = new POSdatabase();

     try (Connection conn = database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
         pstmt.setString(1, name);
         pstmt.setString(2, phone);
         pstmt.setString(3, address);
         pstmt.setString(4, date);

         pstmt.executeUpdate();
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 }
	
	public ResultSet getAllData(){
		String sql = "SELECT name, phone,address,date FROM " + "SuplierTable";
		ResultSet rs=null;
		POSdatabase database = new POSdatabase();
     try{
     		Connection conn = database.connect();
     		Statement stmt  = conn.createStatement();
         	 rs    = stmt.executeQuery(sql);
         // loop through the result set
        while (rs.next()) {
             System.out.println(rs.getString("name") +  "\t" + 
                                rs.getString("phone")+"\t"+rs.getString(3));
         }   
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
	 return rs;
     
	}
	
/*	public void update(String name, String phone, String address,String date, int toChangeId) {
     String sql = "UPDATE " + "SuplierTable"+ " SET  name = ? , "
             + "id = ? ,"
     		+"phone = ? ,"
             +"balence = ? ,"
     		+"type = ? ,"
             +"password=? "
             + "WHERE id = ?";
     
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
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 } */
	
/*	public void delete(int id) {
     String sql = "DELETE FROM " + "CustomerTable"+ " WHERE id = ?";
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
 }  */
	
	 public void deleteTable(){
	    	String sql = "DROP TABLE SuplierTable";
	    	
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
	//	database.createNewDatabase();
		SuplierTable table = new SuplierTable();
		//table.createNewSuplierTable();;
		table.insertIntoSuplierTable("Tulshi", "2034", "Bholabo,Rupgonj,Narayngonj", "2-44-23423");
		//table.update(1111, "jddj", "03937374", 884, "sd", "kdjdjd".toCharArray(),484888);
		table.getAllData();
	}
	
	
	
	
}
