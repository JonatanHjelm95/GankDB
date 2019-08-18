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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonab
 */
public class AddPlayerClass extends Command {

    public AddPlayerClass() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Player player = (Player) request.getSession(false).getAttribute("player");
        player.setWowClass(request.getParameter("Class"));
        try {
            LogicFacade.addPlayer(player);
            return "index";
        } catch (DBException ex) {
            Logger.getLogger(AddPlayerClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

}
