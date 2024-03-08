package com.example.entitycomponentsystem.systems;

import com.example.entitycomponentsystem.Registry;
import com.example.entitycomponentsystem.components.TransformComponent;

import java.util.Map;

public class TransformSystem {
    public void update(Registry reg){
        for(Map.Entry<Integer, TransformComponent> entry: reg.transforms.entrySet()){
            TransformComponent transform = entry.getValue();

            // Update position based on current and direction
            switch (transform.getMovement_direction()){
                case "NORTH":
                    transform.setPos_y(transform.getPos_y() + 1);
                    break;
                case "SOUTH":
                    transform.setPos_y(transform.getPos_y() - 1);
                    break;
                case "EAST" :
                    transform.setPos_x(transform.getPos_x() + 1);
                    break;
                case "WEST" :
                    transform.setPos_x(transform.getPos_x() - 1);
                    break;
                default:
                    break;
            }
        }
    }
}
