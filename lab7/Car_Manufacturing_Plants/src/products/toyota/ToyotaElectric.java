package products.toyota;

import interfaces.ElectricCar;

public class ToyotaElectric implements ElectricCar {
    @Override
    public void drive() {
        System.out.println("Driving Toyota bZ4X");
    }
}
