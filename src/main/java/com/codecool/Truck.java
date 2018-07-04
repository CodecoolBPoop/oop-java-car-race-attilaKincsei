package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Truck implements Vehicle {

    static final VehicleType vehicleType = VehicleType.TRUCK;

    List<Integer> nameNumbers = new ArrayList();
    String name;
    TruckModel model;

    int distanceTraveled = 0;

    final int normalSpeed = 100;
    int currentSpeed;
    double acceleration;

    boolean isBrokenDown = false;
    int breakdownTurnsLeft = 0;
    static List<Truck> currentlyBrokenDown = new ArrayList<>();

    public TruckModel getModel() {
        return model;
    }

    public double getAcceleration() {
        return acceleration;
    }

    Truck(TruckModel model) {
        // speed: 100km/h. 5% chance of breaking down for 2 hours.
        // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
        this.model = model;
        Integer truckNumber;
        do {
            truckNumber = ThreadLocalRandom.current().nextInt(0, 1001);
        } while (nameNumbers.contains(truckNumber));
        nameNumbers.add(truckNumber);
        this.name = String.valueOf(truckNumber);
        this.acceleration = model.getAcceleration();

    }

    @Override
    public void moveForAnHour(Race race) {
        if (breakdownTurnsLeft == 0) {
            int decideBreakDown = ThreadLocalRandom.current().nextInt(1, 101);
            if (decideBreakDown > 5 && decideBreakDown < 101) {
                if (currentlyBrokenDown.contains(this)) {
                    currentlyBrokenDown.remove(this);
                }
                isBrokenDown = false;
                currentSpeed = normalSpeed;
                distanceTraveled += currentSpeed * 1;
            } else {
                currentSpeed = 0;
                isBrokenDown = true;
                breakdownTurnsLeft += 1;
                currentlyBrokenDown.add(this);
            }
        } else if (breakdownTurnsLeft > 0) {
            currentSpeed = 0;
            isBrokenDown = true;
            breakdownTurnsLeft -= 1;

        } else {
            System.out.printf("Remaining turns while broken down can't be negative: %d", breakdownTurnsLeft);
            System.out.println();
        }
    }

    @Override
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public int getNormalSpeed() {
        return 0;
    }

    @Override
    public int getTopSpeed() {
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    boolean isBrokenDown() {
        return isBrokenDown;
    }

    int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

    int getCurrentSpeed() {
        return currentSpeed;
    }

    List<Integer> getNameNumbers() {
        return nameNumbers;
    }
}
