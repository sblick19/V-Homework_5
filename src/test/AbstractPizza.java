package test;

import cookStrategy.ICookingStrategy;

public abstract class AbstractPizza {
	    protected List<Toppings> toppingList;
	    protected double priceWithoutToppings;
	    protected double totalPrice;
	    protected int pizzaOrderID;
	    protected static int orderIDCounter = 1000; // Starting order ID

	    protected ICookingStrategy cookingStrategy;
	    protected double cookingPrice;

	    // Constructor
	    public AbstractPizza() {
	        this.toppingList = new ArrayList<>();
	        this.priceWithoutToppings = 0.0;
	        this.totalPrice = 0.0;
	        this.pizzaOrderID = orderIDCounter++;
	        // Initialize other attributes as needed
	    }

	    // Getter and Setter methods for attributes
	    public List<Toppings> getToppingList() {
	        return toppingList;
	    }

	    public void setToppingList(List<Toppings> toppingList) {
	        this.toppingList = toppingList;
	    }

	    public double getPriceWithoutToppings() {
	        return priceWithoutToppings;
	    }

	    public void setPriceWithoutToppings(double priceWithoutToppings) {
	        this.priceWithoutToppings = priceWithoutToppings;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    public int getPizzaOrderID() {
	        return pizzaOrderID;
	    }

	    public ICookingStrategy getCookingStrategy() {
	        return cookingStrategy;
	    }

	    public void setCookingStrategy(ICookingStrategy cookingStrategy) {
	        this.cookingStrategy = cookingStrategy;
	    }

	    public double getCookingPrice() {
	        return cookingPrice;
	    }

	    public void setCookingPrice(double cookingPrice) {
	        this.cookingPrice = cookingPrice;
	    }

}
