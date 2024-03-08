package com.example.javagameserver;

import com.example.entitycomponentsystem.Registry;
import com.example.entitycomponentsystem.systems.MovementSystem;
import com.example.entitycomponentsystem.systems.TransformSystem;

public class Game {
    private final Registry registry;
    private final TransformSystem transformSystem;
    private final MovementSystem movementSystem;
    private boolean running;

    public Game(){
        registry = new Registry();
        transformSystem = new TransformSystem();
        movementSystem = new MovementSystem();
        running = false;
    }

    public void update() {
        transformSystem.update(registry);
        movementSystem.update(registry);
    }

    // this tells the game loop if it's still running
    public boolean isRunning(){
        return this.running;
    }
}
