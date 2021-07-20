package business.entities;

import java.time.LocalDate;

public class Booking {
    int id;
    LocalDate bookingDate;
    String days;
    String comment;
    Boolean bookingStatus;
    int userId;
    String itemId;

    public Booking(LocalDate bookingDate, String days, String comment, Boolean bookingStatus, int userId, String itemId) {
        this.bookingDate = bookingDate;
        this.days = days;
        this.comment = comment;
        this.bookingStatus = bookingStatus;
        this.userId = userId;
        this.itemId = itemId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getDays() {
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

    public String getItemId() {
        return itemId;
    }

}
