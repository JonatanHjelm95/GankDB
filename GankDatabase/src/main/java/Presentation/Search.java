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
public class Search extends Command {

    public Search() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String name = request.getParameter("searchValue");
        while (!name.isEmpty()) {
            try {
                Player player = LogicFacade.getPlayerByName(name);
                if (player.getName() != null) {
                    request.setAttribute("playerPageContent", HTMLGenerator.generatePlayerPage(player));
                    return "PlayerPage";
                }
                name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
                String msg = "<p>No player with the name: " + name + " exists in the database</p>";
                request.setAttribute("msg", msg);
                request.setAttribute("playerDontExistPrompt", HTMLGenerator.playerDontExistPrompt(name));
                request.getSession(false).setAttribute("suggestName", name);
                return "dontExistPage";

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);

            }
            return "dontExistPage";
        }
        String msg = "<p>Please enter a name</p>";
        request.setAttribute("msg", msg);
        return "searchPage";
    }

}
