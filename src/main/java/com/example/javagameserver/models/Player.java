package com.example.javagameserver.models;

import java.util.UUID;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private final UUID id;
    private final String color;
    private int x;
    private int y;
    private static final int defaultCO2Budget = 1000;
    private int CO2Budget;
    private int totalCO2;                           // For recording Total CO2 for entire game.
    private int totalDistance;                      // For recording Total Distance for entire game.
    private int score;
    private int streakCounter;
    private ArrayList<Integer> streakArray;        // Stores values of previous streaks if streak broken.
    private ArrayList<Gem> gemInventory;
    private int quizScore;                          // Not yet in use.

    public Player() {
        this.id = UUID.randomUUID();
        this.color = generateRandomColor();
        this.x = 0;
        this.y = 0;
        this.CO2Budget = defaultCO2Budget; // Arbitrary value as placeholder.
        this.score = 0;
        this.streakCounter = 0;
        this.totalCO2 = 0;
        this.totalDistance = 0;
        this.gemInventory = new ArrayList<>();
        this.streakArray = new ArrayList<>();
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

    public int getScore() {return this.score;}

    public void updateScore(int gemValue) {this.score += gemValue;}

    public void updateCO2Budget(RouteOption route) {this.CO2Budget -= route.getRouteCO2();}

    public void resetCO2Budget() {this.CO2Budget = defaultCO2Budget;}

    public void addGem(Gem gem) {gemInventory.add(gem);}

    public int getGemCount() {return gemInventory.size();}

    public int getTotalCO2() {return totalCO2;}

    public void updateTotalCO2(RouteOption route) {this.totalCO2 += route.getRouteCO2();}

    public int getTotalDistance() {return this.totalDistance;}

    public void updateTotalDistance(RouteOption route) {this.totalDistance += route.getRouteDistance();}

    public void streakHandler(RouteOption route) {
        if(route.getEco()){
            this.streakCounter += 1;
        }
        else {
            streakArray.add(this.streakCounter);
            this.streakCounter = 0;
        }
    }

    // Might use average CO2 per km travelled in total to give player a final eco rating?
    public int averageCO2PerKm() {return this.totalCO2/this.totalDistance;}

    public int getCurrentStreak() {return this.streakCounter;}

    public int getMaxStreak() {return Collections.max(this.streakArray);}


}
