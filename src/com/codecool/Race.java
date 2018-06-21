package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Race {

    int numberOfLaps;
    boolean isRaining;
    List<Vehicle> vehicleList = new ArrayList<>();

    public Race(int numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    void createVehicles() {
        // creates 10 cars, 10 trucks and 10 motorcycles.
        for (CarModel model:CarModel.values()) {
            Car newCar = new Car(model);
            vehicleList.add(newCar);
        }
        for (MotorcycleModel motorModel : MotorcycleModel.values()) {
            Motorcycle newMotor = new Motorcycle(motorModel);
            vehicleList.add(newMotor);
        }
        for (TruckModel truckModel : TruckModel.values()) {
            Truck newTruck = new Truck(truckModel);
            vehicleList.add(newTruck);

        }
    }

    boolean isThereABrokenTruck() {
        return Truck.currentlyBrokenDown.size() != 0;
    }

    void simulateRace() {
        // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        for (int i = 0; i < numberOfLaps; i++) {
            Weather.setRaining();
            isRaining = Weather.isRaining();
            for (int j = 0; j < vehicleList.size(); j++) {
                vehicleList.get(j).moveForAnHour(this);
            }
        }
    }

    void printRaceResults() {
        // prints each vehicle's name, distance traveled ant type.
        for (int j = 0; j < vehicleList.size(); j++) {
            System.out.printf(
                    "Name: %s. Distance Travelled: %d km. Vehicle Type: %s",
                    vehicleList.get(j).getName(), vehicleList.get(j).getDistanceTraveled(),
                    vehicleList.get(j).getVehicleType().name()
            );
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Race firstRace = new Race(50);
        firstRace.createVehicles();
        firstRace.simulateRace();
        for (Vehicle vehicle :
                firstRace.vehicleList) {
            System.out.printf("%s travelled: %d kms", vehicle.getName(), vehicle.getDistanceTraveled());
            System.out.println();
        }
//        firstRace.printRaceResults();

    }

}
