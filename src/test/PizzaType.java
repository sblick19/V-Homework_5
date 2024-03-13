package test;

public enum PizzaType {

    HAWAIIAN, 
    MARGHERITA, 
    SUPREME, 
    VEGETARIAN;

    private final double toppingPrice;

    PizzaType(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }
}


