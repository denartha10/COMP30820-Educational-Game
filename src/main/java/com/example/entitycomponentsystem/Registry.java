package com.example.entitycomponentsystem;

import com.example.entitycomponentsystem.components.KeyInputComponent;
import com.example.entitycomponentsystem.components.SpriteComponent;
import com.example.entitycomponentsystem.components.TransformComponent;
import java.util.HashMap;

public class Registry {
    public HashMap<Integer, SpriteComponent> sprites = new HashMap<>();
    public HashMap<Integer, TransformComponent> transforms = new HashMap<>();
    public HashMap<Integer, KeyInputComponent> keysInputs = new HashMap<>();

}
