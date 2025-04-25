package products.ford;

import interfaces.ElectricCar;

public class FordElectric implements ElectricCar {
    @Override
    public void drive() {
        System.out.println("Driving Ford Mustang Mach-E");
    }
}
