package test;

public class PizzaCookingFactory {
	 private static int orderIDCounter = 1;

	    public AbstractPizza createPizza(PizzaType pizzaType, ICookingStrategy cookingStrategy) {
	        AbstractPizza pizza = null;

	        switch (pizzaType) {
	            case HAWAIIAN:
	                pizza = new HawaiianPizza();
	                break;
	            case MARGHERITA:
	                pizza = new MargheritaPizza();
	                break;
	            case SUPREME:
	                pizza = new SupremePizza();
	                break;
	            case VEGETARIAN:
	                pizza = new VegetarianPizza();
	                break;
	            default:
	                // Handle unsupported pizza types
	                break;
	        }

	        if (pizza != null) {
	            pizza.setPizzaOrderID(orderIDCounter++);
	            // Apply cooking strategy to the pizza
	            if (cookingStrategy != null) {
	                cookingStrategy.cook(pizza);
	            } else {
	                // Handle case where cooking strategy is not set
	            }
	        }

	        return pizza;
	    }

	    // Method to cook the pizza
	    public void cookPizza(AbstractPizza pizza, ICookingStrategy cookingStrategy) {
	        if (cookingStrategy != null) {
	            cookingStrategy.cook(pizza);
	        } else {
	            // Handle case where cooking strategy is not set
	        }
	    }
}
