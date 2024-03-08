package test;

public class SupremePizza extends AbstractPizza{
	// Constructor
    public SupremePizza() {
        super();
        //tomato sauce, mozzarella cheese, pepperoni, sausage, onions, green peppers, and mushrooms
        this.toppingList.add("tomato");
        this.toppingList.add("cheese");
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

    // Getter and setter methods if needed

}