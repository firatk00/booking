package business.services;


import business.entities.Item;
import business.entities.ItemDTO;
import business.entities.User;
import business.persistence.Database;
import business.persistence.ItemMapper;


import java.sql.SQLException;
import java.util.List;

public class ItemFacade {
    ItemMapper itemMapper;

    public ItemFacade(Database database) {
        this.itemMapper = new ItemMapper(database);
    }

    public List<ItemDTO> getAllItems() throws SQLException {

        return itemMapper.getAllItems();
    }

    public List<ItemDTO> getAllItemsWithDates() throws SQLException {

        return itemMapper.getAllBookedItems();
    }
    public boolean isItemBookable(String itemId) throws SQLException {

        //TODO: Slå itemId op i database eller liste
        return true;
    }
}
