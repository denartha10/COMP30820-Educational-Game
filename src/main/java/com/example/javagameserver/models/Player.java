package com.example.javagameserver;

import java.util.UUID;
import java.util.Random;

public class Player {
    private final UUID id;
    private final String color;
    private int x;
    private int y;

    public Player() {
        this.id = UUID.randomUUID();
        this.color = generateRandomColor();
        this.x = 0;
        this.y = 0;
    }

    private String generateRandomColor() {
        Random random = new Random();
        int randomInt = random.nextInt(0x1000000); // Generates a random integer in the range 0 to 0xFFFFFF
        return String.format("0x%06X", randomInt); // Formats the integer as a hex string with leading zeros
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

    public String getColor() {
        return color;
    }
}
