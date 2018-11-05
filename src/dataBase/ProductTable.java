package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sellerFrame.ProductSearchOutPutFrame;

public class ProductTable {

	public void createNewProductTable() {
        // SQL statement for creating a new table
    	/* private String id;
	private String name;
	private Category category;
	private double price;
	private double quantity;*/
		POSdatabase database = new POSdatabase();
         String sql = "CREATE TABLE IF NOT EXISTS " + "ProductTable"+ " (\n"  //""
                 + "	id integer PRIMARY KEY,\n"
                 + "	name text,\n"
                 + "	category text,\n"
                 + " price real NOT NULL,\n"
                 + " unit text NOT NULL,\n"
                 +"quantity real NOT NULL\n"
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
	

    public void insertIntoProductTable(int id, String name, String category,double price,String unit, double quantity) {
     
    	
    	/* String sql = "INSERT INTO " + "CustomerTable"+ " (id,name,phone,type,balence,password) VALUES(?,?,?,?,?,?)";
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
    	 */
    	
    	  String sql = "INSERT INTO " + "ProductTable"+ " (id,name,category,price,unit,quantity) VALUES(?,?,?,?,?,?)";
		POSdatabase database = new POSdatabase();

        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, category);
            pstmt.setDouble(4, price);
            pstmt.setString(5, unit);
            pstmt.setDouble(6, quantity);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	
    }
    
    public ResultSet getAllData(){
		String sql = "SELECT id, name, category, price,unit, quantity FROM " + "ProductTable";
		ResultSet rs=null;
		POSdatabase database = new POSdatabase();
        try{
        		Connection conn = database.connect();
        		Statement stmt  = conn.createStatement();
            	 rs    = stmt.executeQuery(sql);
            // loop through the result set
           while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +  rs.getString("category")+"\t"+
                                   rs.getString("name")+  "\t"+rs.getDouble("price")+"\t"+rs.getString("unit")+"\t"+rs.getDouble("quantity"));
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	 return rs;
        
	}
    public boolean SearchProductId(int id) {
        String sql = "SELECT id FROM " + "ProductTable"+ " WHERE id = ?";
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
    
    public void searchProductInformation(int id)
    {
    	//id, name, category, price,unit, quantity
    	 String sql = "SELECT id,name, category, price,unit, quantity FROM ProductTable "+ " WHERE id = ?";
     	;
         POSdatabase database = new POSdatabase();
    	 try (Connection conn = database.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
  
             // set the corresponding param
             pstmt.setInt(1, id);
               ResultSet rs  = pstmt.executeQuery();
              int proId;
				String name,category,unit;
				double price, quantity;
             // execute the delete statement
            if(rs.next()) {
            	
            	proId = rs.getInt("id");
				System.out.println("\n\n\n");
				System.out.println(proId);
				name = rs.getString("name");
				category = rs.getString("category");
				unit = rs.getString("unit");
				price = rs.getDouble("price");
				quantity = rs.getDouble("quantity");
				ProductSearchOutPutFrame a=new ProductSearchOutPutFrame(proId, name, category, price, unit, quantity);
				//new ProductSearchOutPutFrame(proId,name,category,price,unit,quantity);
            
            }
    	 
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
		 
    }
    
    //id, name, category, price, quantity
    public void update(int id, String name, String category,double price,String unit,double quantity,int toChangeId) {
        String sql = "UPDATE " + "ProductTable"+ " SET  name = ? , "
                +"id = ? ,"
        		+"category = ? ,"
                +"price = ? ,"
        		+"unit = ? ,"
        		+"quantity = ? "
                +"WHERE id = ?";
        
        POSdatabase database = new POSdatabase();
 
        try (Connection conn = database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, category);
            pstmt.setDouble(4, price);
            pstmt.setString(5, unit);
            pstmt.setDouble(6, quantity);
            pstmt.setInt(7, toChangeId);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void delete(int id) {
        String sql = "DELETE FROM " + "ProductTable"+ " WHERE id = ?";
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
	
   
    
    public void deleteTable(){
    	String sql = "DROP TABLE ProductTable";
    	
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
		ProductTable table = new ProductTable();
		//table.createNewProductTable();;
		//table.deleteTable();
		//table.insertIntoProductTable(244, "potato", "junkFood", 10.0, "number", 25.0);
		//table.update(24, "jddj",23);
		//table.delete(233);
		table.getAllData();
	}


	public Object[][] getProductsOfCategory(String categoryName) {
		String sql = "SELECT id,name, price,unit, quantity FROM ProductTable "+ " WHERE category = ?";
     	;ResultSet rs=null;
     	Object[][] obj = null;
         POSdatabase database = new POSdatabase();
    	 try (Connection conn = database.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
  
             // set the corresponding param
             pstmt.setString(1, categoryName);
               rs  = pstmt.executeQuery();
               obj=new Object[1000][10000];
       		
       		//rs.first();
       		int k=0;
       		System.out.println("\n");
       		System.out.println("\n");
       		System.out.println("\n");
       		System.out.println("\n");
       		while(rs.next()){
       			obj[k][0]=rs.getInt(1);
       			System.out.println(rs.getInt(1));
       			System.out.println();
       			//System.out.println(obj[k][0]);
       			obj[k][1]=rs.getString(2);
       			System.out.println(rs.getString(2));
       			System.out.println();

       			obj[k][2]=rs.getDouble(3);
       			System.out.println(rs.getDouble(3));
       			System.out.println();

       			obj[k][3] = rs.getString(4);
       			System.out.println(rs.getString(4));
       			System.out.println();

       			obj[k][4] = rs.getDouble(5);
       			System.out.println(rs.getDouble(5));
       			System.out.println();

       			obj[k][5]=false;
       			k++;
       		}
             /* int proId;
				String name,category,unit;
				double price, quantity;*/
             // execute the delete statement
          /*  if(rs.next()) {
            	
            	proId = rs.getInt("id");
				System.out.println("\n\n\n");
				System.out.println(proId);
				name = rs.getString("name");
				unit = rs.getString("unit");
				price = rs.getDouble("price");
				quantity = rs.getDouble("quantity");
				
				//new ProductSearchOutPutFrame(proId,name,category,price,unit,quantity);
            
            }
    	 */
               
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
		 
		return obj;
	}
	
	
    
}
