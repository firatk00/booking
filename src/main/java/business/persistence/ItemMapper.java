package business.persistence;

import business.entities.Item;
import business.entities.Room;
import business.entities.User;
import business.exceptions.UserException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMapper {
    private Database database;

    public ItemMapper(Database database)
    {
        this.database = database;
    }

    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>();
        //TODO: lav sql der joiner item og room, next step joine med booking så man kan se om itemet er available
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

