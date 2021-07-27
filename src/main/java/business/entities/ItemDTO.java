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

    public Date getBookingDate() {
        return bookingDate;
    }

    public String getUdstyr() {
        return udstyr;
    }

    public String getDays() {
        return days;
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
