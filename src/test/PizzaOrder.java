package test;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    private PizzaCookingFactory pizzaFactory;
    private ICookingStrategy cookingStrategy;
    private List<AbstractPizza> pizzaOrderList;

    public PizzaOrder(PizzaCookingFactory pizzaFactory, ICookingStrategy cookingStrategy) {
        this.pizzaFactory = pizzaFactory;
        this.cookingStrategy = cookingStrategy;
        this.pizzaOrderList = new ArrayList<>();
    }

    public PizzaCookingFactory getPizzaFactory() {
        return pizzaFactory;
    }

    public void setPizzaFactory(PizzaCookingFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public ICookingStrategy getCookingStrategy() {
        return cookingStrategy;
    }

    public void setCookingStrategy(ICookingStrategy cookingStrategy) {
        this.cookingStrategy = cookingStrategy;
    }

    public List<AbstractPizza> getPizzaOrderList() {
        return pizzaOrderList;
    }

    public void setPizzaOrderList(List<AbstractPizza> pizzaOrderList) {
        this.pizzaOrderList = pizzaOrderList;
    }

    public void addPizzaOrder(AbstractPizza pizza) {
        pizzaOrderList.add(pizza);
    }

    public void removePizzaOrder(AbstractPizza pizza) {
        pizzaOrderList.remove(pizza);
    }

    public void placeOrder() {
        for (AbstractPizza pizza : pizzaOrderList) {
            pizzaFactory.cookPizza(pizza, cookingStrategy);
        }
    }

    public void printPizzaOrderCartWithDetails() {
        System.out.println("Pizza Order Details:");
        for (AbstractPizza pizza : pizzaOrderList) {
            System.out.println(pizza.toString());
        }
    }
    
    public AbstractPizza getPizzaByOrderID(int orderID) {
        for (AbstractPizza pizza : pizzaOrderList) {
            if (pizza.getPizzaOrderID() == orderID) {
                return pizza;
            }
        }
        return null; // Pizza order with the given orderID not found
    }

    public boolean addPizzaToCart(PizzaType pizzaType) {
        if (pizzaType == null) {
            return false;
        }

        AbstractPizza pizza = pizzaFactory.createPizza(pizzaType, cookingStrategy);
        if (pizza != null) {
            pizzaOrderList.add(pizza);
            return true;
        }
        return false;
    }

    public boolean addNewToppingToPizza(int orderID, Toppings topping) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null && topping != null) {
            List<Toppings> toppingsList = pizza.getToppingList();
            if (!toppingsList.contains(topping)) {
                toppingsList.add(topping);
                pizza.addTopping(topping);
                return true;
            }
        }
        return false;
    }

    public boolean removeToppingFromPizza(int orderID, Toppings topping) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null && topping != null) {
            List<Toppings> toppingsList = pizza.getToppingList();
            if (toppingsList.contains(topping)) {
                toppingsList.remove(topping);
                pizza.updatePizzaPrice(); // Update pizza price after removing topping
                return true;
            }
        }
        return false;
    }

    public boolean isThereAnyUncookedPizza() {
        for (AbstractPizza pizza : pizzaOrderList) {
            if (pizza.getCookingStrategy() == null) {
                return true; // Found a pizza without assigned cooking strategy
            }
        }
        return false; // No pizzas without assigned cooking strategy found
    }

    public double checkout() throws Exception {
        if (isThereAnyUncookedPizza()) {
            throw new Exception("Cannot checkout: There are uncooked pizzas.");
        } else {
            double totalCartPrice = 0.0;
            for (AbstractPizza pizza : pizzaOrderList) {
                totalCartPrice += pizza.getTotalPrice();
            }
            return totalCartPrice;
        }
    }

    public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
        AbstractPizza pizza = getPizzaByOrderID(orderID);
        if (pizza != null && cookingStrategyType != null) {
            ICookingStrategy cookingStrategy = null;
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
            }
            if (cookingStrategy != null) {
                return cookingStrategy.cook(pizza);
            }
        }
        return false;
    }
}
