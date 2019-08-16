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
        sb.append("  <option value=\"NightElf\">Night Elf</option>\n");
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
        sb.append(" <div class=\"navTiles\">\n");
        sb.append("     <ul>");
        sb.append("        <li>");
        sb.append("         <form action=\"FrontController\" method=\"POST\">\n");
        sb.append("             <input class=\"menuTiles\" id=\"Home\" type=\"submit\" value=\"Home\">\n");
        sb.append("             <input type=\"hidden\" name=\"command\" value=\"Home\">\n");
        sb.append("         </form>");
        sb.append("        </li>");
        sb.append("        <li class=\"listTiles\">");
        sb.append("         <form action=\"FrontController\" method=\"POST\">\n");
        sb.append("             <input class=\"menuTiles\" id=\"NewPlayerIcon\" type=\"submit\" value=\"Add New Player\">\n");
        sb.append("             <input type=\"hidden\" name=\"command\" value=\"NewPlayer\">\n");
        sb.append("         </form>");
        sb.append("        </li>");
        sb.append("        <li class=\"listTiles\">");
        sb.append("         <form action=\"FrontController\" method=\"POST\">\n");
        sb.append("              <input class=\"menuTiles\" id=\"ShowAllPlayers\" type=\"submit\" value=\"Show All Players\">\n");
        sb.append("              <input type=\"hidden\" name=\"command\" value=\"AllPlayers\">\n");
        sb.append("         </form>");
        sb.append("        </li>");
        sb.append("         <img id=\"mastHead\" src=\"icons/MastHead.png\">");
        sb.append("     </ul>");
        sb.append(" </div>");
        sb.append("</div>");

        return sb.toString();
    }


    public static String allPlayersList(List<Player> players) {
        String classIcon = "icons/Ui-charactercreate-classes_";
        String raceIcon = "icons/Ui-charactercreate-races_";
        String png = ".png";

        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"playersList\">\n");
        sb.append("<table class=players>\n");
        sb.append("<tr><th><form action\"FrontController\" method=\"POST\"><input type=\"hidden\" name=\"command\" value=\"SortLevel\"><input type=\"submit\" class=\"tableInput\" value=\"Level\"></form></th>"
                + "    <th><form action\"FrontController\" method=\"POST\"><input type=\"hidden\" name=\"command\" value=\"SortRace\"><input type=\"submit\" class=\"tableInput\" value=\"Race\"></form></th>"
                + "   <th><form action\"FrontController\" method=\"POST\"><input type=\"hidden\"  name=\"command\" value=\"SortClass\"><input type=\"submit\" class=\"tableInput\" value=\"Class\"></form></th>"
                + "   <th><form action\"FrontController\" method=\"POST\"><input type=\"hidden\"  name=\"command\" value=\"SortName\"><input type=\"submit\" class=\"tableInput\" value=\"Name\"></form></th>"
                + "    <th><form action\"FrontController\" method=\"POST\"><input type=\"hidden\" name=\"command\" value=\"SortGuild\"><input type=\"submit\" class=\"tableInput\" value=\"Guild\"></form></th>"
                + "    <th><form action\"FrontController\" method=\"POST\"><input type=\"hidden\" name=\"command\" value=\"SortCreated\"><input type=\"submit\" class=\"tableInput\" value=\"Created\"></form></th>"
                + "</tr>");
        for (int i = 0; i < players.size(); i++) {
            sb.append("<form action=\"FrontController\" method=\"POST\">\n");
            sb.append("<input type=\"hidden\" name=\"command\" value=\"Inspect\">\n");
            sb.append("<input type=\"hidden\" name=\"playerName\" value=\"").append(players.get(i).getName()).append("\">\n");
            classIcon = classIcon + players.get(i).getWowClass().toLowerCase() + png;
            raceIcon = raceIcon + players.get(i).getRace().toLowerCase() + "-" + players.get(i).getGender().toLowerCase() + png;
            sb.append("<tr><td class=\"levelField\">" + players.get(i).getLevel() + "</td><td><img src=\"" + raceIcon + "\"></td><td><img src=\"" + classIcon + "\"></td>    <td>" + players.get(i).getName() + "</td>   <td>" + players.get(i).getGuild() + "</td><td>" + players.get(i).getDate() + "</td><td><input class=\"inspect\" type=\"submit\" value=\"Inspect\"></form></td></tr>\n");
            classIcon = "icons/Ui-charactercreate-classes_";
            raceIcon = "icons/Ui-charactercreate-races_";
            png = ".png";
        }
        sb.append("</table>\n");
        sb.append("</div>\n");

        return sb.toString();
    }

    public static String generatePlayerPage(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div=\"playerDiv\">");
        sb.append("<h1>");
        sb.append(player.getName());
        sb.append("</h1>");
        sb.append("</div>");
        return sb.toString();
    }
}
