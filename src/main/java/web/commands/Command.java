package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database)
    {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("studentpage", new CommandProtectedPage("studentpage", "student"));
        commands.put("adminpage", new CommandProtectedPage("employeepage", "admin"));
        commands.put("showstudents", new ShowStudentsCommand("showstudentpage", "admin"));
        //TODO: lav en knap i studentpage.jsp/customerpage hvor action parameteren peger på showitems
        //TODO: lav en showitems commando som bruger itemsmapperen som henter listen af alle items.
        //TODO: stemple listen ind i request parameteren
        //TODO: lav show items i jsp siden hvor listen hentes frem.
        commands.put("showitemsforstudent", new ShowItemsCommand("showitemspageforstudent", "student"));
        //TODO: LAV DET SAMME FOR ADMIN
        commands.put("showitems", new ShowItemsCommand("showitemspage", "admin"));
        //TODO: i showitemspageforstudent pagen skal jeg lave en radioknap ud fra hvert item så det kan bookes
        //TODO: showitems formen skal som action parameter så pege på bookitem commando
        //TODO: showitems formen skal forbedres og eventuelt en start dato
        commands.put("bookitem", new BookItemCommand("itembookedpage", "student"));
    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException, SQLException;

}
