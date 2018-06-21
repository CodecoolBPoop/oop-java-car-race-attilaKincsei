package com.codecool;

public class TestRace {


    public static void main(String[] args) {
//        CarModel myCarModel = CarModel.HENNESSEY_VENOM_F5;
//        System.out.println(myCarModel);
//        for (TruckModel carModel:TruckModel.values()) {
//            System.out.println(carModel);
//            System.out.println(carModel.getAcceleration());
//        }

        Car car1  = new Car(CarModel.BUGATTI_VEYRON_SUPER_SPORT);
        System.out.println(car1.distanceTraveled);
        car1.moveForAnHour(new Race(10));
        System.out.println(car1.distanceTraveled);

        Motorcycle motorcycle1 = new Motorcycle(MotorcycleModel.KAWASAKI_NINJA_H2R);
        System.out.println(motorcycle1.distanceTraveled);
        Weather.setRaining();
        motorcycle1.moveForAnHour(new Race(10));
        System.out.println(motorcycle1.distanceTraveled);
    }
}
