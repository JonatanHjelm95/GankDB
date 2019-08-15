/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Function.DBException;
import Function.Player;

/**
 *
 * @author jonab
 */
public class DBFacade {
    public static void addPlayer(Player player) throws DBException {
        PlayerMapper.addPlayer(player);
    }
}
