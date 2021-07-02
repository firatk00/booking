package business.persistence;

import business.entities.Booking;
import business.entities.Item;
import business.entities.Room;
import business.entities.User;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookingMapperTest {
    BookingMapper bookingMapper;
    Database database;
    Item item;
    User user;
    Room room;
    Booking booking;
    private final static String USER = "root";
    private final static String PASSWORD = "xohy2367?";
    private final static String URL = "jdbc:mysql://localhost:3306/booking?serverTimezone=CET";
//TODO: husk at lave en test database booking_test

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD, URL);
        bookingMapper = new BookingMapper(database);
        room = new Room("MediaLab",212);
        item = new Item("Oculus Quest 2",	"vr-2",	"VR-headset",212);
        //String email, String password, String role
        user = new User("barbie@world.dk","jensen","student");
        user.setId(1);
        booking = null;
    }

    @Test
    void createBooking() throws SQLException {
        //int id, LocalDate bookingDate, int days, String comment, Boolean bookingStatus, int userId, int itemId
        //finde item, room og user.
        LocalDate bookingDate = LocalDate.now();
        booking = new Booking(bookingDate, 10, "hej", true, user.getId(), item.getId());
        bookingMapper.createBooking(booking);


    }
}