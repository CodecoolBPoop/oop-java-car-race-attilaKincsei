package com.codecool;

import java.util.concurrent.ThreadLocalRandom;

public class Motorcycle implements Vehicle {

    static final VehicleType vehicleType = VehicleType.MOTORCYCLE;

    MotorcycleModel model;

    final int topSpeed;

    // The number of the instance created. Used for its name.
    static int nameNumber = 0;

    // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).
    final int normalSpeed = 100;

    int currentSpeed;

    // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    final String name;

    // holds the current distance traveled.
    int distanceTraveled = 0;

    Motorcycle(MotorcycleModel model) {
        this.model = model;
        this.name = "Motorcycle " + String.valueOf(++nameNumber);
        this.topSpeed = model.getTopSpeed();
        currentSpeed = normalSpeed;
    }

    @Override
    public void moveForAnHour(Race race) {
        // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).
       if (!race.isRaining) {
           currentSpeed = normalSpeed;
           distanceTraveled += currentSpeed * 1;
        } else {
           currentSpeed = ThreadLocalRandom.current().nextInt(normalSpeed - 50, normalSpeed -5);
           distanceTraveled += currentSpeed * 1;
        }
    }

    @Override
    public int getNormalSpeed() {
        return normalSpeed;
    }

    @Override
    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    static int getNameNumber() {
        return nameNumber;
    }

    MotorcycleModel getModel() {
        return model;
    }

    int getCurrentSpeed() {
        return currentSpeed;
    }


}
