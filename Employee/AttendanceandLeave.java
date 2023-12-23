package Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AttendanceandLeave {
    private int employeeId;
    private String date;
    private boolean isPresent;
    private int hoursWorked;
    private int leaveBalance;

    // Constructor
    public AttendanceandLeave(int employeeId, String date, boolean isPresent, int hoursWorked, int leaveBalance) {
        this.employeeId = employeeId;
        this.date = date;
        this.isPresent = isPresent;
        this.hoursWorked = hoursWorked;
        this.leaveBalance = leaveBalance;
    }

    // Getters and setters for variables
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    // Other methods specific to Attendance and Leave management can be added here

    public static AttendanceandLeave createFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int employeeId = scanner.nextInt();

        System.out.print("Enter date (in yyyy-MM-dd format): ");
        String date = scanner.next();
        

        System.out.print("Is present? (true/false): ");
        boolean isPresent = scanner.nextBoolean();

        System.out.print("Enter hours worked: ");
        int hoursWorked = scanner.nextInt();

        System.out.print("Enter leave balance: ");
        int leaveBalance = scanner.nextInt();

        scanner.close();

        return new AttendanceandLeave(employeeId, date, isPresent, hoursWorked, leaveBalance);
    }

    public String getInsertQuery() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO AttendanceAndLeave (employeeId, DATE, isPresent, hoursWorked, leaveBalance) VALUES (");
        queryBuilder.append(employeeId).append(", ");
        queryBuilder.append("'").append(date).append("', ");
        queryBuilder.append(isPresent).append(", ");
        queryBuilder.append(hoursWorked).append(", ");
        queryBuilder.append(leaveBalance).append(")");

        return queryBuilder.toString();
    }
}

