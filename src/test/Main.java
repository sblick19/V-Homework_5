package test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a PizzaCookingFactory
        PizzaCookingFactory pizzaCookingFactory = new PizzaCookingFactory();

        // Create a CookingStrategy (e.g., BrickOvenCookingStrategy, ConventionalOvenCookingStrategy, etc.)
        ICookingStrategy cookingStrategy = new BrickOvenCookingStrategy();

        // Create a PizzaOrder
        PizzaOrder pizzaOrder = new PizzaOrder(pizzaCookingFactory, cookingStrategy);

        // Add pizzas to the order (you can add as many as you want)
        pizzaOrder.addPizzaToCart(PizzaType.MARGHERITA);
        pizzaOrder.addPizzaToCart(PizzaType.HAWAIIAN);

        // Place the order and cook the pizzas
        pizzaOrder.placeOrder();

        // Print detailed information about each pizza in the order
        pizzaOrder.printPizzaOrderCartWithDetails();
    }

}
