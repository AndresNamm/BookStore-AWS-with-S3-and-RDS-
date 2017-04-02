package dbsetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBsetup {
    
   private DBsetup(){};
   
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        
        Connection c = DriverManager
            .getConnection("jdbc:postgresql://bookstore.cm1wmza1lodb.us-west-2.rds.amazonaws.com:5432/BookStore",
            "book", "bookstore");
	c.setAutoCommit(true);
        return c;
    }
    
//   public static void main(String args[]) {
//      Connection c = null;
//      try {
//         Class.forName("org.postgresql.Driver");
//         c = DriverManager
//            .getConnection("jdbc:postgresql://bookstore.cm1wmza1lodb.us-west-2.rds.amazonaws.com:5432/BookStore",
//            "book", "bookstore");
//      } catch (Exception e) {
//         e.printStackTrace();
//         System.err.println(e.getClass().getName()+": "+e.getMessage());
//         System.exit(0);
//      }
//      System.out.println("Opened database successfully");
//   }
    
    
}