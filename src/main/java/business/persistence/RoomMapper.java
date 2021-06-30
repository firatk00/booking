package business.persistence;

import business.entities.Room;
import business.entities.User;
import business.exceptions.UserException;
import java.sql.*;

public class RoomMapper {
    private Database database;

    public RoomMapper(Database database)
    {
        this.database = database;
    }

    public void createRoom(Room room) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO room (description, room_number) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, room.getNavn());
                ps.setInt(2, room.getId());
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
