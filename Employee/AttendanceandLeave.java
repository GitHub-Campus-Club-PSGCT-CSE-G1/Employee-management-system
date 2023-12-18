package Employee;
import java.util.Date;

public class AttendanceandLeave {
    private int employeeId;
    private Date date;
    private boolean isPresent;
    private int hoursWorked;
    private int leaveBalance;

    // Constructor
    public AttendanceandLeave(int employeeId, Date date, boolean isPresent, int hoursWorked, int leaveBalance) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}

