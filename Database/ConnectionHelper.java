package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.sql.Timestamp;

public class ConnectionHelper {

    private static final String DB_URL = "jdbc:mysql://oops-project.c4akklqrk5xe.ap-south-1.rds.amazonaws.com:3306/data";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "P5PXmXjeqcT3DTYH";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void printAllDatabases() {
        try (Connection connection = getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getCatalogs();            

            // Retrieve database information
            String dbName = metaData.getDatabaseProductName();
            String dbVersion = metaData.getDatabaseProductVersion();
            System.out.println("Connected to: " + dbName);
            System.out.println("Database version: " + dbVersion);
            System.out.println();
            while (resultSet.next()) {
                String databaseName = resultSet.getString("TABLE_CAT");
                System.out.println(databaseName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createincident(String subject, String issue, String department, String type) {
        try (Connection connection = getConnection()) {
            // Generate ID
            String id = UUID.randomUUID().toString();

            // Generate creation datetime
            Timestamp creationDateTime = new Timestamp(System.currentTimeMillis());

            String query = "INSERT INTO incidentcollection (id, subject, issue, department, type, creationtimeanddate) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, subject);
            statement.setString(3, issue);
            statement.setString(4, department);
            statement.setString(5, type);
            statement.setTimestamp(6, creationDateTime);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getincidents(String tag) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM incidentcollection WHERE tag = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tag);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve data from the result set
                String id = resultSet.getString("id");
                String subject = resultSet.getString("subject");
                String issue = resultSet.getString("issue");
                String department = resultSet.getString("department");
                String type = resultSet.getString("type");
                Timestamp creationDateTime = resultSet.getTimestamp("creationtimeanddate");

                // Print the retrieved data
                System.out.println("ID: " + id);
                System.out.println("Subject: " + subject);
                System.out.println("Issue: " + issue);
                System.out.println("Department: " + department);
                System.out.println("Type: " + type);
                System.out.println("Creation Date and Time: " + creationDateTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteincident(String id) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM incidentcollection WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
