/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author jonab
 */
public class Player {
    
    String name;
    String race;
    String gender;
    String wowClass;

    
    int level;
    String guild;
   // String faction = "Alliance";

    public Player(String name, String race, String gender, String wowClass, int level) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.wowClass = wowClass;
        this.level = level;
    }

    public Player(String name, String race, String gender, String wowClass, int level, String guild) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.wowClass = wowClass;
        this.level = level;
        this.guild = guild;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWowClass() {
        return wowClass;
    }

    public void setWowClass(String wowClass) {
        this.wowClass = wowClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", race=" + race + ", gender=" + gender + ", wowClass=" + wowClass + ", level=" + level + ", guild=" + guild + '}';
    }
    
}
