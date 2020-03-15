package com.tavisca.beveragefactory.cafe;

import java.util.HashMap;
import java.util.Map;

import com.tavisca.beveragefactory.exceptions.InvalidOrderException;

public class CafeMenu implements Cloneable {

	private static CafeMenu cafeMenu = null;

	private Map<String, Double> beverages = new HashMap<>();

	private static final Object lock = new Object();

	private CafeMenu() {
		beverages.put("Coffee", 5.0);
		beverages.put("Chai", 4.0);
		beverages.put("Banana Smoothie", 6.0);
		beverages.put("Strawberry Shake", 7.0);
		beverages.put("Mojito", 7.5);

	}

	public static CafeMenu getMenu() {
		synchronized (lock) {
			if (cafeMenu == null) {
				cafeMenu = new CafeMenu();
			}
		}
		return cafeMenu;

	}
	
	public double getBeveragePrice(String beverage) throws InvalidOrderException {
		Double price = null;
		if(beverage != null) {
		 price =  this.beverages.get(beverage);
		}
		
		if(price == null) { 
			throw new InvalidOrderException();
		}
		return price;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
