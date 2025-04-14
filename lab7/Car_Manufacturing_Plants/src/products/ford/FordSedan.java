package products.ford;

import interfaces.Sedan;

public class FordSedan implements Sedan {
    @Override
    public void drive() {
        System.out.println("Driving Ford Fusion");
    }
}
