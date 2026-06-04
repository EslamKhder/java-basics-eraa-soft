package main.dp910.fp.v1;

public class PizzaStoreV2 {

    public Pizza orderPizza(String type) {

        Pizza pizza = PizzaFactory.createPizza(type);

        pizza.prepare();

        return pizza;
    }
}
