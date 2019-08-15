package Function;


import DBAccess.DBFacade;
import java.util.List;

public class LogicFacade {

    public static void addPlayer(Player player) throws DBException {
        DBFacade.addPlayer(player);
    }
    
    public static void addPlayerNotes(Player player, String note) throws DBException{
        DBFacade.addPlayerNotes(player, note);
    }
    
    public static List getAllPlayers() throws DBException{
        return DBFacade.getAllPlayers();
    }
}
