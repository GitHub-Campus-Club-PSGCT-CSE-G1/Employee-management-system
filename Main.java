import Employee.EmployeeData;
import Database.ConnectionHelper;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionHelper.resetAllTables();      
        ConnectionHelper.createEmployeeFromUserInputandStore();    
        System.out.println();    
        String newQuery = "SELECT * FROM Employee";
        ConnectionHelper.selectQuery(newQuery);
        
        // Create a menu to access all the functions in the ConnectionHelper class
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Reset all tables");
            System.out.println("2. Create employee from user input and store");
            System.out.println("3. Select query");
            System.out.println("4. Exit");
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
                    System.out.print("Enter the query: ");
                    scanner.nextLine(); // Consume the newline character
                    String query = scanner.nextLine();
                    ConnectionHelper.selectQuery(query);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println();
        } while (choice != 4);
        
        scanner.close();
    }
}


