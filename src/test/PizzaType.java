package test;

public enum PizzaType {

    HAWAIIAN, 
    MARGHERITA, 
    SUPREME, 
    VEGATARIAN;

    private final double toppingPrice;

    PizzaType(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }
}


