package Employee;
import Database.ConnectionHelper;
import java.util.Scanner;

public class HealthandSafety {
    ConnectionHelper connectionHelper = new ConnectionHelper();
    public class IncidentReporting {
        public void reportIncident() {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();
            
            System.out.print("Enter issue: ");
            String issue = scanner.nextLine();
            
            System.out.print("Enter department: ");
            String department = scanner.nextLine();
            
            connectionHelper.createincident(subject, issue, department, "HS");
        }

        public void viewIncident() {
            connectionHelper.getincidents("HS");
        }

        public void deleteIncident(String id) {
            connectionHelper.deleteincident(id);
        }
    }

    public class HealthRecords {
        public void viewHealthRecords() {
            System.out.println("Health records viewed");
        }

        public void editHealthRecords() {
            System.out.println("Health records edited");
        }

        public void deleteHealthRecords() {
            System.out.println("Health records deleted");
        }
    }

    public class SafetyTraining {
        public void viewSafetyTraining() {
            System.out.println("Safety training viewed");
        }

        public void editSafetyTraining() {
            System.out.println("Safety training edited");
        }

        public void deleteSafetyTraining() {
            System.out.println("Safety training deleted");
        }
    }

    public class EmergencyContacts {
        public void viewEmergencyContacts() {
            System.out.println("Emergency contacts viewed");
        }

        public void editEmergencyContacts() {
            System.out.println("Emergency contacts edited");
        }

        public void deleteEmergencyContacts() {
            System.out.println("Emergency contacts deleted");
        }
    }
}
