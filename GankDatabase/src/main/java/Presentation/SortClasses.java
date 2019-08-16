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
import Function.SorterClasses;
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
public class SortClasses extends Command {

    public SortClasses() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
     
        try {
            List<Player> players = LogicFacade.getAllPlayers();
            Collections.sort(players, new SorterClasses());
            request.setAttribute("playersList", HTMLGenerator.allPlayersList(players));
            return "allPlayersPage";

        } catch (DBException ex) {
            Logger.getLogger(AllPlayers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "allPlayersPage";
    }
    
}