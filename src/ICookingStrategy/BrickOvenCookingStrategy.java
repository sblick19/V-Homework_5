package ICookingStrategy;

import test.AbstractPizza;

public class BrickOvenCookingStrategy implements iCookingStrategy {
	public boolean cook(AbstractPizza pizza) {
        pizza.setCookingStrategy(this);
        pizza.setCookingPrice(10.0);
        pizza.setTotalPrice(pizza.getPriceWithoutToppings() + pizza.getCookingPrice());
        return true;
    }

}
