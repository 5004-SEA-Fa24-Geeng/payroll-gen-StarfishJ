package student;

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }
     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] a = csv.split(",");
        if (a.length != 7) {
            System.out.println("ERROR: Invalid employee data.");
        }

        try {
            if (a[0].equals("HOURLY")) {
                return new HourlyEmployee(
                        a[1],
                        a[2],
                        Double.parseDouble(a[3]),
                        Double.parseDouble(a[5]),
                        Double.parseDouble(a[6]),
                        Double.parseDouble(a[4])
                );
            } else {
                return new SalaryEmployee(
                        a[1],
                        a[2],
                        Double.parseDouble(a[3]),
                        Double.parseDouble(a[5]),
                        Double.parseDouble(a[6]),
                        Double.parseDouble(a[4]));
            }
        } catch (NumberFormatException e) {
            System.out.println("CSV contains incorrect number");
            }
        return null;
    }
   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] a = csv.split(",");
        if (a.length != 2) {
            System.out.println("ERROR: CSV contains incorrect number of columns");
        }
        return new TimeCard(a[0], Double.parseDouble(a[1]));
    }


}
