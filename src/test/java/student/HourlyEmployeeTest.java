package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    HourlyEmployee employee1;
    @BeforeEach
    void setUp() {
        employee1 = new HourlyEmployee("John Doe", "P001", 20.0, 5000.00, 100.00,50.00);
    }

    @Test
    void getName() {
        assertEquals("John Doe", employee1.getName());
    }

    @Test
    void getID() {
        assertEquals("P001", employee1.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(20.0, employee1.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(5000.0, employee1.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(100.0, employee1.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(50.0, employee1.getPretaxDeductions());
    }

    @Test
    void runPayroll() {
        assertEquals(1972.42, employee1.runPayroll(100));
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,John Doe,P001,20.00,50.00,5000.00,100.00", employee1.toCSV());
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", employee1.getEmployeeType());
    }

    @Test
    void calculateGrossPay() {
        assertEquals("HOURLY,John Doe,P001,20.00,50.00,5000.00,100.00", employee1.toCSV());
    }
}

