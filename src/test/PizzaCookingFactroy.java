package test;

public class PizzaCookingFactory {
    public AbstractPizza createPizza(PizzaType pizzaType) {
        AbstractPizza pizza = null;
        int currentOrderID = AbstractPizza.getOrderIDCounter() + 1;

        switch (pizzaType) {
            case MARGHERITA:
                pizza = new MargheritaPizza();
                pizza.setPriceWithoutToppings(2.5);
                break;
            case SUPREME:
                pizza = new SupremePizza();
                pizza.setPriceWithoutToppings(3.5);
                break;
            case VEGETARIAN:
                pizza = new Vegetarianpizza();
                pizza.setPriceWithoutToppings(1.5);
                break;
            case HAWAIIAN:
                pizza = new HawaiianPizza();
                pizza.setPriceWithoutToppings(3.00);
            default:
                System.out.println("Invalid pizza type specified.");
                return null;
        }

        pizza.setPizzaOrderID(currentOrderID);
        AbstractPizza.setOrderIDCounter(currentOrderID);
        return pizza;
    }
}
