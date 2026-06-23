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
            
            
            //Creating statement
        	Statement statement = connection.createStatement();
            
        	//Execute query
            String sql="insert into students values('Ramparbhu.B',20,'ECE')";
            
            int rowAffected = statement.executeUpdate(sql);
            
    		if(rowAffected==0) {
    			System.out.print("Not able to insert the data");
    		}else {
    			System.out.print(rowAffected+" Data insert Successfully!!");
    		}
    		

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }  
    }
}