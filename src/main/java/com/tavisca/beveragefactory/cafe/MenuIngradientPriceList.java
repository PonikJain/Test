package com.tavisca.beveragefactory.cafe;

import java.util.HashMap;
import java.util.Map;

import com.tavisca.beveragefactory.exceptions.InvalidIngredientException;

public class MenuIngradientPriceList implements Cloneable {

	private static MenuIngradientPriceList ingrgPriceList = null;

	private Map<String, Double> ingrgPriceMap = new HashMap<>();

	private static final Object lock = new Object();

	private MenuIngradientPriceList() {
		ingrgPriceMap.put("milk", 1.0);
		ingrgPriceMap.put("sugar", 0.5);
		ingrgPriceMap.put("soda", 0.5);
		ingrgPriceMap.put("mint", 0.5);
		ingrgPriceMap.put("water", 0.5);
	}

	public static MenuIngradientPriceList getPriceList() {
		synchronized (lock) {
			if (ingrgPriceList == null) {
				ingrgPriceList = new MenuIngradientPriceList();
			}
		}
		return ingrgPriceList;

	}

	public double getPrice(String ingd) throws InvalidIngredientException {
		Double price = null;
		if (ingd != null) {
			 price = this.ingrgPriceMap.get(ingd);
		} 
		
		if(price == null){
			throw new InvalidIngredientException();
		}
		return 0;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
