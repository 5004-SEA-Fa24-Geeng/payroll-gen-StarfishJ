package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {
    PayStub payStub;
    @BeforeEach
    void setUp() {
        payStub = new PayStub("Eren Yeager",541.45,158.55,6541.45,1517.55);
    }
    @Test
    void getPay() {
        assertEquals(541.45, payStub.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(158.55, payStub.getTaxesPaid());
    }

    @Test
    void getYtdEarnings() {
        assertEquals(6541.45, payStub.getYtdEarnings());
    }

    @Test
    void getYtdTaxesPaid() {
        assertEquals(1517.55, payStub.getYtdTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("\"Eren Yeager\",541.45,158.55,6541.45,1517.55", payStub.toCSV());
    }
}