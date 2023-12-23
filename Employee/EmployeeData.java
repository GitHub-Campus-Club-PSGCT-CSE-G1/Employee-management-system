package Employee;
import java.util.Scanner;

public class EmployeeData {
    private String name;
    private int age;
    private double salary;
    private String designation;
    private String department;
    private String reportingManager;
    private String location;
    private String employeeType;
    private String employeeId;
    private String employeeStatus;
    private String employeeEmail;
    private String employeePhone;
    private String employeeAddress;
    private String employeeBankAccount;
    private String team;
    // ...

    public String getInsertQuery() {
        String query = "INSERT INTO Employee (name, age, salary, designation, department, reportingManager, location, employeeType, employeeId) VALUES (";
        query += "'" + name + "', ";
        query += age + ", ";
        query += salary + ", ";
        query += "'" + designation + "', ";
        query += "'" + department + "', ";
        query += "'" + reportingManager + "', ";
        query += "'" + location + "', ";
        query += "'" + employeeType + "', ";
        query += "'" + employeeId + "'";
        query += ")";
        return query;
    }
    
    // Default constructor
    public EmployeeData() {
    }
    
    // Constructor with name, age, and salary parameters
    public EmployeeData(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    // Constructor with all parameters
    public EmployeeData(String name, int age, double salary, String designation, String department, String reportingManager, String location, String employeeType, String employeeId) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
        this.department = department;
        this.reportingManager = reportingManager;
        this.location = location;
        this.employeeType = employeeType;
        this.employeeId = employeeId;
    }
    
    public static EmployeeData createFromUserInput() {
        Scanner scanner = new Scanner(System.in);
            
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
            
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
            
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
            
        System.out.print("Enter designation: ");
        scanner.nextLine();
        String designation = scanner.nextLine();
            
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
            
        System.out.print("Enter reporting manager: ");
        String reportingManager = scanner.nextLine();
            
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
            
        System.out.print("Enter employee type: ");
        String employeeType = scanner.nextLine();
            
        System.out.print("Enter employee ID: ");
        String employeeId = scanner.nextLine();

        
        return new EmployeeData(name, age, salary, designation, department, reportingManager, location, employeeType, employeeId);
    }
    

    
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getReportingManager() {
        return reportingManager;
    }
    
    public void setReportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getEmployeeType() {
        return employeeType;
    }
    
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getEmployeeStatus() {
        return employeeStatus;
    }
    
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
    
    public String getEmployeeEmail() {
        return employeeEmail;
    }
    
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
    
    public String getEmployeePhone() {
        return employeePhone;
    }
    
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
    
    public String getEmployeeAddress() {
        return employeeAddress;
    }
    
    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
    
    public String getEmployeeBankAccount() {
        return employeeBankAccount;
    }
    
    public void setEmployeeBankAccount(String employeeBankAccount) {
        this.employeeBankAccount = employeeBankAccount;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
}
    

