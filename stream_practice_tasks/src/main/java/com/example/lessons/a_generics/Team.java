package com.example.lessons.a_generics;

import java.util.ArrayList;

public class Team<T extends Player> {

    private final String name;

    private final ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer (T player){
        if (members.contains(player)){
            System.out.println(player.getName());
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team" + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return members.size();
    }

}
