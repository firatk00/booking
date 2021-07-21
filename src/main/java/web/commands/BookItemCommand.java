package web.commands;

import business.exceptions.UserException;
import business.services.ItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BookItemCommand extends CommandProtectedPage {

    ItemFacade itemFacade;

    public BookItemCommand(String pageToShow, String role) {
        super(pageToShow, role);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserException {
        request.setAttribute("itemsList", itemFacade.getAllItems());
        request.setAttribute("itemsListWithDates", itemFacade.getAllItemsWithDates());
        return pageToShow;
    }
}
