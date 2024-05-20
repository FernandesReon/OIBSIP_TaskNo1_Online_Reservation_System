package ConnectivitynQueries;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static final String URl = "jdbc:mysql://localhost:3306/practice";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "alone_Hacker/1258";

    static Connection connection = null;

    public static Connection connectDB(){

        // loading mysql driver.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println(classNotFoundException.getMessage());
        }

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URl, USERNAME, PASSWORD);
                System.out.println("Connection Established.");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return connection;
    }

}