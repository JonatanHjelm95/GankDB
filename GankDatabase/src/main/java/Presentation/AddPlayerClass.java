/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.LoginSampleException;
import Function.Player;
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
        Player player = (Player) request.getSession(true).getAttribute("Player");
        System.out.println(player.getGender());
        System.out.println(player.getRace());
        System.out.println(request.getParameter("Class"));
        if (!player.equals(null)) {
            player.setWowClass(request.getParameter("Class"));
            request.setAttribute("addPlayerNameAndLevel", HTMLGenerator.addPlayerNameAndLevel(player));
            return "playerNameAndLevelPage";
        }
        return "index.jsp";
    }

}
