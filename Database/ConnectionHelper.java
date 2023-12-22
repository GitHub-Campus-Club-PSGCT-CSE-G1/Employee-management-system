package Database;

import Employee.EmployeeData;
import java.sql.*;
import java.util.*;
import java.util.Date;

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

    public static void createEmployeeTable() throws SQLException {
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

    public static void deleteEmployeeTable() throws SQLException {
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

    public static void createHealthandSafetyTable() {
        try (Connection connection = getConnection()) {
            String query = "CREATE TABLE HealthandSafety ("
                    + "subject VARCHAR(255),"
                    + "issue VARCHAR(255),"
                    + "department VARCHAR(255),"
                    + "type VARCHAR(255),"
                    + "creationtimeanddate TIMESTAMP)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getHealthandSafetyData(int empid) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM health_data WHERE employee_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, empid);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int employeeId = resultSet.getInt("employee_id");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String gender = resultSet.getString("gender");
                String bloodPressure = resultSet.getString("blood_pressure");
                float cholesterolLevel = resultSet.getFloat("cholesterol_level");
                float bloodSugarLevel = resultSet.getFloat("blood_sugar_level");
                float weight = resultSet.getFloat("weight");
                float height = resultSet.getFloat("height");

                System.out.println("ID: " + id);
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Date of Birth: " + dateOfBirth);
                System.out.println("Gender: " + gender);
                System.out.println("Blood Pressure: " + bloodPressure);
                System.out.println("Cholesterol Level: " + cholesterolLevel);
                System.out.println("Blood Sugar Level: " + bloodSugarLevel);
                System.out.println("Weight: " + weight);
                System.out.println("Height: " + height);
                System.out.println();
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertHealthandSafetyData(int employeeId, String dateOfBirth, String gender, String bloodPressure, float cholesterolLevel, float bloodSugarLevel, float weight, float height) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO health_data (employee_id, date_of_birth, gender, blood_pressure, cholesterol_level, blood_sugar_level, weight, height) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employeeId);
            statement.setString(2, dateOfBirth);
            statement.setString(3, gender);
            statement.setString(4, bloodPressure);
            statement.setFloat(5, cholesterolLevel);
            statement.setFloat(6, bloodSugarLevel);
            statement.setFloat(7, weight);
            statement.setFloat(8, height);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteHealthandSafetyData(int id) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM health_data WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void getundecidedapplications() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM applicantstable WHERE applicationdecision = 0";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String applicantName = resultSet.getString("applicant_name");
                String jobTitle = resultSet.getString("job_title");
                String department = resultSet.getString("department");
                int experienceYears = resultSet.getInt("experience_years");
                String qualification = resultSet.getString("qualification");
                String linkToResume = resultSet.getString("linktoresume");
                int onlineAssessmentScore = resultSet.getInt("onlineassessmentscore");
                int roundOneScore = resultSet.getInt("roundonescore");
                int roundTwoScore = resultSet.getInt("roundtwoscore");
                int roundThreeScore = resultSet.getInt("roundthreescore");

                System.out.println("ID: " + id);
                System.out.println("Applicant Name: " + applicantName);
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Department: " + department);
                System.out.println("Experience Years: " + experienceYears);
                System.out.println("Qualification: " + qualification);
                System.out.println("Link to Resume: " + linkToResume);
                System.out.println("Online Assessment Score: " + onlineAssessmentScore);
                System.out.println("Round One Score: " + roundOneScore);
                System.out.println("Round Two Score: " + roundTwoScore);
                System.out.println("Round Three Score: " + roundThreeScore);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getacceptedapplications() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM applicantstable WHERE applicationdecision = 1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String applicantName = resultSet.getString("applicant_name");
                String jobTitle = resultSet.getString("job_title");
                String department = resultSet.getString("department");
                int experienceYears = resultSet.getInt("experience_years");
                String qualification = resultSet.getString("qualification");
                String linkToResume = resultSet.getString("linktoresume");
                int onlineAssessmentScore = resultSet.getInt("onlineassessmentscore");
                int roundOneScore = resultSet.getInt("roundonescore");
                int roundTwoScore = resultSet.getInt("roundtwoscore");
                int roundThreeScore = resultSet.getInt("roundthreescore");

                System.out.println("ID: " + id);
                System.out.println("Applicant Name: " + applicantName);
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Department: " + department);
                System.out.println("Experience Years: " + experienceYears);
                System.out.println("Qualification: " + qualification);
                System.out.println("Link to Resume: " + linkToResume);
                System.out.println("Online Assessment Score: " + onlineAssessmentScore);
                System.out.println("Round One Score: " + roundOneScore);
                System.out.println("Round Two Score: " + roundTwoScore);
                System.out.println("Round Three Score: " + roundThreeScore);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getrejectedapplications() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM applicantstable WHERE applicationdecision = -1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String applicantName = resultSet.getString("applicant_name");
                String jobTitle = resultSet.getString("job_title");
                String department = resultSet.getString("department");
                int experienceYears = resultSet.getInt("experience_years");
                String qualification = resultSet.getString("qualification");
                String linkToResume = resultSet.getString("linktoresume");
                int onlineAssessmentScore = resultSet.getInt("onlineassessmentscore");
                int roundOneScore = resultSet.getInt("roundonescore");
                int roundTwoScore = resultSet.getInt("roundtwoscore");
                int roundThreeScore = resultSet.getInt("roundthreescore");

                System.out.println("ID: " + id);
                System.out.println("Applicant Name: " + applicantName);
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Department: " + department);
                System.out.println("Experience Years: " + experienceYears);
                System.out.println("Qualification: " + qualification);
                System.out.println("Link to Resume: " + linkToResume);
                System.out.println("Online Assessment Score: " + onlineAssessmentScore);
                System.out.println("Round One Score: " + roundOneScore);
                System.out.println("Round Two Score: " + roundTwoScore);
                System.out.println("Round Three Score: " + roundThreeScore);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void markApplicationStatus(int applicationId, int statusBit) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE applicantstable SET applicationdecision = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, statusBit);
            statement.setInt(2, applicationId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void resetAllTables() {
        try {
            deleteEmployeeTable();
            createEmployeeTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRow(String query) {
        Connection connection;
        Statement statement;
        try {
            connection = ConnectionHelper.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void selectQuery(String newQuery) {
        Connection connection;
        Statement statement;
        try {
            connection = ConnectionHelper.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(newQuery);
            ResultSetMetaData metaData = resultSet.getMetaData();

            while (resultSet.next()) {
                for (int i = 1; i <= 9; i++) {
                    System.out.println(metaData.getColumnName(i) + ": " + resultSet.getString(i));
                }
                System.out.println();
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createRelationsTable() {
        try {
            Statement stmt = getConnection().createStatement();
            String sql = "CREATE TABLE Relations " +
                    "(id INTEGER not NULL, " +
                    " communicationChannels VARCHAR(255), " +
                    " conflictResolutionMethods VARCHAR(255), " +
                    " employeeFeedback VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createEmployeeFromUserInputandStore() {
        EmployeeData employee = EmployeeData.createFromUserInput();
        String query = employee.getInsertQuery();
        ConnectionHelper.insertRow(query);
    }
}
