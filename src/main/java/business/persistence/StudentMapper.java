package business.persistence;

import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    Database database;

    public StudentMapper(Database database) {
        this.database = database;
    }

    public List<User> getAllStudents() throws UserException {
        List<User> studentList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM users WHERE role='student'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    User user = new User(email, password, role);
                    user.setId(id);
                    studentList.add(user);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

        return studentList;
    }
}
