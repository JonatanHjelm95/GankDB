/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import DBAccess.PlayerMapper;

/**
 *
 * @author jonab
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Player player = new Player("swingerjon", "hunter", "orc", 12);
        PlayerMapper pm = new PlayerMapper();
        
        // TODO code application logic here
    }
    
}
