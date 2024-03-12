package test;

public class SupremePizza extends AbstractPizza{
	// Constructor
    public SupremePizza() {
        super();
        //tomato sauce, mozzarella cheese, pepperoni, sausage, onions, green peppers, and mushrooms
        this.toppingList.add(Toppings.TOMATO);
        this.toppingList.add(Toppings.CHEESE);
        this.toppingList.add("bell peppers");
        this.toppingList.add("Italian sausage");
        this.toppingList.add("pepperoni");
        this.toppingList.add("black olives");
        this.toppingList.add("mushrooms");
        this.priceWithoutToppings = 10.0;
        this.totalPrice = 10.0;
        this.cookingStyleType = CookingStyleType.REGULAR;
        this.cookingPrice = 0.0;
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
    
    public String toString() {
		return("Price without toppings: "+this.priceWithoutToppings+
				", Total Price: "+this.totalPrice+
				", Cooking Price: "+this.cookingPrice+
				", Cooking Strategy: "+this.cookingStrategy+
				", Toppings: "+this.toppingList);
	}

    // Getter and setter methods if needed

}