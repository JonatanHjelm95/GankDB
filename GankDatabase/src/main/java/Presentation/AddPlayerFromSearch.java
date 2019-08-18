/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonab
 */
public class AddPlayerFromSearch extends Command {

    public AddPlayerFromSearch() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String name = (String) request.getSession(false).getAttribute("suggestName");
        request.setAttribute("addPlayerNameAndLevelFromSearch", HTMLGenerator.addPlayerNameAndLevelFromSearch(name));
        return "playerNameAndLevelPageFromSearchPage";
    }
    
}
