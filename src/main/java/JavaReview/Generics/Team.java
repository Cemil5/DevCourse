package JavaReview.Generics;

import java.util.ArrayList;

public class Team {

    private String name;

    private ArrayList<Player> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer (Player player){
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
