package business.persistence;

import business.entities.Room;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomMapperTest {
    RoomMapper roomMapper;
    Database database;
    Room room;
    private final static String USER = "root";
    private final static String PASSWORD = "xohy2367?";
    private final static String URL = "jdbc:mysql://localhost:3306/booking?serverTimezone=CET";
//TODO: husk at lave en test database booking_test
    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD, URL);
        roomMapper = new RoomMapper(database);
        room = new Room("MakerLab", 210);
    }

    @Test
    void createRoom() throws UserException {
        roomMapper.createRoom(room);
    }
}