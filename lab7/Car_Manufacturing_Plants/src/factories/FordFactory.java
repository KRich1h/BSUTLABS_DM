package factories;

import interfaces.Sedan;
import interfaces.SUV;
import interfaces.ElectricCar;
import products.ford.FordSedan;
import products.ford.FordSUV;
import products.ford.FordElectric;

public class FordFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return new FordSedan();
    }

    @Override
    public SUV createSUV() {
        return new FordSUV();
    }

    @Override
    public ElectricCar createElectricCar() {
        return new FordElectric();
    }
}
