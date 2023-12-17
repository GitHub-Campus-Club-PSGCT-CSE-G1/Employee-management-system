package Database;

import java.sql.*;
import java.util.*;

public class ConnectionHelper {

    private static final String DB_URL = "jdbc:mysql://oops-project.c4akklqrk5xe.ap-south-1.rds.amazonaws.com:3306/data";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "P5PXmXjeqcT3DTYH";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void printAllTables() {
        try (Connection connection = getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "%", null);

            // Retrieve database information
            String dbName = metaData.getDatabaseProductName();
            String dbVersion = metaData.getDatabaseProductVersion();
            System.out.println("Connected to: " + dbName);
            System.out.println("Database version: " + dbVersion);
            System.out.println();
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean tableExists(String tableName) throws SQLException {
        DatabaseMetaData metaData = getConnection().getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName, null);

        return resultSet.next();
    }

    public static void createEmployeeTable()throws SQLException{
        String createTableSQL = "CREATE TABLE Employee ("
            + "name VARCHAR(255),"
            + "age INT,"
            + "salary DOUBLE,"
            + "designation VARCHAR(255),"
            + "department VARCHAR(255),"
            + "reportingManager VARCHAR(255),"
            + "location VARCHAR(255),"
            + "employeeType VARCHAR(255),"
            + "employeeId VARCHAR(255),"
            + "employeeStatus VARCHAR(255),"
            + "employeeEmail VARCHAR(255),"
            + "employeePhone VARCHAR(255),"
            + "employeeAddress VARCHAR(255),"
            + "employeeBankAccount VARCHAR(255),"
            + "team VARCHAR(255))";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // Create the table
            statement.executeUpdate(createTableSQL);
            System.out.println("Employee table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmployeeTable() throws SQLException{
        String deleteTableSQL = "DROP TABLE Employee";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // Delete the table
            statement.executeUpdate(deleteTableSQL);
            System.out.println("Employee table deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String generateInsertQuery(String tableName, Map<String, Object> columnValues) {
        if (tableName == null || tableName.isEmpty() || columnValues == null || columnValues.isEmpty()) {
            throw new IllegalArgumentException("Table name or column values cannot be null or empty.");
        }

        StringBuilder insertQuery = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder values = new StringBuilder(") VALUES (");

        boolean first = true;

        for (Map.Entry<String, Object> entry : columnValues.entrySet()) {
            if (!first) {
                insertQuery.append(", ");
                values.append(", ");
            }
            insertQuery.append(entry.getKey());
            values.append("?");

            first = false;
        }

        insertQuery.append(values).append(")");
        return insertQuery.toString();
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
