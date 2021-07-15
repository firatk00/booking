package business.persistence;

import business.entities.Item;
import business.entities.ItemDTO;
import business.entities.Room;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.awt.geom.Crossings;

import javax.validation.constraints.AssertTrue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemMapperTest {
    ItemMapper itemMapper;
    Database database;
    Item item, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, item16, item17, item18, item19, item20, item21, item22;
    private final static String USER = "root";
    private final static String PASSWORD = "xohy2367?";
    private final static String URL = "jdbc:mysql://localhost:3306/booking?serverTimezone=CET";

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        database = new Database(USER, PASSWORD, URL);
        itemMapper = new ItemMapper(database);
        //String udstyr, String id, String type, int roomId
        item = new Item("Oculus Quest 2",	"vr-2",	"VR-headset",212);
        //Oculus Quest 2;vr-1;VR-headset;212;Medialab
        item1 = new Item("Oculus Quest 2", "vr-2", "VR-headset", 212);
        item2 = new Item("Oculus Quest 2", "vr-3", "VR-headset", 212);
        item3 = new Item("Oculus Quest 2", "vr-4", "VR-headset", 212);
        item4 = new Item("Oculus Quest 2", "vr-5", "VR-headset", 212);
        item5 = new Item("Oculus Quest 2", "vr-6", "VR-headset", 212);
        item6 = new Item("Oculus Rift S","vr-7", "VR-headset",212);
        item7 = new Item("Oculus Rift S","vr-8", "VR-headset", 212);
        item8 = new Item("Arbejdsstation PC","pc-1", "Arbejdscomputer", 212);
        item9 = new Item("HP","print-1", "Plakatprinter", 212);
        item10 = new Item("Creatlity CR-10 S5","3d-print-1", "3D printer", 210);
        item11 = new Item("Creatlity CR-10 S5","3d-print-2", "3D printer", 210);
        item12 = new Item("Creatlity CR-10 S5","3d-print-3", "3D printer", 210);
        item13 = new Item("Creatlity CR-10 S5","3d-print-4", "3D printer", 210);
        item14 = new Item("Creatlity CR-10 S5","3d-print-5", "3D printer", 210);
        item15 = new Item("Creatlity CR-10 S5","3d-print-6", "3D printer", 210);
        item16 = new Item("Creatlity CR-10 S5","3d-print-7","3D printer", 210);
        item17 = new Item("Creatlity CR-10 S5", "3d-print-8", "3D printer", 210);
        item18 = new Item("Canon EOS 90D", "camera-1", "Digitalkamera", 212);
        item19 = new Item("Canon EOS 90D", "camera-2", "Digitalkamera", 212);
        item20 = new Item("Canon EOS 90D", "camera-3", "Digitalkamera", 212);
        item21 = new Item("Panasonic 4K", "camera-4", "Digitalkamera", 212);
        item22 = new Item("Fotostudio", "studio-1", "Fotostudio", 212);
    }
    @Test
    void testGetAllItems() throws SQLException {
        List<Item> allItems = itemMapper.getAllItems();
        int expected = 23;
        int actual = allItems.size();
        assertEquals(expected, actual);
    }

    @Test
    void getAllBookedItems() throws SQLException {
        List<ItemDTO> allbookeditems = itemMapper.getAllBookedItems();
        Boolean ifBooked = true;
        if (ifBooked = true) {
            System.out.println("This item is booked");
        }
        else if (ifBooked = false) {
            System.out.println("Not booked");

        }


    }

/*    @Test
    void createItem() throws UserException {
        //itemMapper.createItem(item);
        //itemMapper.createItem(item1);
        itemMapper.createItem(item2);
        itemMapper.createItem(item3);
        itemMapper.createItem(item4);
        itemMapper.createItem(item5);
        itemMapper.createItem(item6);
        itemMapper.createItem(item7);
        itemMapper.createItem(item8);
        itemMapper.createItem(item9);
        itemMapper.createItem(item10);
        itemMapper.createItem(item11);
        itemMapper.createItem(item12);
        itemMapper.createItem(item13);
        itemMapper.createItem(item14);
        itemMapper.createItem(item15);
        itemMapper.createItem(item16);
        itemMapper.createItem(item17);
        itemMapper.createItem(item18);
        itemMapper.createItem(item19);
        itemMapper.createItem(item20);
        itemMapper.createItem(item21);
        itemMapper.createItem(item22);
    } */
}