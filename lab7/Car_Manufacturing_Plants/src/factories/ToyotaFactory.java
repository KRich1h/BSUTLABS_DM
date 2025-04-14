package factories;

import interfaces.Sedan;
import interfaces.SUV;
import interfaces.ElectricCar;
import products.toyota.ToyotaSedan;
import products.toyota.ToyotaSUV;
import products.toyota.ToyotaElectric;

public class ToyotaFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return new ToyotaSedan();
    }

    @Override
    public SUV createSUV() {
        return new ToyotaSUV();
    }

    @Override
    public ElectricCar createElectricCar() {
        return new ToyotaElectric();
    }
}
