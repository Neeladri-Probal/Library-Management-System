
// DBConnection.java
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver load
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarymanagementsystem",
                    "root", // তোমার username
                    "password" // তোমার MySQL password
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
