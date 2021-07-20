package business.entities;

import java.util.Date;

public class ItemDTO {
    Boolean bookingStatus;
    Date bookingDate;
    String udstyr;
    String days;
    String id;
    String type;

    public ItemDTO(Boolean bookingStatus, Date bookingDate, String udstyr, String days, String id, String type) {
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
