package main.dp907.ex1;

public class PizzaFactory {


    public static Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.equalsIgnoreCase("veg")){
            pizza = new VegPizza();
        } else if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equalsIgnoreCase("chicken")) {
            pizza = new Chicken();
        } else {
            throw new RuntimeException("invalid type");
        }

        return pizza;
    }
}
