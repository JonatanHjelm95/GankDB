/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author jonab
 */
public class SortList {

    public void sortByNameAsc(ArrayList<Player> players) {
       // Collections.sort(players, Comparator.comparing(Player::getGuild));
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).name + " level " + players.get(i).getLevel());
        }
        System.out.println("_____");
       Collections.sort(players);
       for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).name+ " level " + players.get(i).getLevel());
        }
       
       Collections.sort(players, new SorterNames());
       //return players;
    }
    
//    public void sortByLevel(ArrayList<Player> players){
//        Collections.sort(players, Comparator.comparing(Player::getLevel));
//    }

}
