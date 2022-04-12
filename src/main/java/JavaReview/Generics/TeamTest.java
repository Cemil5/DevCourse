package JavaReview.Generics;

public class TeamTest {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer backham = new SoccerPlayer("Backham");

        Team liverpool = new Team("Liverpool");
        liverpool.addPlayer(joe);
        liverpool.addPlayer(pat);
        liverpool.addPlayer(backham);

        System.out.println(liverpool.numPlayers());
    }
}
