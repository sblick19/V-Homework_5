package test;

import java.util.ArrayList;
import java.util.List;

public class VegetarianPizza extends AbstractPizza{
	
	public VegetarianPizza() {
		//TOMATO, CHEESE, BELL_PEPPER, BLACK_OLIVE, MUSHROOM
		super.toppingList = new ArrayList<Toppings>();
		super.toppingList.add(Toppings.TOMATO);
		super.toppingList.add(Toppings.CHEESE);
		super.toppingList.add(Toppings.BELL_PEPPER);
		super.toppingList.add(Toppings.BLACK_OLIVE);
		super.toppingList.add(Toppings.MUSHROOM);
		super.priceWithoutToppings = 1.50;
		super.totalPrice = 1.50;
		super.cookingPrice = 0;
		super.cookingStrategy = CookingStyleType.CONVENTIONAL_OVEN; //Causes error because of error in AbstractPizza
	}
}