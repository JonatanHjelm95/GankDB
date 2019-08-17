/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.DBException;
import Function.LogicFacade;
import Function.LoginSampleException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonab
 */
public class SearchPlayer extends Command {

    public SearchPlayer() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            List players = LogicFacade.getAllPlayers();
            request.setAttribute("DatalistScript", HTMLGenerator.generateScriptForDatalist(players));
            request.setAttribute("Datalist", HTMLGenerator.generateDatalist(players));
            return "searchPage";
        } catch (DBException ex) {
            Logger.getLogger(SearchPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

}
