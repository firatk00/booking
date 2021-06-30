package business.persistence;

import business.entities.Item;
import business.entities.Room;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemMapperTest {
    ItemMapper itemMapper;
    Database database;
    Item item;
    private final static String USER = "root";
    private final static String PASSWORD = "xohy2367?";
    private final static String URL = "jdbc:mysql://localhost:3306/booking?serverTimezone=CET";

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD, URL);
        itemMapper = new ItemMapper(database);
        //String udstyr, String id, String type, int roomId
        item = new Item("Oculus Quest 2",	"vr-2",	"VR-headset",212);
    }

    @Test
    void createItem() throws UserException {
        itemMapper.createItem(item);
    }
}