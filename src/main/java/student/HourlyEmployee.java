package student;

public class HourlyEmployee extends Employee {
    private final String EMPLOYEETYPE = "HOURLY";   // Employee Type is HOURLY
    private static final double OVERTIMEMULTIPLIER = 1.5; // The overtime multiplier is 1.5
    /**
     * @param name
     * @param id
     * @param payRate
     * @param ytdEarnings
     * @param ytdTaxesPaid
     * @param pretaxDeductions
     */
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Gets the employee's Type as a string.
     * <p>
     * Either "HOURLY" or "SALARY" depending on the type of employee.
     * <p>
     * You may want to consider using an enum to store
     * the type, and using .name() to get the string representation.
     * @return the type of the employee as a string
     */
    @Override
    public String getEmployeeType() {
        return EMPLOYEETYPE;
    }

    /**
     * Runs the employee's payroll.
     * <p>
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     * <p>
     * taxes are calculated as 1.45% for medicare, 6.2% for social security, and 15% for
     * withholding. or 22.65% total. They are calculated on the net pay (after pretax deductions).
     * <p>
     * For hourly employees, the pay is calculated as payRate * hoursWorked for the first 40 hours,
     * then payRate * 1.5 * (hoursWorked - 40) for overtime.
     * <p>
     * For salary employees, it is pay rate divided by 24 for two payments every month.
     * <p>
     * If either type of employee has < 0 hours, they are skipped this payroll period.
     * (suggestion return null, and skip adding nulls to your paystub list)
     * <p>
     * Final net pay is calculated as pay - pretaxDeductions - taxes.
     * <p>
     * All numbers (across all methods) are rounded to the nearest cent. (2 decimal places)
     * <p>
     * SUGGESTION: You may want to use BigDecimal for the calculations to avoid floating point errors.
     * SUGGESTION: You may want to create an protected abstract calculateGrossPay(double hoursWorked)
     * method to calculate the gross pay for the pay period, as runPayroll is exactly
     * the same for both SalaryEmployee and HourlyEmployee, but calculateGrossPay is different.
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    @Override
    public double calculateGrossPay(double hoursWorked) {
        // overtime hours are hours excluding 40 hours
        double payRate = getPayRate();
        if (hoursWorked >= 0 && hoursWorked <= 40) {
            return payRate * hoursWorked;
        } else  {
            return payRate * 40 + payRate * OVERTIMEMULTIPLIER * (hoursWorked - 40);
        }
    }

}
