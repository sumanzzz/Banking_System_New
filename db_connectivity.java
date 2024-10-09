import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db_connectivity {
     static final Logger LOGGER = Logger.getLogger(db_connectivity.class.getName());
     static String url = "jdbc:mysql://localhost:3306/banking_system";
     static String user = "root";
     static String password = "Reegan25@08";

    public static Connection Connect(){
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to the database successfully");
        }
        catch(SQLException e){
            LOGGER.log(Level.SEVERE,"Failed to connect to database");
            System.out.println("Failed to connect to database"+e.getMessage());
        }
        catch (ClassNotFoundException e){
            LOGGER.log(Level.SEVERE,"Failed to load JDBC driver",e);
            System.out.println("Failed to load JDBC driver");

        }
        return con;
    }



}