import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Vaibhav@2005"; // Put your MySQL password here

    public static Connection getConnection() throws SQLException {
        System.out.println("Connecting to database...");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
