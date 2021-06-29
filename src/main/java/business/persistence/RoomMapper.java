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
            String sql = "INSERT INTO users (items, navn, id) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, room.getItems());
                ps.setString(2, room.getNavn());
                ps.setString(3, room.getId());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                room.getNavn();
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

}
