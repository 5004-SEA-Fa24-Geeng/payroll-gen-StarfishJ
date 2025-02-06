package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    SalaryEmployee employee2;

    @BeforeEach
    void Setup(){
        employee2 = new SalaryEmployee("Joe Lee", "P002", 24000.0,10000.00, 2000.00,150.00);
    }

    @Test
    void getName() {
        assertEquals("Joe Lee", employee2.getName());
    }

    @Test
    void getID() {
        assertEquals("P002", employee2.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(24000.0, employee2.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(10000.0, employee2.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(2000.00, employee2.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(150.00, employee2.getPretaxDeductions());
    }

    @Test
    void runPayroll() {
        assertEquals(657.48, employee2.runPayroll(100));
    }

    @Test
    void toCSV() {
        assertEquals("SALARY,Joe Lee,P002,24000.00,150.00,10000.00,2000.00", employee2.toCSV());
    }

    @Test
    void getEmployeeType() {
        assertEquals("SALARY", employee2.getEmployeeType());
    }

    @Test
    void calculateGrossPay() {
        assertEquals(1000, employee2.calculateGrossPay(100.0));
    }
}