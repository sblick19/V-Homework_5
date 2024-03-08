package test;

public class SupremePizza extends AbstractPizza{
	// Constructor
    public SupremePizza() {
        super();
        // Additional initialization specific to MargheritaPizza if needed
    }

    // Copy constructor
    public SupremePizza(SupremePizza other) {
        super();
        this.toppingList = new ArrayList<>(other.getToppingList());
        this.priceWithoutToppings = other.getPriceWithoutToppings();
        this.totalPrice = other.getTotalPrice();
        this.pizzaOrderID = other.getPizzaOrderID();
        this.cookingStyleType = other.getCookingStyleType();
        this.cookingPrice = other.getCookingPrice();
    }

    // Getter and setter methods if needed

}