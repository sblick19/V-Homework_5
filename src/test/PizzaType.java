package test;

public enum PizzaType {
	HAWAIIAN,
    MARGHERITA,
    SUPREME,
    VEGETARIAN;

    private double toppingPrice;

    PizzaType() {
    }

    PizzaType(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }
}
