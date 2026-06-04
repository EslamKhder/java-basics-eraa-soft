package main.dp910.fp.v1;

public class PizzaFactory {

    public static Pizza createPizza(String type) {
        Pizza p = null;

        if (type.equals("cheese")) {
            p = new CheesePizza();
        } else if (type.equals("meat")) {
            p = new MeatPizza();
        } else {
            throw new RuntimeException("invalid type");
        }

        return p;
    }
}
