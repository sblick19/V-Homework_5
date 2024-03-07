package ICookingStrategy;

import test.AbstractPizza;

public abstract class ClassicOvenCookingStrategy implements iCookingStrategy{
	  public boolean cook(AbstractPizza pizza) {
	        pizza.setCookingStrategy(this);
	        pizza.setCookingPrice(8.0);
	        pizza.setTotalPrice(pizza.getPriceWithoutToppings() + pizza.getCookingPrice());
	        return true;
	    }

}
