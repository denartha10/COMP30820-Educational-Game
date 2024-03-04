package com.example.javagameserver;

public class MoveMessage {
    private String direction;

    // Constructors, getters, and setters
    public MoveMessage(String playerId, String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

