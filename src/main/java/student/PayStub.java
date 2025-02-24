package student;

public class PayStub implements IPayStub {
    /**
     * The employee name in payStub.
     */
    private String employeeName;    //The name of the employee.
    /**
     * The netPay in payStub.
     */
    private double netPay;          //The net pay for the current pay period.
    /**
     * The taxesPaid in payStub.
     */
    private double taxesPaid;       //The taxes paid for the current pay period.
    /**
     * The ytdEarnings in payStub.
     */
    private double ytdEarnings;     //The year-to-date earnings.
    /**
     * The ytdTaxesPaid in payStub.
     */
    private double ytdTaxesPaid;    //The year-to-date taxes paid.

    /**
     * Constructor for PayStub.
     * @param employeeName The name of the employee.
     * @param netPay       The net pay for the current pay period.
     * @param taxesPaid    The taxes paid for the current pay period.
     * @param ytdEarnings  The year-to-date earnings.
     * @param ytdTaxesPaid The year-to-date taxes paid.
     */
    public PayStub(String employeeName, double netPay, double taxesPaid, double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxesPaid = taxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Gets the net pay for the pay period.
     * @return net pay.
     */
    @Override
    public double getPay() {
        return netPay;
    }

    /**
     * Gets the taxes paid for the pay period.
     * @return taxes paid.
     */
    @Override
    public double getTaxesPaid() {
        return taxesPaid;
    }

    /**
     * Gets year-to-date earnings.
     * @return YTD earnings.
     */
    public double getYtdEarnings() {
        return ytdEarnings;
    }

    /**
     * Gets year-to-date taxes paid.
     * @return YTD taxes paid.
     */
    public double getYtdTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * Converts the pay stub to a CSV format string.
     * @return CSV-formatted string.
     */
    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                employeeName, netPay, taxesPaid, ytdEarnings, ytdTaxesPaid);
    }
}
