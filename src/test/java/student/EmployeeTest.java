package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    HourlyEmployee employee1;
    SalaryEmployee employee2;

    @BeforeEach
    void setup(){
        employee1 = new HourlyEmployee("John Doe", "P001", 20.0, 5000.00, 100.00,50.00);
        employee2 = new SalaryEmployee("Joe Lee", "P002", 24000.0,10000.00, 2000.00,150.00);
    }
    @Test
    void getName() {
        assertEquals("John Doe", employee1.getName());
        assertEquals("Joe Lee", employee2.getName());
    }

    @Test
    void getID() {
        assertEquals("P001", employee1.getID());
        assertEquals("P002", employee2.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(20.0, employee1.getPayRate());
        assertEquals(24000.0, employee2.getPayRate());
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", employee1.getEmployeeType());
        assertEquals("SALARY", employee2.getEmployeeType());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(5000.0, employee1.getYTDEarnings());
        assertEquals(10000.0, employee2.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(100.0, employee1.getYTDTaxesPaid());
        assertEquals(2000.0, employee2.getYTDTaxesPaid());
    }

    @Test
    void calculateGrossPay() {
        assertEquals(2600, employee1.calculateGrossPay(100.0));
        assertEquals(1000, employee2.calculateGrossPay(100.0));
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(50.0, employee1.getPretaxDeductions());
        assertEquals(150.0, employee2.getPretaxDeductions());
    }

    @Test
    void runPayroll() {
        assertEquals(1972.42, employee1.runPayroll(100));
        assertEquals(657.48, employee2.runPayroll(100));
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,John Doe,P001,20.00,50.00,5000.00,100.00", employee1.toCSV());
        assertEquals("SALARY,Joe Lee,P002,24000.00,150.00,10000.00,2000.00", employee2.toCSV());
    }
}