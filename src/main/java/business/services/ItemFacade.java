package business.services;

import business.entities.Item;
import business.persistence.Database;
import business.persistence.ItemMapper;
import business.exceptions.UserException;

public class ItemFacade
{
    ItemMapper itemMapper;

    public ItemFacade(Database database) { itemMapper = new ItemMapper(database); }
    //public Item(String udstyr, String id, String type, int roomId)
    public Item item(String udstyr, String id, String type, int roomId)
    {
        return itemMapper.item(udstyr, id, type, roomId);
    }

    public Item createItem(String udstyr, String id, String type, int roomId) throws UserException
    {
        Item item = new Item(udstyr, id, type, roomId);
        itemMapper.createItem(item);
        return item;
    }

}
