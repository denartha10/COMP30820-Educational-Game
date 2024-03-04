package com.example.javagameserver;

import java.util.UUID;

public class Player {
    private final UUID id;
    private int x;
    private int y;

    public Player() {
        this.id = UUID.randomUUID();
        this.x = 0;
        this.y = 0;
    }

    public UUID getId() {
        return id;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void movePlayer(String direction) {
        switch (direction) {
            case "UP":
                y--;
                break;
            case "DOWN":
                y++;
                break;
            case "LEFT":
                x--;
                break;
            case "RIGHT":
                x++;
                break;
        }
    }
}
