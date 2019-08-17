/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.Comparator;

/**
 *
 * @author jonab
 */
public class SorterLevelsReverse implements Comparator<Player> {

    @Override
    public int compare(Player t, Player t1) {
        return Integer.compare(t1.getLevel(), t.getLevel());
    }

//    @Override
//    public Comparator<Player> reversed() {
//        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
//    }
}
