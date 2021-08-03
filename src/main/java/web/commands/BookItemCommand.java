package web.commands;

import business.entities.Booking;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.BookingMapper;
import business.services.BookingFacade;
import business.services.ItemFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookItemCommand extends CommandProtectedPage {

    ItemFacade itemFacade;
    UserFacade userFacade;
    BookingFacade bookingFacade;

    public BookItemCommand(String pageToShow, String role) {
        super(pageToShow, role);
        itemFacade = new ItemFacade(database);
        userFacade = new UserFacade(database);
        bookingFacade = new BookingFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserException {
        //request.setAttribute("itemsList", itemFacade.getAllItems());
        //request.setAttribute("itemsListWithDates", itemFacade.getAllItemsWithDates());
        String itemId = request.getParameter("bookitem");
        int bookitemdays = Integer.parseInt(request.getParameter("bookitemdays"));
        if (itemFacade.isItemBookable(itemId)) {
            boolean item = itemFacade.isItemBookable(itemId);
            HttpSession session = request.getSession();
            int userid = (int) session.getAttribute("userid");
            int points = userFacade.getUserPoints(userid);
            if (points < bookitemdays) {
                System.out.println("Booked");
                //TODO: Brug userException eller lav en ny.
            } else {
                Booking booking = null;
                LocalDate bookingDate = LocalDate.now();
                booking = new Booking(bookingDate, bookitemdays, "hej", true, userid, itemId);
                bookingFacade.createBooking(booking);
                //booking = new Booking(bookingDate, "10", "hej", true, 2, "");
                //booking = new Booking(LocalDate.bookingDate, "10", "hej", true, user.getId(), item.getId());
            }
            session.setAttribute("bookitem", itemId);

            //return itemId;
            //TODO: hvis bookable så lad bookingFacade booke
            //TODO: itemFacade.createBooking(bookingDate, days, comment, bookingStatus, userId, itemId);
            //TODO: skal kunne opdaterer students points sammetidig
            //add.
        }
        //String email = request.getParameter("email");
        return pageToShow;
    }
}
