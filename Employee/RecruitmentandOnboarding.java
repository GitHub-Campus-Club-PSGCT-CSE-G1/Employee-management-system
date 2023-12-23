package Employee;
import Database.ConnectionHelper;
import java.util.Scanner;
public class RecruitmentandOnboarding {
    public class Recruitment {
        public static void getAllUndecidedApplications(){
            System.out.println("UNDECIDED APPLICATIONS: ");
            ConnectionHelper.getundecidedapplications();
        }

        public static void getAllAcceptedApplications(){
            System.out.println("ACCEPTED APPLICATIONS: ");
            ConnectionHelper.getacceptedapplications();
        }

        public static void getAllRejectedApplications(){
            System.out.println("REJECTED APPLICATIONS: ");
            ConnectionHelper.getrejectedapplications();
        }

        public static void markApplicationStatus(int applicationID, int statusBit){
            ConnectionHelper.markApplicationStatus(applicationID, statusBit);
        }

        public static void gradeApplication(){
            getAllUndecidedApplications();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of decisions to mark: ");
            int numberOfDecisions = scanner.nextInt();
            
            for (int i = 0; i < numberOfDecisions; i++) {
                System.out.print("Enter the application ID: ");
                int applicationID = scanner.nextInt();
                
                System.out.print("Enter the status bit: ");
                int statusBit = scanner.nextInt();
                
                markApplicationStatus(applicationID, statusBit);
            }
        }
    }
}