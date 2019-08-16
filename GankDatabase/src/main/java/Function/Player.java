/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jonab
 */
public class Player implements Comparable<Player> {

    String name;
    String race;
    String gender;
    String wowClass;
    int level;
    String date;
    //Optionals
    String guild;
    List notes = new ArrayList<PlayerNote>();

    public Player() {

    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List getNotes() {
        return notes;
    }

    public void setNotes(List notes) {
        this.notes = notes;
    }
    
    //Compare Levels
    @Override
    public int compareTo(Player t) {
        return this.getLevel() - t.getLevel();
    }
    
    public int compareToName(Player t) {
        return this.name.compareTo(t.name);
    }
    
    public int compareToGuild(Player t) {
        return this.guild.compareTo(t.guild);
    }
    
    public int compareToGender(Player t) {
        return this.gender.compareTo(t.gender);
    }
    
    public int compareToCreated(Player t) {
        return this.date.compareTo(t.date);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.level != other.level) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.race, other.race)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.wowClass, other.wowClass)) {
            return false;
        }
        if (!Objects.equals(this.guild, other.guild)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.notes, other.notes)) {
            return false;
        }
        return true;
    }

}
