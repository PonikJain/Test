package com.tavisca.beveragefactory;

import java.util.HashMap;
import java.util.Map;

public class BeverageFactoryMain {

	private static final Map<String, Double> menu = new HashMap<>();

	private static final Map<String, Double> ingredients = new HashMap<>();

	static {
		menu.put("Coffee", 5.0);
		menu.put("Chai", 4.0);
		menu.put("Banana Smoothie", 6.0);
		menu.put("Strawberry Shake", 7.0);
		menu.put("Mojito", 7.5);

		ingredients.put("milk", 1.0);
		ingredients.put("sugar", 0.5);
		ingredients.put("soda", 0.5);
		ingredients.put("mint", 0.5);
		ingredients.put("water", 0.5);

	}
	
	public static double getBillAmount(String[] orders) {
		double billAmount = 0;
		
		for (String order : orders) {
			String [] detailedOrder = order.split(",");
			 billAmount += menu.get(detailedOrder[0]);
			if(detailedOrder.length >  1) {
				for (int i = 1 ; i < detailedOrder.length;i++) {
					Double ingdPrice = ingredients.get(detailedOrder[i].replace("-",""));
					billAmount -= ingdPrice;
				}
			}
		}
		
		return billAmount;
	}

	public static void main(String[] args) {}

}
