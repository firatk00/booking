package business.entities;

import java.util.Date;

public class ItemDTO {
    Boolean bookingStatus;
    Date bookingDate;
    String udstyr;
    String id;
    String type;
    int roomId;

    public ItemDTO(String bookingStatus, Date bookingDate, String udstyr, Boolean id, String type, String roomId) {
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
        this.udstyr = udstyr;
        this.id = id;
        this.type = type;
        this.roomId = roomId;
    }

    public Boolean getBookingStatus() {
        return bookingStatus;
    }
}
