package products.toyota;

import interfaces.Sedan;

public class ToyotaSedan implements Sedan {
    @Override
    public void drive() {
        System.out.println("Driving Toyota Camry");
    }
}
