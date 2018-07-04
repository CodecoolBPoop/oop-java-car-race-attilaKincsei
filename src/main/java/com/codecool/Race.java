package com.codecool;

import java.util.ArrayList;
import java.util.List;

// TODO: move common variables and methods to vehicle
// TODO: refactor vehicle interface into abstract class
// TODO: create an intermediate class between vehicle and its subclasses if needed
// TODO: create a probability class for a probability method
public class Race {

    private int numberOfLaps;
    boolean isRaining; // move into weather
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Race(int numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
        createVehicles();
    }

    private void createVehicles() {
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

    private void simulateRace() {
        // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        for (int i = 0; i < numberOfLaps; i++) {
            Weather.setRaining();
            isRaining = Weather.isRaining();
            for (Vehicle aVehicleList : vehicleList) {
                aVehicleList.moveForAnHour(this);
            }
        }
    }

    private void sortVehiclesByDistanceCovered() {
        vehicleList.sort((o1, o2) -> o2.getDistanceTraveled() - o1.getDistanceTraveled());
    }

    private void printRaceResults() {
        // prints each vehicle's name, distance traveled ant type.
        sortVehiclesByDistanceCovered();
        vehicleList.forEach(vehicle -> {
            System.out.printf("Name: %s. Distance Travelled: %d km. Vehicle Type: %s",
                    vehicle.getName(), vehicle.getDistanceTraveled(), vehicle.getVehicleType().name());
            System.out.println();
        });
    }

    public static void main(String[] args) {
        Race firstRace = new Race(50);
        firstRace.simulateRace();
        firstRace.printRaceResults();

    }

}
