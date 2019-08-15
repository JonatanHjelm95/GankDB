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
public class NewPlayer extends Command {

    public NewPlayer() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.setAttribute("addPlayerRaceAndGender", HTMLGenerator.AddPlayerRaceAndGender());
        return "newPlayerPage";
    }

}
