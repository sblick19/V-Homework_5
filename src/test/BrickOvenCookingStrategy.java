package test;

public class BrickOvenCookingStrategy implements ICookingStrategy {
	private static final double COOKING_PRICE = 10.0;

    @Override
    public boolean cook(AbstractPizza pizza) {
        if (pizza != null) {
            pizza.setCookingPrice(COOKING_PRICE);
            pizza.setCookingStrategy(this);
            pizza.updatePizzaPrice();
            return true;
        }
        return false;
    }

}
