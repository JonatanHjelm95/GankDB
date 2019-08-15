package Function;


import DBAccess.DBFacade;
import java.util.List;

public class LogicFacade {

    public static void addPlayer(Player player) throws DBException {
        DBFacade.addPlayer(player);
    }

//    public static User createUser(String email, String password, Role role) throws DBException {
//        return DBFacade.createUser(email, password, role);
//    }
}
