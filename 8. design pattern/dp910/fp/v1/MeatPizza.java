package main.dp910.fp.v1;

// CheesePizza class
public class MeatPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Meat Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Meat Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Meat Pizza");
    }
}
