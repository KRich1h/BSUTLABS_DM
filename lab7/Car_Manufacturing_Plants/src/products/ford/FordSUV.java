package products.ford;

import interfaces.SUV;

public class FordSUV implements SUV {
    @Override
    public void drive() {
        System.out.println("Driving Ford Explorer");
    }
}
