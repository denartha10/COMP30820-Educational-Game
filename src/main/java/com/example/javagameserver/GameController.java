package com.example.javagameserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private final Board gameBoard = new Board();
    // Handles the initial connection and sends the initial game state
    @MessageMapping("/initialise")
    @SendTo("/topic/board")
    public Board initialisePlayer() {
        // Initialize the game and send the initial board state
        Player newPlayer = new Player();
        gameBoard.addPlayer(newPlayer);
        return gameBoard;
    }

    // Handles move events
    @MessageMapping("/move")
    @SendTo("/topic/board")
    public Board handleMove(MoveMessage move) {
        // Process the move, update the board, and broadcast the updated board state
        return processMove(move);
    }

    private Board processMove(MoveMessage move) {

        return gameBoard;
    }
}
