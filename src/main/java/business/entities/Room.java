package business.entities;

import java.util.ArrayList;
import java.util.List;

public class Room {
    List<Item> items;
    String navn;
    int id;

    public Room(String navn, int id) {
        this.items = new ArrayList<>();
        this.navn = navn;
        this.id = id;
    }

    public void addItem() {

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
