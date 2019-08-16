/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonab
 */
public class ClassList {

    public List getClassList(Player player) {
        String playerRace = player.getRace();
        
        List dwarfList = new ArrayList();
        dwarfList.add("Warrior");
        dwarfList.add("Hunter");
        dwarfList.add("Rogue");
        dwarfList.add("Priest");

        List humanList = new ArrayList();
        humanList.add("Warrior");
        humanList.add("Paladin");
        humanList.add("Rogue");
        humanList.add("Priest");
        humanList.add("Mage");
        humanList.add("Warlock");

        List gnomeList = new ArrayList();
        gnomeList.add("Warrior");
        gnomeList.add("Rogue");
        gnomeList.add("Mage");
        gnomeList.add("Warlock");

        List nelfList = new ArrayList();
        nelfList.add("Warrior");
        nelfList.add("Hunter");
        nelfList.add("Rogue");
        nelfList.add("Priest");
        nelfList.add("Druid");

        if (playerRace.equals("Dwarf")) {
            return dwarfList;
        }
        if (playerRace.equals("Human")) {
            return humanList;
        }
        if (playerRace.equals("Gnome")) {

            return gnomeList;
        }
        if (playerRace.equals("Night-Elf")) {

            return nelfList;
        }
        return nelfList;
    }
}
