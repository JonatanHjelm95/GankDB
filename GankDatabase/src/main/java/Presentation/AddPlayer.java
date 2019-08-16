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
public class AddPlayer extends Command {

    public AddPlayer() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Player player = (Player) request.getSession(false).getAttribute("Player");
        String charName = request.getParameter("charName");
        int level = Integer.parseInt(request.getParameter("level"));
        if (charName.length() > 1 && charName.length() < 13 && level > 0 && level < 61) {
            charName = charName.substring(0, 1).toUpperCase() + charName.substring(1, charName.length()).toLowerCase();
            player.setLevel(level);
            player.setName(charName);
            String guild = request.getParameter("guild");

            if (guild.isEmpty()) {
                player.setGuild("N/A");
            } else {
                player.setGuild(request.getParameter("guild"));
            }
            try {
                LogicFacade.addPlayer(player);
            } catch (DBException ex) {
                Logger.getLogger(AddPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!request.getParameter("notes").isEmpty()) {
                String note = request.getParameter("notes");
                try {
                    LogicFacade.addPlayerNotes(player, note);
                } catch (DBException ex) {
                    Logger.getLogger(AddPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return "index";
        }
        return "index";
    }

}
