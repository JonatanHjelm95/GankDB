/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Function.DBException;
import Function.Player;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jonab
 */
public class DBFacade {
    public static void addPlayer(Player player) throws DBException {
        PlayerMapper.addPlayer(player);
    }
    
    public static void addPlayerNotes(Player player, String note) throws DBException{
        PlayerMapper.addPlayerNotes(player, note);
    }
    
    public static List getAllPlayers() throws DBException{
        return PlayerMapper.getAllPlayers();
    }
    
    public static Player getPlayerByName(String name) throws SQLException, ClassNotFoundException{
        return PlayerMapper.getPlayerByName(name);
    }
}
