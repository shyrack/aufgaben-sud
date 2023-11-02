package tests.mitarbeiter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mitarbeiter.BueroArbeiter;

public class BueroArbeiterTest {
    BueroArbeiter bmGood, bmBad;

    @BeforeEach
    void setUp() throws Exception {
        bmGood = new BueroArbeiter(5234, "Erna", 2000);
    }

    @Test
    void testCreateBueroArbeiter() {
        bmBad = new BueroArbeiter(1111, "Al", 3000);
        assertEquals(5111, bmBad.getID(), "ID 1111 was not adapted correctly");
        bmBad = new BueroArbeiter(0, "Al", 3000);
        assertEquals(5000, bmBad.getID(), "ID 0 was not adapted correctly");
    }

    @Test
    void testFestgehalt() {
        double gehalt = bmGood.getFestgehalt();
        assertEquals(2000, gehalt, "Festgehalt of 2000 expected. Got " + gehalt + " instead.");
    }

    @Test
    void testModifyTestgehalt() {
        bmGood.setFestgehalt(301);
        double gehalt = bmGood.getFestgehalt();
        assertEquals(301, gehalt, "Festgehalt of 301 expected. Got " + gehalt + " instead.");

        assertThrows(IllegalArgumentException.class, () -> bmGood.setFestgehalt(300));
    }

    @Test
    void testToSring() {
        assertEquals(
            bmGood.toString(),
            "\nID: 5234 Name: Erna hat Festgehalt: 2000.0",
            "Not expected string"
        );
    }

    @Test
    void testToCSVString() {
        assertEquals(
            bmGood.toCSVString(),
            "BUERO;5234;Erna;2000.0;",
            "Not expected"
        );
    }
}
