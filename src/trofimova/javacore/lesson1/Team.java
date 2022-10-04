package trofimova.javacore.lesson1;

public class Team {
    private String nameTeam;
    private Player[] players;

    public Team(String nameTeam, Player[] players) {
        this.nameTeam = nameTeam;
        this.players = players;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public Player[] getPlayers() {
        return players;
    }

}