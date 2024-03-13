package com.example.javagameserver.models;

import java.util.UUID;

public class Gem {

    // Class variable tracking number of gems spawned.
    private static int spawnedGems = 0;

    // Class variable tracking number of gems collected.

    private static int collectedGems = 0;
    private final UUID gemId;
    private int x;
    private int y;
    private final int value;
    private final int gemColour;
    private boolean collectStatus;
    // Array of gem types with Gem Value:RGB colour values in hexadecimal.
    private static final int[][] gemValues = {
            {1, 0x00CC00},      // Green
            {5,  0x0000CC},     // Blue
            {10,  0xFFFF00},    // Yellow
            {20,  0xFF3333},    // Red
            {50,  0x990099},    // Purple
            {100,  0xFF9933},   // Orange
            {200,  0xA0A0A0},   // Grey
    };
    private static final int gemCollectRangeX = 5;
    private static final int gemCollectRangeY = 5;
    public Gem(int gem_index, int x, int y ){

        this.gemId = UUID.randomUUID();
        this.x = x;
        this.y = y;
        this.value = gemValues[gem_index][0];
        this.gemColour = gemValues[gem_index][1];
        this.collectStatus = false;
        spawnedGems ++;
    }

    public int getX() {return this.x;}

    public int getY() {return this.y;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public int getValue() {return this.value;}

    public int getColour() {return this.gemColour;}

    public UUID getGemId() {return this.gemId;}

    public int getSpawnedGems() {return Gem.spawnedGems;}

    public int getCollectedGems() {return Gem.collectedGems;}

    public boolean getGemStatus() {return this.collectStatus;}

    public void collectGem(Player player){
        if((Math.abs((player.getX() - this.getX())) <= gemCollectRangeX)
                && (Math.abs((player.getY() - this.getY())) <= gemCollectRangeY)) {
            Gem.collectedGems++;
            this.collectStatus = true;
            player.updateScore(this.value);
            player.addGem(this);
        }
    }
}
