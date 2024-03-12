package test;

import java.util.ArrayList;
import java.util.List;

public class VegetarianPizza extends AbstractPizza{
	
	public VegetarianPizza() {
		//TOMATO, CHEESE, BELL_PEPPER, BLACK_OLIVE, MUSHROOM
		super();
		this.toppingList = new ArrayList<Toppings>();
		this.toppingList.add(Toppings.TOMATO);
		this.toppingList.add(Toppings.CHEESE);
		this.toppingList.add(Toppings.BELL_PEPPER);
		this.toppingList.add(Toppings.BLACK_OLIVE);
		this.toppingList.add(Toppings.MUSHROOM);
		this.priceWithoutToppings = 1.50;
		this.totalPrice = 1.50;
		this.cookingPrice = 0;
		this.cookingStrategy = CookingStyleType.CONVENTIONAL_OVEN; //Causes error because of error in AbstractPizza
	}
	
	public VegetarianPizza(VegetarianPizza other) {
		super();
		this.toppingList = new ArrayList<Toppings>();
		this.toppingList = other.getToppingList();
		this.priceWithoutToppings = other.getPriceWithoutToppings();
		this.totalPrice = other.getTotalPrice();
		this.cookingPrice = other.getCookingPrice();
		this.cookingStrategy = other.getCookingStyleType(); //Causes error because of error in AbstractPizza
	}
	
	public String toString() {
		return("Price without toppings: "+this.priceWithoutToppings+
				", Total Price: "+this.totalPrice+
				", Cooking Price: "+this.cookingPrice+
				", Cooking Strategy: "+this.cookingStrategy+
				", Toppings: "+this.toppingList);
	}
	
}