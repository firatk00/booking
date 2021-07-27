package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.ItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class BookItemCommand extends CommandProtectedPage {

    ItemFacade itemFacade;

    public BookItemCommand(String pageToShow, String role) {
        super(pageToShow, role);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserException {
        //request.setAttribute("itemsList", itemFacade.getAllItems());
        //request.setAttribute("itemsListWithDates", itemFacade.getAllItemsWithDates());
        String itemId = request.getParameter("bookitem");
        if ( itemFacade.isItemBookable(itemId) )
    {
        boolean item = itemFacade.isItemBookable(itemId);
        HttpSession session = request.getSession();

        session.setAttribute("bookitem", itemId);
        return itemId;
        //TODO: hvis bookable så lad bookingFacade booke
        //TODO: itemFacade.createBooking(bookingDate, days, comment, bookingStatus, userId, itemId);
        //TODO: skal kunne opdaterer students points sammetidig
        //add.
    }
        //String email = request.getParameter("email");
        return pageToShow;
    }
}
