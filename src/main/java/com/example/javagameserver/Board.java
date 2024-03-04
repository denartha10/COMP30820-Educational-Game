package com.example.javagameserver;

import java.util.HashMap;
import java.util.UUID;

public class Board {
    private final HashMap<UUID, Player> players;

    public Board() {
        players = new HashMap<>();
    }

    public int getWidth() {
        return 40;
    }

    public int getHeight() {
        return 40;
    }

    public void addPlayer(Player player) {
        players.put(player.getId(), player);
    }

    public Player getPlayerById(UUID id) {
        return players.get(id);
    }

    public void updatePlayerLocation(UUID id, int x, int y) {
        Player player = players.get(id);
        if (player != null) {
            player.setLocation(x, y);
        }
    }

    public HashMap<UUID, Player> getPlayers() {
        return players;
    }
}