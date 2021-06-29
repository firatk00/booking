package business.entities;

import java.util.List;

public class Room {
    List<Item> items;
    String navn;
    int id;

    public Room(List<Item> items, String navn, int id) {
        this.items = items;
        this.navn = navn;
        this.id = id;
    }

    public List<Item> getItems() {

        return items;
    }

    public String getNavn() {
        return navn;
    }

    public int getId() {
        return id;
    }
}
