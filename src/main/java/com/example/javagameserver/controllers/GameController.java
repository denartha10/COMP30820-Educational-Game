package com.example.javagameserver;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller
public class GameController extends TextWebSocketHandler {

    private final Board gameBoard = new Board();
    // Handles the initial connection and sends the initial game state
    @MessageMapping("/initialise")
    @SendTo("/topic/board")
    public StateMessage initialisePlayer() {
        // Initialize the game and send the initial board state
        Player newPlayer = new Player();
        gameBoard.addPlayer(newPlayer);
        return new StateMessage(gameBoard, newPlayer.getId());
    }

    // Handles move events
    @MessageMapping("/move")
    @SendTo("/topic/board")
    public StateMessage handleMove(MoveMessage move) {
        // Process the move, update the board, and broadcast the updated board state
        return processMove(move);
    }

    private StateMessage processMove(MoveMessage move) {
        gameBoard.movePlayer(move.getPlayerID(), move.getDirection());
        return new StateMessage(gameBoard, move.getPlayerID());
    }




}
