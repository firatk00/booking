package business.entities;

public class Item {
    String udstyr;
    String id;
    String type;
    int roomId;

    public Item(String udstyr, String id, String type, int roomId) {
        this.udstyr = udstyr;
        this.id = id;
        this.type = type;
        this.roomId = roomId;
    }

    public String getUdstyr() {
        return udstyr;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getRoomId() {
        return roomId;
    }
}
