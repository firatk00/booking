package business.entities;

import java.time.LocalDate;

public class Booking {
    int id;
    LocalDate bookingDate;
    int days;
    String comment;
    Boolean bookingStatus;
    int userId;
    int itemId;

    public Booking(int id, LocalDate bookingDate, int days, String comment, Boolean bookingStatus, int userId, int itemId) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.days = days;
        this.comment = comment;
        this.bookingStatus = bookingStatus;
        this.userId = userId;
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public String getComment() {
        return comment;
    }

    public Boolean getBookingStatus() {
        return bookingStatus;
    }

    public int getUserId() {
        return userId;
    }

    public int getItemId() {
        return itemId;
    }

}
