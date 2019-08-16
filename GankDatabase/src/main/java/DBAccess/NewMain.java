/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Function.DBException;
import Function.Player;
import Function.SortList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonab
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DBException {
        // TODO code application logic here
//        try {
//            Player player = new Player("bøssesvin", "night elf", "male", "hunter", 40);
//            PlayerMapper.addPlayer(player);
//        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage());
//        }
        
        ArrayList<Player> players = (ArrayList<Player>) PlayerMapper.getAllPlayers();
        SortList sl = new SortList();
        sl.sortByNameAsc(players);
        
    }
    
}
