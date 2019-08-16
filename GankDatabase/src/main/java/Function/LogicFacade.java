package Function;


import DBAccess.DBFacade;
import DBAccess.PlayerMapper;
import java.sql.SQLException;
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
    
    public static Player getPlayerByName(String name) throws SQLException, ClassNotFoundException{
        return DBFacade.getPlayerByName(name);
    }
}
