package business.persistence;

import business.entities.Booking;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class BookingMapper {
    private Database database;

    public BookingMapper(Database database) {
        this.database = database;
    }

    public void createBooking(Booking booking) throws SQLException
    {
        //booking = new Booking(bookingDate, 10, "hej", true, user.getId(), booking.getItemId());
        try (Connection connection = database.connect())
        {
            //int id, LocalDate bookingDate, int days, String comment, Boolean bookingStatus, int userId, int itemId
            String sql = "INSERT INTO booking (booking_date, days, comment, booking_status, users_id, item_id) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setDate(1, Date.valueOf(booking.getBookingDate()));
                ps.setString(2, booking.getDays());
                ps.setString(3, booking.getComment());
                ps.setBoolean(4, booking.getBookingStatus());
                ps.setInt(5, booking.getUserId());
                ps.setString(6, booking.getItemId());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                booking.setId(id);
            }
            catch (SQLException ex)
            {
                throw new SQLException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException(ex.getMessage());
        }
    }
}
