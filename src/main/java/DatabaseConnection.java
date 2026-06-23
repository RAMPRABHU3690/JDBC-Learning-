import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 

public class DatabaseConnection {
    public static void main(String[] args) {
        // 1. Define configuration properties
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "1234";

        // 2. Establish the connection using a try-with-resources statement
        // (This ensures the connection closes automatically when done)
        try{
        	Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Successfully connected to the PostgreSQL server!");
            }
            
            
          // Creating statement
            Statement statement = connection.createStatement();
            
            // 2. Execute query (Modified to DELETE a record)
            // This will delete the student named 'Ramparbhu.B'
            String sql = "delete from students where name = 'cdv'";
            
            int rowAffected = statement.executeUpdate(sql);
            
            // 3. Check the result
            if (rowAffected == 0) {
                System.out.print("Not able to delete the data (Record not found)");
            } else {
                System.out.print(rowAffected + " Data deleted Successfully!!");
            }

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }  
    }
}