import Employee.EmployeeData;
import Database.ConnectionHelper;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionHelper.resetAllTables();      
        ConnectionHelper.createEmployeeFromUserInputandStore();    
        System.out.println();    
        String newQuery = "SELECT * FROM Employee";
        ConnectionHelper.selectQuery(newQuery);
    }
}
