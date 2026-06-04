package main.dp910.fp.v1;

public class main {
    public static void main(String[] args) {

        PizzaStoreV1 store = new PizzaStoreV1();

        store.orderPizza("cheese");

        System.out.println("----------------");

        store.orderPizza("veg");
        System.out.println("----------------");

        store.orderPizza("meat");
    }

}
