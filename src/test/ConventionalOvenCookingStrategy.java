package test;

public class ConventionalOvenCookingStrategy implements ICookingStrategy{
	private static final double COOKING_PRICE = 8.0;

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
