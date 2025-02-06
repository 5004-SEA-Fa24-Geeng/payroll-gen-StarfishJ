package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    TimeCard timeCard;
    @BeforeEach
    void setUp() {
        timeCard = new TimeCard("P001", 50);
    }
    @Test
    void getEmployeeID() {
        assertEquals("P001", timeCard.getEmployeeID());
    }


    @Test
    void getHoursWorked() {
        assertEquals(50, timeCard.getHoursWorked());
    }
}