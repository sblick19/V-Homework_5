package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MargheritaPizza extends AbstractPizza {
    // Default toppings for MargheritaPizza
    private static final List<Toppings> DEFAULT_TOPPINGS = Arrays.asList(Toppings.TOMATO, Toppings.CHEESE);
    // Default price without toppings for MargheritaPizza
    private static final double DEFAULT_PRICE_WITHOUT_TOPPINGS = 2.50;

    public MargheritaPizza() {
        super();
        this.priceWithoutToppings = 2.5; // Default price without toppings
        addDefaultToppings(Toppings.TOMATO, Toppings.CHEESE);
    }
    // Constructor
    public MargheritaPizza(ICookingStrategy cookingStrategy, double cookingPrice) {
        super();
        this.setToppingList(DEFAULT_TOPPINGS);
        this.setPriceWithoutToppings(DEFAULT_PRICE_WITHOUT_TOPPINGS);
        this.setCookingStrategy(cookingStrategy);
        this.setCookingPrice(cookingPrice);
        this.addToppingsToPrice(DEFAULT_PRICE_WITHOUT_TOPPINGS);
    }

    // Copy Constructor
    public MargheritaPizza(MargheritaPizza otherPizza) {
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
        // MargheritaPizza has default toppings, no need to add more
    }

    @Override
    public double calculateTotalPrice() {
        return updatePizzaPrice(); // Total price already calculated with default toppings
    }
    // Setter and Getter methods
    // These methods are inherited from the AbstractPizza class
    // No additional implementation required
}

