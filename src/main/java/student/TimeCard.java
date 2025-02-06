package student;

public class TimeCard implements ITimeCard {
    /**
     * The employee ID in the time card.
     */
    private String employeeID;      //employee ID
    /**
     * The hoursWorked in the time card.
     */
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
