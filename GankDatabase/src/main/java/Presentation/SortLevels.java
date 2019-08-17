/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.DBException;
import Function.LogicFacade;
import Function.LoginSampleException;
import Function.Player;
import Function.SorterGuilds;
import Function.SorterLevelsReverse;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonab
 */
public class SortLevels extends Command {

    public SortLevels() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            boolean reverse = (boolean) request.getSession(false).getAttribute("reverse");
            List<Player> players = LogicFacade.getAllPlayers();
            if (!reverse) {
                Collections.sort(players);
                reverse = true;
                request.getSession(false).setAttribute("reverse", reverse);
            } else {
                Collections.sort(players, new SorterLevelsReverse());
                reverse = false;
                request.getSession(false).setAttribute("reverse", reverse);

            }
            request.setAttribute("playersList", HTMLGenerator.allPlayersList(players));
            return "allPlayersPage";

        } catch (DBException ex) {
            Logger.getLogger(AllPlayers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "allPlayersPage";
    }

}
