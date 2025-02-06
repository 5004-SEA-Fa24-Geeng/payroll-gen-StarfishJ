package student;

public class TimeCard implements ITimeCard{
    private String employeeID;
    private double hoursWorked;

    public TimeCard(String employeeID, double hoursWorked) {
        this.hoursWorked = hoursWorked;
        this.employeeID = employeeID;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public double getHoursWorked() {
        return hoursWorked;
    }

}
