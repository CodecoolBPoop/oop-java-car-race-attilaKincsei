package com.codecool;

import java.util.concurrent.ThreadLocalRandom;

public class Car implements Vehicle {

    static final VehicleType vehicleType = VehicleType.CAR;

    CarModel carModel;

    final int topSpeed;

    // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    final int normalSpeed;

    int currentSpeed;

    // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.
    final String name;

    // holds the current distance traveled.
    int distanceTraveled = 0;

    Car(CarModel carModel) {
        this.carModel = carModel;
        this.name = carModel.name();
        this.topSpeed = carModel.getTopSpeed();
        this.normalSpeed = ThreadLocalRandom.current().nextInt(80, 110);
    }

    @Override
    public void moveForAnHour(Race race) {
        // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!
        // If there is a broken down Truck on the track, then limit the max speed of vehicles to 75 km/h.
        if (!race.isThereABrokenTruck()) {
            currentSpeed = normalSpeed;
            distanceTraveled += currentSpeed;
        } else {
            currentSpeed = 75;
            distanceTraveled += currentSpeed * 1;
        }
    }

    @Override
    int getNormalSpeed() {
        return normalSpeed;
    }

    @Override
    int getTopSpeed() {
        return topSpeed;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    int getDistanceTraveled() {
        return distanceTraveled;
    }

    VehicleType getVehicleType() {
        return vehicleType;
    }

    CarModel getCarModel() {
        return carModel;
    }

}
