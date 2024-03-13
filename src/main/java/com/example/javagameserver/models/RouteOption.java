package com.example.javagameserver.models;

// Note that at the moment this class doesn't calculate route distance and relies on a value being provided.
// Can incorporate a route calculation method in here later or calculated it using another RouteCalculation class.
// All calculations are performed with integer values. Update if needed.
// Will need to be added to include possibly an array of coordinates for plotting a route on the front end and
// functions for communicating that data to the front end for display.

public class RouteOption {

    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final String selectedMode;
    private final int speed;
    private final int CO2Factor;
    private final int routeDistance;
    private final int routeTime;
    private final int routeCO2;
    private static final String[][] transportationModes = {

        // {"Transportation Mode", "CO2 (g/passenger-km)", "Speed (km/hr)"}
        // Passenger numbers not included as CO2 values are already on a per-passenger basis.
        // Values adapted from: https://ourworldindata.org/travel-carbon-footprint

            {"bicycle", "0", "15"},
            {"tram", "30", "29", "1"},
            {"subway", "50", "28", "1"},
            {"fossil fuel bus", "30", "79"},
            {"electric bus", "30", "40"},
            {"fossil fuel taxi", "35", "170"},
            {"hybrid taxi", "35", "68"},
            {"electric taxi", "35", "47"}
    };
        // startX and startY are the coordinates of the player.
        // endX and endY are the coordinates of the player.
    public RouteOption(int startX, int startY, int endX, int endY, int modeIndex, int routeDistance){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.selectedMode = transportationModes[modeIndex][0];
        this.speed = Integer.parseInt(transportationModes[modeIndex][1]);
        this.CO2Factor = Integer.parseInt(transportationModes[modeIndex][2]);
        this.routeDistance = routeDistance;
        this.routeTime = calculateTime();
        this.routeCO2 = calculateCO2();
    }


    public int getStartX() {return this.startX;}
    public int getStartY() {return this.startY;}
    public int getEndX() {return this.endX;}
    public int getEndY() {return this.endY;}
    public String getSelectedMode() {return this.selectedMode;}
    public int getSpeed() {return this.speed;}
    public int getCO2Factor() {return this.CO2Factor;}
    public int getRouteDistance() {return this.routeDistance;}
    public int getRouteTime() {return this.routeTime;}
    public int getRouteCO2() {return this.routeCO2;}
    public int calculateTime() {return this.routeDistance / this.speed;}
    public int calculateCO2() {return this.CO2Factor * this.routeDistance;}

}
