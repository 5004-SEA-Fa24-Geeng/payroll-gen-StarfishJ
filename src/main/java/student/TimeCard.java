package student;

public class TimeCard implements ITimeCard {
    private String employeeID;      //employee ID
    private double hoursWorked;     //hours of work done

    /**
     * @param employeeID
     * @param hoursWorked
     */
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
