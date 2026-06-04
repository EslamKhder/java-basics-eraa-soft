package main.dp910.fp.v1;

public class PizzaStoreV3 {

    public Pizza orderPizza(String type) {

        Pizza pizza = PizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();

        return pizza;
    }
}
