package com.example.entitycomponentsystem.components;

public class TransformComponent {
    private int pos_x;
    private int pos_y;

    private String movement_direction;

    public TransformComponent(int posX, int posY, String movementDirection) {
        pos_x = posX;
        pos_y = posY;
        movement_direction = movementDirection;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public String getMovement_direction() {
        return movement_direction;
    }

    public void setMovement_direction(String movement_direction) {
        this.movement_direction = movement_direction;
    }
}
