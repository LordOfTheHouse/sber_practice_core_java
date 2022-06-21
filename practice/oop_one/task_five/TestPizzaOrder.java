package practice.oop_one.task_five;

public class TestPizzaOrder {
    public static void main(String[] args) {
        PizzaOrder pizza = new PizzaOrder("Italian", true, "Koneva, 6", 2);
        pizza.order();
        pizza.order();
        pizza.cansel();
        pizza.cansel();
        pizza.setSizePizza(3);
        System.out.println(pizza.getSizePizza());
        System.out.println(pizza);
    }
}
