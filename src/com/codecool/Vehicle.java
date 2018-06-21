package com.codecool;

interface Vehicle {

    int getNormalSpeed();

    int getTopSpeed();

    VehicleType getVehicleType();

    String getName();

    int getDistanceTraveled();

    void moveForAnHour(Race race);
}