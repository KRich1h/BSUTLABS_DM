package client;

import factories.CarFactory;
import factories.ToyotaFactory;
import factories.FordFactory;
import interfaces.Sedan;
import interfaces.SUV;
import interfaces.ElectricCar;

public class CarManufacturing {
    public static void main(String[] args) {
        // Создаем фабрику Toyota
        CarFactory toyotaFactory = new ToyotaFactory();

        // Производим автомобили Toyota
        System.out.println("Toyota cars:");
        Sedan toyotaSedan = toyotaFactory.createSedan();
        toyotaSedan.drive();
        SUV toyotaSUV = toyotaFactory.createSUV();
        toyotaSUV.drive();
        ElectricCar toyotaElectric = toyotaFactory.createElectricCar();
        toyotaElectric.drive();

        // Создаем фабрику Ford
        CarFactory fordFactory = new FordFactory();

        // Производим автомобили Ford
        System.out.println("\nFord cars:");
        Sedan fordSedan = fordFactory.createSedan();
        fordSedan.drive();
        SUV fordSUV = fordFactory.createSUV();
        fordSUV.drive();
        ElectricCar fordElectric = fordFactory.createElectricCar();
        fordElectric.drive();
    }
}
