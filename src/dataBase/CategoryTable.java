package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sellerFrame.CategorySearchOutPutFrame;

public class CategoryTable {
	
	public void createNewCategoryTable() {
		POSdatabase database = new POSdatabase();
        // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS " + "CategoryTable"+ " (\n"
                 + "	id integer PRIMARY KEY,\n"
                 + "	name text\n"
                 + ");";
         
         try (Connection conn = database.connect();
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
             System.out.println("Category Table created sucessfully.");
             System.out.println(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
	
	public void insertIntoCategoryTable(int id, String name) {
        String sql = "INSERT INTO " + "CategoryTable"+ " (id,name) VALUES(?,?)";
		POSdatabase database = new POSdatabase();

        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public ResultSet getSingleData(int id){
		String sql = "SELECT id, name"
                + " FROM CategoryTable " + " WHERE id = ?";
		POSdatabase database = new POSdatabase();
		ResultSet rs = null;
		 try (Connection conn = database.connect();
		      PreparedStatement pstmt  = conn.prepareStatement(sql)){
		     
		     // set the value
			 pstmt.setInt(1,id);
			 //
			 rs  = pstmt.executeQuery();
			 
			 // loop through the result set
		/*	 while (rs.next()) {
			     System.out.println(rs.getInt("id") +  "\t" + 
			                    rs.getDouble("points"));
			 } */
		 } catch (SQLException e) {
		     System.out.println(e.getMessage());
		 }
		 
		 return rs;
	}
	
	public boolean SearchCategoryId1(int id) {
        String sql = "SELECT id FROM " + "CategoryTable"+ " WHERE id = ?";
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
    
	
	public ResultSet getAllData(){
		String sql = "SELECT id, name FROM " + "CategoryTable";
		ResultSet rs=null;
		POSdatabase database = new POSdatabase();
        try{
        		Connection conn = database.connect();
        		Statement stmt  = conn.createStatement();
            	 rs    = stmt.executeQuery(sql);
            // loop through the result set
          /* while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name"));
            }   */
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	 return rs;
        
	}
	
	public void update(int id, String name,int toChangeId) {
        String sql = "UPDATE " + "CategoryTable"+ " SET  name = ? , "
                + "id = ? "
                + "WHERE id = ?";
        
        POSdatabase database = new POSdatabase();
 
        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setInt(3, toChangeId);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void delete(int id) {
        String sql = "DELETE FROM " + "CategoryTable"+ " WHERE id = ?";
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
	
	public boolean SearchCategoryId(int id) {
        String sql = "SELECT id FROM " + "CategoryTable"+ " WHERE id = ?";
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
           // pstmt.executeUpdate();
         //   conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return false;
    }
	
	 public void deleteTable(){
	    	String sql = "DROP TABLE CategoryTable";
	    	
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
		
	
	public static void main(String[] args) throws SQLException {
		//POSdatabase database = new POSdatabase();
	//	database.createNewDatabase();
		CategoryTable table = new CategoryTable();
		//table.createNewCategoryTable();
	//	table.insertIntoCategoryTable(0001, "junkFood");
		//table.update(24, "jddj",23);
		//table.delete(233);
	//	table.getAllData();
		/*ResultSet rs = table.getSingleData(24);
		while(rs.next()){
			System.out.println("entered");
			System.out.println(rs.getInt("id"));
		}*/
		 
	}

	public void searchCategoryInformation(int id) {
		//id, name, category, price,unit, quantity
   	 String sql = "SELECT id,name FROM CategoryTable "+ " WHERE id = ?";
    	
        POSdatabase database = new POSdatabase();
   	 try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
              ResultSet rs  = pstmt.executeQuery();
             int CatId;
				String name;
				double price, quantity;
            // execute the delete statement
           if(rs.next()) {
           	
           	CatId = rs.getInt("id");
				System.out.println("\n\n\n");
				System.out.println(CatId);
				name = rs.getString("name");
				CategorySearchOutPutFrame a = new CategorySearchOutPutFrame(CatId, name);
				//new ProductSearchOutPutFrame(proId,name,category,price,unit,quantity);
           
           }
   	 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	
	}

	
	
}
