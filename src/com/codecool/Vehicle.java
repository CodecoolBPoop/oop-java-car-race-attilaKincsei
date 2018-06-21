package com.codecool;

interface Vehicle {

    VehicleType vehicleType = null;

    int getNormalSpeed();

    int getTopSpeed();

    VehicleType getVehicleType();

    String getName();

    int getDistanceTraveled();

    void moveForAnHour(Race race);
}