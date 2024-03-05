package com.example.javagameserver.models;

import java.util.UUID;

public class StateMessage {
    private Board board;
    private UUID playerID;

    public StateMessage(Board board, UUID playerId) {
        this.board = board;
        this.playerID = playerId;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public UUID getPlayerID() {
        return playerID;
    }

    public void setPlayerID(UUID playerID) {
        this.playerID = playerID;
    }
}