package test;

public class MargheritaPizza extends AbstractPizza{
	// Constructor
    public MargheritaPizza() {
        super();
        // Additional initialization specific to MargheritaPizza if needed
    }

    // Copy constructor
    public MargheritaPizza(MargheritaPizza other) {
        super();
        this.toppingList = new ArrayList<>(other.getToppingList());
        this.priceWithoutToppings = other.getPriceWithoutToppings();
        this.totalPrice = other.getTotalPrice();
        this.pizzaOrderID = other.getPizzaOrderID();
        this.cookingStyleType = other.getCookingStyleType();
        this.cookingPrice = other.getCookingPrice();
    }
    
    public String toString() {
		return("Price without toppings: "+this.priceWithoutToppings+
				", Total Price: "+this.totalPrice+
				", Cooking Price: "+this.cookingPrice+
				", Cooking Strategy: "+this.cookingStrategy+
				", Toppings: "+this.toppingList);
	}

    // Getter and setter methods if needed

}
