package com.example.javagameserver.models;

import java.util.UUID;

public class MoveMessage {
    private String direction;
    // A final variable seems to be a constant that once it is initialized inside a classes constructor it can not be changed?
    // Test this assumption later
    private final UUID playerID;

    // Constructors, getters, and setters
    public MoveMessage(UUID playerId, String direction) {
        this.direction = direction;
        this.playerID = playerId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public UUID getPlayerID() {
        return playerID;
    }
}

