package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HistoryTable {
	
	public void createNewHistory() {
	       // SQL statement for creating a new table
		String tableName = "HistoryTable";
	/*	String sql = "CREATE TABLE IF NOT EXISTS " + tableName+ " (\n"
             + "	id integer PRIMARY KEY,\n"
             + "	name text NOT NULL,\n"
             + "	points real\n"  
             + ");";    */
	//	String tableName = "CustomerTable";
		POSdatabase database = new POSdatabase();
	        String sql = "CREATE TABLE IF NOT EXISTS " +tableName+ " (\n"
	                + "	date text,\n"
	                + "	customer_id integer,\n"
	                +" cost real NOT NULL\n"
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
	
	public void insertIntoHistoyTable(String date, int customer_id, double cost) {
     String sql = "INSERT INTO " + "HistoryTable"+ " (date,customer_id,cost) VALUES(?,?,?)";
		POSdatabase database = new POSdatabase();

     try (Connection conn = database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
         pstmt.setString(1, date);
         pstmt.setInt(2, customer_id);
         pstmt.setDouble(3, cost);
         
         pstmt.executeUpdate();
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
 }
	
	public ResultSet getAllData(){
		String sql = "SELECT date,customer_id,cost FROM " + "HistoryTable";
		ResultSet rs=null;
		POSdatabase database = new POSdatabase();
     try{
     		Connection conn = database.connect();
     		Statement stmt  = conn.createStatement();
         	 rs    = stmt.executeQuery(sql);
         // loop through the result set
        while (rs.next()) {
             System.out.println(rs.getInt("customer_id") +  "\t" + 
                                rs.getString("date")+"\t"+ rs.getDouble("cost"));
         }   
     } catch (SQLException e) {
         System.out.println(e.getMessage());
     }
	 return rs;
     
	}
	
	 public void deleteTable(){
	    	String sql = "DROP TABLE HistorytTable";
	    	
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
		HistoryTable table = new HistoryTable();
		//table.createNewHistory();
		table.insertIntoHistoyTable("2-3-3434", 123, 23.23);
		//table.delete(233);
		table.getAllData();
	}
	
	
}
