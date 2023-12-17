package Employee;

import java.util.HashMap;
import java.util.Map;

public class SuccessionandAnalytics {
    private Map<String, Integer> employeePerformance;
    private Map<String, String> employeeSuccessionPlan;
    private Map<String, String> employeeSkills;

    public SuccessionandAnalytics() {
        employeePerformance = new HashMap<>();
        employeeSuccessionPlan = new HashMap<>();
        employeeSkills = new HashMap<>();
    }

    // Method to set employee performance ratings
    public void setEmployeePerformance(String employeeId, int performanceRating) {
        employeePerformance.put(employeeId, performanceRating);
        System.out.println("Updated performance rating for Employee ID " + employeeId + " to " + performanceRating);
    }

    // Method to set succession plans for employees
    public void setEmployeeSuccessionPlan(String employeeId, String successorId) {
        employeeSuccessionPlan.put(employeeId, successorId);
        System.out.println("Succession plan set for Employee ID " + employeeId + ": Successor ID " + successorId);
    }

    // Method to set employee skills
    public void setEmployeeSkills(String employeeId, String skills) {
        employeeSkills.put(employeeId, skills);
        System.out.println("Updated skills for Employee ID " + employeeId + ": " + skills);
    }

    // Method to display employee performance ratings
    public void displayEmployeePerformance() {
        System.out.println("Employee performance ratings:");
        for (Map.Entry<String, Integer> entry : employeePerformance.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey() + ", Performance Rating: " + entry.getValue());
        }
    }

    // Method to display succession plans
    public void displayEmployeeSuccessionPlan() {
        System.out.println("Employee succession plans:");
        for (Map.Entry<String, String> entry : employeeSuccessionPlan.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey() + ", Successor ID: " + entry.getValue());
        }
    }

    // Method to display employee skills
    public void displayEmployeeSkills() {
        System.out.println("Employee skills:");
        for (Map.Entry<String, String> entry : employeeSkills.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey() + ", Skills: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        SuccessionandAnalytics succession = new SuccessionandAnalytics();

        // Setting employee performance ratings
        succession.setEmployeePerformance("EMP001", 8);
        succession.setEmployeePerformance("EMP002", 7);

        // Setting succession plans
        succession.setEmployeeSuccessionPlan("EMP001", "EMP003");
        succession.setEmployeeSuccessionPlan("EMP002", "EMP004");

        // Setting employee skills
        succession.setEmployeeSkills("EMP001", "Leadership, Communication");
        succession.setEmployeeSkills("EMP002", "Problem-solving, Teamwork");

        // Displaying information
        succession.displayEmployeePerformance();
        succession.displayEmployeeSuccessionPlan();
        succession.displayEmployeeSkills();
    }
}

