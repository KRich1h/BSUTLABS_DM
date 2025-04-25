package products.toyota;

import interfaces.SUV;

public class ToyotaSUV implements SUV {
    @Override
    public void drive() {
        System.out.println("Driving Toyota RAV4");
    }
}
