import Employee.EmployeeData;
import Database.ConnectionHelper;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionHelper.resetAllTables();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Reset all tables");
            System.out.println("2. Create employee from user input and store");
            System.out.println("3. View Employee Table");
            System.out.println("4. Create succession and analytics from user input and store");
            System.out.println("5. View Succession and Analytics Table");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ConnectionHelper.resetAllTables();
                    break;
                case 2:
                    ConnectionHelper.createEmployeeFromUserInputandStore();
                    break;
                case 3:
                    String query = "SELECT * FROM Employee";
                    ConnectionHelper.selectQuery(query);
                    break;
                case 4:
                    ConnectionHelper.createSuccessionAndAnalyticsFromUserInputAndStore();
                    break;
                case 5:
                    query = "SELECT * FROM SuccessionandAnalytics";
                    System.out.println();
                    ConnectionHelper.selectQuery(query);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 6);
        
        scanner.close();
    }
}
