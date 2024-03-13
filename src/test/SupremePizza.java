package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SupremePizza extends AbstractPizza {
    // Default toppings for SupremePizza
    private static final List<Toppings> DEFAULT_TOPPINGS = Arrays.asList(
            Toppings.TOMATO, Toppings.CHEESE, Toppings.BELL_PEPPER,
            Toppings.ITALIAN_SAUSAGE, Toppings.PEPPERONI,
            Toppings.BLACK_OLIVE, Toppings.MUSHROOM);
    // Default price without toppings for SupremePizza
    private static final double DEFAULT_PRICE_WITHOUT_TOPPINGS = 3.50;

    public SupremePizza() {
        super();
        this.priceWithoutToppings = 3.5; // Default price without toppings
        addDefaultToppings(Toppings.TOMATO, Toppings.CHEESE, Toppings.BELL_PEPPER, Toppings.ITALIAN_SAUSAGE, Toppings.PEPPERONI, Toppings.BLACK_OLIVE, Toppings.MUSHROOM);
    }
    // Constructor
    public SupremePizza(ICookingStrategy cookingStrategy, double cookingPrice) {
        super();
        this.setToppingList(DEFAULT_TOPPINGS);
        this.setPriceWithoutToppings(DEFAULT_PRICE_WITHOUT_TOPPINGS);
        this.setCookingStrategy(cookingStrategy);
        this.setCookingPrice(cookingPrice);
        this.addToppingsToPrice(DEFAULT_PRICE_WITHOUT_TOPPINGS);
    }

    // Copy Constructor
    public SupremePizza(SupremePizza otherPizza) {
        super();
        this.toppingList = new ArrayList<>(otherPizza.getToppingList());
        this.priceWithoutToppings = otherPizza.getPriceWithoutToppings();
        this.totalPrice = otherPizza.getTotalPrice();
        this.pizzaOrderID = otherPizza.getPizzaOrderID();
        this.cookingStrategy = otherPizza.getCookingStrategy();
        this.cookingPrice = otherPizza.getCookingPrice();
    }

    @Override
    public void addTopping(Toppings topping) {
        if (topping != null) {
            getToppingList().add(topping);
            updatePizzaPrice();
        }
    }

    @Override
    public double calculateTotalPrice() {
        return updatePizzaPrice(); // Total price will be recalculated with added toppings
    }
    // Setter and Getter methods
    // These methods are inherited from the AbstractPizza class
    // No additional implementation required
}
