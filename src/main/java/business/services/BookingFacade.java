package business.services;



import business.entities.Booking;
import business.entities.Item;
import business.entities.ItemDTO;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.BookingMapper;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class BookingFacade {
    BookingMapper bookingMapper;
    private Database database;

    public BookingFacade(Database database) {

        this.bookingMapper = new BookingMapper(database);
    }
    public void createBooking(Booking booking) throws SQLException {
        bookingMapper.createBooking(booking);

    }
}
/*public boolean isItemBooked(String itemId) throws SQLException {
        boolean Null;
        //TODO: Slå itemId op i database eller liste
        return true;*/