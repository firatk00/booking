package business.persistence;

import business.entities.Item;
import business.entities.ItemDTO;
import business.entities.Room;
import business.entities.User;
import business.entities.Booking;
import business.exceptions.UserException;
import java.time.LocalDate;
import java.sql.*;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class ItemMapper {
    private Database database;

    public ItemMapper(Database database)
    {
        this.database = database;
    }

    public List<ItemDTO> getAllItems() throws SQLException {
        List<ItemDTO> allItems = new ArrayList<>();
        try (Connection connection = database.connect())
        {
        //public Item(String udstyr, String id, String type, int roomId)
        //TODO: lav sql der joiner item og room, next step joine med booking så man kan se om itemet er available
        String sql = "SELECT i.room_id,i.id,b.booking_date,b.days,b.booking_status,i.item_name,i.description FROM booking AS b RIGHT JOIN item AS i ON b.item_id=i.id ORDER BY booking_date desc;";
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String id = rs.getString("id");
                Date bookingDate = rs.getDate("booking_date");
                LocalDate ld = bookingDate.toLocalDate();
                String days = rs.getString("days");
                Boolean bookingStatus = rs.getBoolean("booking_status");
                String udstyr = rs.getString("item_name");
                String type = rs.getString("description");
                int roomId = rs.getInt("room_id");

                ItemDTO itemDTO = new ItemDTO(bookingStatus, bookingDate, udstyr, days, id, type, roomId);
                allItems.add(itemDTO);
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException(ex.getMessage());
        }
    }
        catch (SQLException ex)
    {
        throw new SQLException("Connection to database could not be established");
    }

        return allItems;
    }

    public void createItem(Item item) throws UserException
    {
        try (Connection connection = database.connect())
        {
            //"Oculus Quest 2",	"vr-1",	"VR-headset",212
            String sql = "INSERT INTO item (id, item_name, description, room_id) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, item.getId());
                ps.setString(2, item.getUdstyr());
                ps.setString(3, item.getType());
                ps.setInt(4, item.getRoomId());
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }

    public List<ItemDTO> getAllBookedItems() throws SQLException {
        List<ItemDTO> allItems = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            //TO DO lav et nyt objekt som kan transportere den her data ud i frontenden (DTO), det vil sige lav en ny entitet.
            String sql = "SELECT i.id,b.booking_date,b.days,b.booking_status,i.item_name,i.description FROM booking AS b,item AS i\n" +
                    "WHERE b.item_id=i.id;";
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                //Lav getAllBookedItems så det matcher nedstående
                //# id, booking_date, days, booking_status, item_name, description
                //'vr-2', '2021-07-02', '10', '1', 'Oculus Quest 2', 'VR-headset'
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    String id = rs.getString("id");
                    Date bookingDate = rs.getDate("booking_date");
                    LocalDate ld = bookingDate.toLocalDate();
                    String days = rs.getString("days");
                    Boolean bookingStatus = rs.getBoolean("booking_status");
                    String udstyr = rs.getString("item_name");
                    String type = rs.getString("description");
                    int roomId = rs.getInt("room_id");

                    ItemDTO item = new ItemDTO(bookingStatus, bookingDate, udstyr, days, id, type, roomId);
                    allItems.add(item);
                }
            }
            catch (SQLException ex)
            {
                throw new SQLException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException("Connection to database could not be established");
        }
        return allItems;
    }
/*
    public User login(String email, String password) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "SELECT id, role FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    Room room = new Room(items, navn, id);
                    room.setId(id);
                    return room;
                } else
                {
                    throw new UserException("Could not validate Room");
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }
    }
*/
}

