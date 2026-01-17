package main.dp907.ex1;

public class OrderPizzaV2 {

    public void orderPizza(String type){

        Pizza pizza = PizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();

    }
}
