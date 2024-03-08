package com.example.entitycomponentsystem;

// Entities represent an ID. Nothing more. Nothing less.... An ID
public class Entity {
    private final long id;
    private static long nextId = 0;

    public Entity() {
        this.id = nextId++;
    }

    public long getId() {
        return id;
    }
}
