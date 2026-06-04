package main.dp910.fp.v1;

public class PizzaStoreV1 {

    public Pizza orderPizza(String type) {

        Pizza pizza = PizzaFactory.createPizza(type);

        pizza.cut();

        return pizza;
    }
}
