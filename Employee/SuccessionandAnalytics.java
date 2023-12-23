package Employee;

import java.util.Scanner;

public class SuccessionandAnalytics {
    private String employeePerformance;
    private String employeeSuccessionPlan;
    private String employeeSkills;

    public SuccessionandAnalytics() {
        // Default constructor
    }

    public SuccessionandAnalytics(String employeePerformance, String employeeSuccessionPlan, String employeeSkills) {
        this.employeePerformance = employeePerformance;
        this.employeeSuccessionPlan = employeeSuccessionPlan;
        this.employeeSkills = employeeSkills;
    }

    public String getEmployeePerformance() {
        return employeePerformance;
    }

    public void setEmployeePerformance(String employeePerformance) {
        this.employeePerformance = employeePerformance;
    }

    public String getEmployeeSuccessionPlan() {
        return employeeSuccessionPlan;
    }

    public void setEmployeeSuccessionPlan(String employeeSuccessionPlan) {
        this.employeeSuccessionPlan = employeeSuccessionPlan;
    }

    public String getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(String employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public String getInsertQuery() {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO tableName (employeePerformance, employeeSuccessionPlan, employeeSkills) VALUES (");
        query.append("'").append(employeePerformance).append("', ");
        query.append("'").append(employeeSuccessionPlan).append("', ");
        query.append("'").append(employeeSkills).append("')");
        return query.toString();
    }
    
    public static SuccessionandAnalytics createSuccessionandAnalyticsFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee performance: ");
        String employeePerformance = scanner.nextLine();

        System.out.print("Enter employee succession plan: ");
        String employeeSuccessionPlan = scanner.nextLine();

        System.out.print("Enter employee skills: ");
        String employeeSkills = scanner.nextLine();

        SuccessionandAnalytics successionandAnalytics = new SuccessionandAnalytics(employeePerformance, employeeSuccessionPlan, employeeSkills);

        scanner.close();

        return successionandAnalytics;
    }

}


