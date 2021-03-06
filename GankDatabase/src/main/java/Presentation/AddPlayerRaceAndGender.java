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
public class AddPlayerRaceAndGender extends Command {

    public AddPlayerRaceAndGender() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Player player = (Player) request.getSession(false).getAttribute("player");
        player.setRace(request.getParameter("Race"));
        player.setGender(request.getParameter("Gender"));
        request.setAttribute("playerClassList", HTMLGenerator.AddPlayerClass(player));
        return "playerClassPage";
    }

}
