package business.entities;

import java.util.Date;

public class ItemDTO {
    Boolean bookingStatus;
    Date bookingDate;
    String udstyr;
    String days;
    String id;
    String type;
    int roomId;

    public ItemDTO(Boolean bookingStatus, Date bookingDate, String udstyr, String days, String id, String type, int roomId) {
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
        this.udstyr = udstyr;
        this.days = days;
        this.id = id;
        this.type = type;
    }

    public Boolean getBookingStatus() {
        return bookingStatus;
    }
}
