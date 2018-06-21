package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Race {

    List<Car> racingCars = new ArrayList<>(10);
    List<Motorcycle> racingMotorcycles = new ArrayList<>(10);
    List<Truck> racingTrucks = new ArrayList<>(10);
    List<Vehicle> vehicleList = new ArrayList<>();
    boolean isRaining;


    void createVehicles() {
        // creates 10 cars, 10 trucks and 10 motorcycles.
        for (CarModel model:CarModel.values()) {
            Car newCar = new Car(model);
            racingCars.add(newCar);
            vehicleList.add(newCar);
        }
        for (MotorcycleModel motorModel : MotorcycleModel.values()) {
            Motorcycle newMotor = new Motorcycle(motorModel);
            racingMotorcycles.add(newMotor);
            vehicleList.add(newMotor);
        }
        for (TruckModel truckModel : TruckModel.values()) {
            Truck newTruck = new Truck(truckModel);
            racingTrucks.add(newTruck);
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
        for (int i = 0; i < 50; i++) {
            Weather.setRaining();
            isRaining = Weather.isRaining();
            for (int j = 0; j < vehicleList.size(); j++) {
                vehicleList.get(j).moveForAnHour(this);
//                racingMotorcycles.get(j).moveForAnHour(this);
//                racingTrucks.get(j).moveForAnHour(this);
            }
        }
    }

    void printRaceResults() {
        // prints each vehicle's name, distance traveled ant type.
        for (int j = 0; j < 10; j++) {
            System.out.printf(
                    "Name: %s. Distance Travelled: %d km. Vehicle Type: %s",
                    racingCars.get(j).getName(), racingCars.get(j).getDistanceTraveled(),
                    racingCars.get(j).getVehicleType().name()
            );
            System.out.println();
        }
        for (int j = 0; j < 10; j++) {
            System.out.printf(
                    "Name: %s. Distance Travelled: %d km. Vehicle Type: %s",
                    racingMotorcycles.get(j).getName(), racingMotorcycles.get(j).getDistanceTraveled(),
                    racingMotorcycles.get(j).getVehicleType().name()
            );
            System.out.println();
        }
        for (int j = 0; j < 10; j++) {
            System.out.printf(
                    "Name: %s. Distance Travelled: %d km. Vehicle Type: %s",
                    racingTrucks.get(j).getName(), racingTrucks.get(j).getDistanceTraveled(),
                    racingTrucks.get(j).getVehicleType().name()
            );
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Race firstRace = new Race();
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
