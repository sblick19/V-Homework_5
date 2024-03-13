package ICookingStrategy;

import test.AbstractPizza;

public abstract class MicrowaveCookingStrategy implements iCookingStrategy{
	  public boolean cook(AbstractPizza pizza) {
	        pizza.setCookingStrategy(this);
	        pizza.setCookingPrice(1.0);
	        pizza.setTotalPrice(pizza.getPriceWithoutToppings() + pizza.getCookingPrice());
	        return true;
	    }

}
