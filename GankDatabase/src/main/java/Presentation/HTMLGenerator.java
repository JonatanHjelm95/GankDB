/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Function.ClassList;
import Function.Player;
import java.util.List;

/**
 *
 * @author jonab
 */
public class HTMLGenerator {

    public static String AddPlayerRaceAndGender() {
        StringBuilder sb = new StringBuilder();
        sb.append("<form action=\"FrontController\" method=\"POST\">\n");
        sb.append(" <select name=\"Race\">\n");
        sb.append("  <option value=\"Dwarf\">Dwarf</option>\n");
        sb.append("  <option value=\"Human\" Selected>Human</option>\n");
        sb.append("  <option value=\"Gnome\">Gnome</option>\n");
        sb.append("  <option value=\"Night Elf\">Night Elf</option>\n");
        sb.append(" </select>");
        sb.append(" <select name=\"Gender\">\n");
        sb.append("  <option value=\"Female\">Female</option>\n");
        sb.append("  <option value=\"Male\" Selected>Male</option>\n");
        sb.append(" </select>");
        sb.append("  <input type=\"submit\" value=\"Next\">\n");
        sb.append("  <input type=\"hidden\" name=\"command\" value=\"addPlayerRaceAndGender\">\n");
        sb.append("</form>");
        return sb.toString();
    }

    public static String AddPlayerClass(Player player) {
        StringBuilder sb = new StringBuilder();
        ClassList cl = new ClassList();
        List list = cl.getClassList(player);
        sb.append("<form action=\"FrontController\" method=\"POST\">\n");
        sb.append("<h1> " + player.getGender() + " " + player.getRace());
        sb.append("</h1>");
        sb.append(" <select name=\"Class\">\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append("  <option value=\"").append(list.get(i)).append("\">").append(list.get(i)).append("</option>\n");
        }
        sb.append(" </select>");
        sb.append("  <input type=\"submit\" value=\"Next\">\n");
        sb.append("  <input type=\"hidden\" name=\"command\" value=\"addPlayerClass\">\n");
        sb.append("</form>");
        return sb.toString();
    }

    public static String addPlayerNameAndLevel(Player player) {
        StringBuilder sb = new StringBuilder();
        ClassList cl = new ClassList();
        List list = cl.getClassList(player);
        sb.append("<form action=\"FrontController\" method=\"POST\">\n");
        sb.append("<h1> " + player.getGender() + " " + player.getRace() + " " + player.getWowClass());
        sb.append("</h1>");
        sb.append(" <input type=\"text\" name=\"charName\" placeholder=\"character name\">\n");
        sb.append(" <input type=\"number\" name=\"level\" placeholder=\"character level\">\n");

        sb.append(" <h1>Guild</h1>\n");
        sb.append(" <input type=\"text\" name=\"guild\" placeholder=\"optional\">\n");
        sb.append(" <h1>Notes</h1>\n");

        sb.append(" <input type=\"text\" name=\"notes\" placeholder=\"optional\">\n");

        sb.append(" <input type=\"submit\" value=\"Add player\">\n");
        sb.append(" <input type=\"hidden\" name=\"command\" value=\"addPlayer\">\n");
        sb.append("</form>");
        return sb.toString();
    }

    public static String Navigation() {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"topnav\">\n");
        sb.append(" <div class=\"playersDropdown\">\n");
        sb.append(" <button class=\"playersDropdown-btn\">Players</button>");
        sb.append("     <div class=\"playersDropdown-content\">\n");
        sb.append("         <form action=\"FrontController\" method=\"POST\">\n");
        sb.append("             <input type=\"submit\" value=\"Add New Player\">\n");
        sb.append("             <input type=\"hidden\" name=\"command\" value=\"NewPlayer\">\n");
        sb.append("         </form>");
        sb.append("         <form action=\"FrontController\" method=\"POST\">\n");
        sb.append("              <input type=\"submit\" value=\"Show All Players\">\n");
        sb.append("              <input type=\"hidden\" name=\"command\" value=\"AllPlayers\">\n");
        sb.append("         </form>");
        sb.append("      </div>");
        sb.append(" </div>");
        sb.append("</div>");

        return sb.toString();
    }

    public static String allPlayersList(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"playersList\">\n");
        sb.append("<table class=players>\n");
        sb.append("<tr><th>Class</th>    <th>Lvl</th>   <th>Name</th>   <th>Gender</th>    <th>Race</th>    <th>Created</th></tr>");
        for (int i = 0; i < players.size(); i++) {
            sb.append("<tr><td>"+players.get(i).getWowClass()+"</td><td>"+players.get(i).getLevel()+"</td><td>"+players.get(i).getName()+"</td><td>"+players.get(i).getGender()+"</td><td>"+players.get(i).getRace()+"</td><td>"+players.get(i).getDate()+"</td></tr>");
        }
        sb.append("</table>\n");
        sb.append("</div>\n");

        return sb.toString();
    }
}
