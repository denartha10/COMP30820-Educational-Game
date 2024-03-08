package com.example.entitycomponentsystem.systems;

import com.example.entitycomponentsystem.Registry;
import com.example.entitycomponentsystem.components.TransformComponent;

import java.awt.event.KeyEvent;
import java.util.Map;

public class MovementSystem {

    public void update(Registry reg) {

        boolean moveLeft = getKeyState(KeyEvent.VK_LEFT);
        boolean moveRight = getKeyState(KeyEvent.VK_RIGHT);
        boolean moveUp = getKeyState(KeyEvent.VK_UP);
        boolean moveDown = getKeyState(KeyEvent.VK_DOWN);

        for (Map.Entry<Integer, TransformComponent> entry : reg.transforms.entrySet()) {
            TransformComponent transform = entry.getValue();
            if (moveLeft) {
                transform.setMovement_direction("WEST");
            } else if (moveRight) {
                transform.setMovement_direction("EAST");
            } else if (moveUp) {
                transform.setMovement_direction("NORTH");
            } else if (moveDown) {
                transform.setMovement_direction("SOUTH");
            } else {
                transform.setMovement_direction("IDLE");
            }
        }
    }


    private boolean getKeyState(int KeyCode) {
        // TODO: Add in logic that calls for the message data or let the websocket control this
       return false;
    }
}
