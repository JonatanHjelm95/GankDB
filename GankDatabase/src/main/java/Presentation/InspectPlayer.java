/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.LogicFacade;
import Function.LoginSampleException;
import Function.Player;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonab
 */
public class InspectPlayer extends Command {

    public InspectPlayer() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String playerName = (String) request.getParameter("playerName");
        try {
            Player player = LogicFacade.getPlayerByName(playerName);
            request.setAttribute("playerPageContent", HTMLGenerator.generatePlayerPage(player));
            
            return "PlayerPage";
        } catch (SQLException ex) {
            Logger.getLogger(InspectPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InspectPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

}
