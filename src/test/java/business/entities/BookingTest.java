package business.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking booking;

    @BeforeEach
    void setUp() {
        booking = new Booking(LocalDate.now(), 5, "Hej", true, 1, "2");
    }

    @Test
    void getId() {
        int id = booking.getId();
    }
}