package factories;

import interfaces.Sedan;
import interfaces.SUV;
import interfaces.ElectricCar;

public interface CarFactory {
    Sedan createSedan();
    SUV createSUV();
    ElectricCar createElectricCar();
}
