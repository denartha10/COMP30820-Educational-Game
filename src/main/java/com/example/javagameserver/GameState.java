package com.example.javagameserver;
import java.util.List;

public class GameState {
    private List<Player> players;

    public GameState(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}

