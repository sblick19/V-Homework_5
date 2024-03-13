package test;
import java.util.ArrayList;
import java.util.List;

	public abstract class AbstractPizza {
		
		 protected List<Toppings> toppingList;
		    protected double priceWithoutToppings;
		    protected double totalPrice;
		    protected int pizzaOrderID;
		    protected static int orderIDCounter = 1;
		    protected ICookingStrategy cookingStrategy;
		    protected double cookingPrice;

		    public AbstractPizza() {
		        this.toppingList = new ArrayList<>();
		        this.priceWithoutToppings = 0.0;
		        this.totalPrice = 0.0;
		        this.pizzaOrderID = orderIDCounter++;
		        this.cookingStrategy = null;
		        this.cookingPrice = 0.0;
		    }

		    protected void addDefaultToppings(Toppings... defaultToppings) {
		        for (Toppings topping : defaultToppings) {
		            this.toppingList.add(topping);
		        }
		        updatePizzaPrice();
		    }

	    // Getter and Setter methods
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

	    public void setPizzaOrderID(int pizzaOrderID) {
	        this.pizzaOrderID = pizzaOrderID;
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

	    // Method to add toppings to the pizza and calculate total price
	    protected double addToppingsToPrice(double priceWithoutToppings) {
	        double totalToppingsPrice = 0;
	        for (Toppings topping : toppingList) {
	            totalToppingsPrice += topping.getPrice();
	        }
	        this.totalPrice = priceWithoutToppings + totalToppingsPrice;
	        this.priceWithoutToppings = priceWithoutToppings;
	        return totalPrice;
	    }

	    // Method to update the total price of the pizza
	    public double updatePizzaPrice() {
	        return addToppingsToPrice(priceWithoutToppings);
	    }

	    // Method to generate unique order ID
	    protected int generateOrderID() {
	        return orderIDCounter++;
	    }

	    // Abstract method for adding toppings
	    public abstract void addTopping(Toppings topping);

	    // Abstract method for calculating total price
	    public abstract double calculateTotalPrice();

	    // Override toString() method to display all the field information
	    @Override
	    public String toString() {
	        return "Pizza Order ID: " + pizzaOrderID + "\n" +
	                "Topping List: " + toppingList + "\n" +
	                "Price without Toppings: $" + priceWithoutToppings + "\n" +
	                "Total Price: $" + totalPrice + "\n" +
	                "Cooking Strategy: " + cookingStrategy + "\n" +
	                "Cooking Price: $" + cookingPrice + "\n";
	    }
}


