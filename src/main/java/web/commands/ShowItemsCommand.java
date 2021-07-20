package web.commands;

import business.services.ItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import business.exceptions.UserException;

public class ShowItemsCommand extends CommandProtectedPage {

    ItemFacade itemFacade;

    public ShowItemsCommand(String pageToShow, String role) {
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
