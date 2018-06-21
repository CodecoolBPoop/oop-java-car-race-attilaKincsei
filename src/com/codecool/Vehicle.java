package com.codecool;

abstract class Vehicle {

    Vehicle() {
    }

    abstract int getNormalSpeed();

    abstract int getTopSpeed();

    abstract String getName();

    abstract int getDistanceTraveled();

    abstract void moveForAnHour(Race race);
}