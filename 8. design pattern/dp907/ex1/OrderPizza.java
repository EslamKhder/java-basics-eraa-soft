package main.dp907.ex1;

public class OrderPizza {

    public void orderPizza(String type){

        Pizza pizza = PizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();

    }
}
