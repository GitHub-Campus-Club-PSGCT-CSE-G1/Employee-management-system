package Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionHelper {
    private static final String DB_URL = "jdbc:mysql://oops-project.c4akklqrk5xe.ap-south-1.rds.amazonaws.com:3306/";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "P5PXmXjeqcT3DTYH";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void printAllDatabases() {
        try (Connection connection = getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getCatalogs();

            while (resultSet.next()) {
                String databaseName = resultSet.getString("TABLE_CAT");
                System.out.println(databaseName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
