/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Function.DBException;
import Function.Player;
import Function.PlayerNote;
import Function.TimestampToDate;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonab
 */
public class PlayerMapper {

    static void addPlayer(Player player) throws DBException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `gankDB`.`alliancePlayer` (`charName`, `race`, `gender`, `class`, `level`, `guild`) VALUES (?,?,?,?,?,?);";

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, player.getName());
            ps.setString(2, player.getRace());
            ps.setString(3, player.getGender());
            ps.setString(4, player.getWowClass());
            ps.setInt(5, player.getLevel());
            ps.setString(6, player.getGuild());

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DBException(ex.getMessage());
        }
    }

    static void addPlayerNotes(Player player, String note) throws DBException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `gankDB`.`playerNotes` (`name`, `notes`) VALUES (?,?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, player.getName());
            ps.setString(2, note);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DBException(ex.getMessage());
        }
    }

    static List<PlayerNote> getPlayerNotes(Player player) throws SQLException, ClassNotFoundException {
        ArrayList<PlayerNote> notes = new ArrayList();
        Connection con = Connector.connection();
        String SQL = "SELECT * FROM gankDB.playerNotes where name = '?';";

        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setString(1, player.getName());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String note = rs.getString("notes");
            Timestamp createTimeTS = rs.getTimestamp("create_time");
            String createTime = (String) TimestampToDate.convert(createTimeTS);

            PlayerNote playerNote = new PlayerNote(note, createTime);
            notes.add(playerNote);
        }
        return notes;
    }

    static Player getPlayerByName(String name) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "SELECT * FROM gankDB.alliancePlayer where charName = '"+name+"';";

        PreparedStatement ps = con.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        Player player = new Player();
        while (rs.next()) {
            String charName = rs.getString("charName");
            String race = rs.getString("race");
            String gender = rs.getString("gender");
            String wowClass = rs.getString("class");
            Timestamp createTimeTS = rs.getTimestamp("create_time");
            String createTime = (String) TimestampToDate.convert(createTimeTS);
            int level = rs.getInt("level");
            String guild = rs.getString("guild");

            player = new Player(charName, race, gender, wowClass, level, guild);
            player.setDate(createTime);

        }
        return player;

    }

    static List<Player> getAllPlayers() throws DBException {
        try {
            ArrayList<Player> players = new ArrayList();
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM gankDB.alliancePlayer;";
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String charName = rs.getString("charName");
                String race = rs.getString("race");
                String gender = rs.getString("gender");
                String wowClass = rs.getString("class");
                Timestamp createTimeTS = rs.getTimestamp("create_time");
                String createTime = (String) TimestampToDate.convert(createTimeTS);
                int level = rs.getInt("level");
                String guild = rs.getString("guild");

                Player player = new Player(charName, race, gender, wowClass, level, guild);
                player.setDate(createTime);

                //player.setNotes(getPlayerNotes(player));
                players.add(player);
            }
            return players;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DBException(ex.getMessage());
        }
    }

}
