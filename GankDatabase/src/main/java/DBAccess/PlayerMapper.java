/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Function.DBException;
import Function.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jonab
 */
public class PlayerMapper {
    
     static void addPlayer(Player player) throws DBException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `gankDB`.`alliancePlayer` (`charName`, `race`, `class`, `level`) VALUES (?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, player.getName());
            ps.setString(2, player.getRace());
            ps.setString(3, player.getWowClass());
            ps.setInt(4, player.getLevel());
            ps.executeUpdate();
//            ResultSet ids = ps.getGeneratedKeys();
//            ids.next();
//            int id = ids.getInt(1);
//            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DBException(ex.getMessage());
        }
    }
    
}
