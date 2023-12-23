package Employee;
import Database.ConnectionHelper;
import java.util.Scanner;

public class HealthandSafety {
    ConnectionHelper connectionHelper = new ConnectionHelper();
    public class IncidentReporting {
        public static void reportIncident() {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();
            
            System.out.print("Enter issue: ");
            String issue = scanner.nextLine();
            
            System.out.print("Enter department: ");
            String department = scanner.nextLine();
            
            ConnectionHelper.createincident(subject, issue, department, "HS");
        }

        public static void viewIncident() {
            ConnectionHelper.getincidents("HS");
        }

        public static void deleteIncident(String id) {
            ConnectionHelper.deleteincident(id);
        }
    }

    public class HealthRecords {
        public static void viewHealthRecords(int employee_id) {
            ConnectionHelper.getHealthandSafetyData(employee_id);
        }

        public static void insertHealthRecords(int employeeId, String dateOfBirth, String gender, String bloodPressure, float cholesterolLevel, float bloodSugarLevel, float weight, float height) {
            ConnectionHelper.insertHealthandSafetyData(employeeId, dateOfBirth, gender, bloodPressure,cholesterolLevel,bloodSugarLevel,weight,height);
        }

        public static void deleteHealthRecords(int recordid) {
            ConnectionHelper.deleteHealthandSafetyData(recordid);
        }
    }

}
