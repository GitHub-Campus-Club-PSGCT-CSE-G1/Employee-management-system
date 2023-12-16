import Database.ConnectionHelper;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connectionHelper.printAllDatabases();
        // Use the connectionHelper object to access the methods of the ConnectionHelper class
    }
}
