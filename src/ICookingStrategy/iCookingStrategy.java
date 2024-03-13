package ICookingStrategy;

import test.AbstractPizza;

public interface iCookingStrategy {
	boolean cook(AbstractPizza pizza);
}

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    private PizzaCookingFactory pizzaFactory;
    private ICookingStrategy cookingStrategy;
    private List<AbstractPizza> pizzaOrderList;

    public PizzaOrder(PizzaCookingFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
        this.pizzaOrderList = new ArrayList<>();
    }

    public void printListOfToppingsByPizzaOrderID(int orderID) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            System.out.println("Toppings for Pizza Order ID: " + orderID);
            List<Toppings> toppingList = pizza.getToppingList();
            if (toppingList.isEmpty()) {
                System.out.println("No toppings added.");
            } else {
                for (Toppings topping : toppingList) {
                    System.out.println("- " + topping.getName());
                }
            }
        } else {
            System.out.println("Pizza order with ID " + orderID + " not found.");
        }
    }

    public void printPizzaOrderCart(int orderID) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            System.out.println("Pizza Order ID: " + orderID);
            System.out.println("Base Price: " + pizza.getPriceWithoutToppings());
            System.out.println("Toppings:");
            List<Toppings> toppingList = pizza.getToppingList();
            for (Toppings topping : toppingList) {
                System.out.println("- " + topping.getName());
            }
            System.out.println("Cooking Strategy: " + pizza.getCookingStrategy());
            System.out.println("Cooking Price: " + pizza.getCookingPrice());
            System.out.println("Total Price: " + pizza.getTotalPrice());
        } else {
            System.out.println("Pizza order with ID " + orderID + " not found.");
        }
    }

    public AbstractPizza getPizzaByOrderID(int orderID) {
        for (AbstractPizza pizza : pizzaOrderList) {
            if (pizza.getPizzaOrderID() == orderID) {
                return pizza;
            }
        }
        return null;
    }

    public boolean addPizzaToCart(PizzaType pizzaType) {
        AbstractPizza pizza = pizzaFactory.createPizza(pizzaType);
        if (pizza != null) {
            pizzaOrderList.add(pizza);
            return true;
        }
        return false;
    }

    public boolean addNewToppingToPizza(int orderID, Toppings topping) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            List<Toppings> toppingList = pizza.getToppingList();
            if (!toppingList.contains(topping)) {
                toppingList.add(topping);
                // Update pizza price based on the added topping
                double toppingPrice = topping.getPrice();
                pizza.setTotalPrice(pizza.getTotalPrice() + toppingPrice);
                return true;
            }
        }
        return false;
    }

    public boolean removeToppingFromPizza(int orderID, Toppings topping) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            List<Toppings> toppingList = pizza.getToppingList();
            if (toppingList.remove(topping)) {
                // Update pizza price based on the removed topping
                double toppingPrice = topping.getPrice();
                pizza.setTotalPrice(pizza.getTotalPrice() - toppingPrice);
                return true;
            }
        }
        return false;
    }

    public boolean isThereAnyUncookedPizza() {
        for (AbstractPizza pizza : pizzaOrderList) {
            if (pizza.getCookingStrategy() == null) {
                return true;
            }
        }
        return false;
    }

    public double checkout() throws Exception {
        if (isThereAnyUncookedPizza()) {
            throw new Exception("Cannot checkout. There are uncooked pizzas in the order.");
        }

        double totalPrice = 0.0;
        for (AbstractPizza pizza : pizzaOrderList) {
            totalPrice += pizza.getTotalPrice();
        }
        return totalPrice;
    }

    public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null) {
            ICookingStrategy cookingStrategy;
            switch (cookingStrategyType) {
                case BRICK_OVEN:
                    cookingStrategy = new BrickOvenCookingStrategy();
                    break;
                case CONVENTIONAL_OVEN:
                    cookingStrategy = new ConventionalOvenCookingStrategy();
                    break;
                case MICROWAVE:
                    cookingStrategy = new MicrowaveCookingStrategy();
                    break;
                default:
                    System.out.println("Invalid cooking strategy type.");
                    return false;
            }
            cookingStrategy.cook(pizza);
            return true;
        }
        return false;
    }
}