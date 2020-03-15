package com.tavisca.beveragefactory;

import com.tavisca.beveragefactory.cafe.CafeMenu;
import com.tavisca.beveragefactory.cafe.MenuIngradientPriceList;
import com.tavisca.beveragefactory.exceptions.InvalidIngredientException;
import com.tavisca.beveragefactory.exceptions.InvalidOrderException;

public class BeverageFactoryMain {

	public static double getBillAmount(String[] orders) {
		double billAmount = 0;

		for (String order : orders) {
			String[] detailedOrder = order.split(",");
			try {
				billAmount += CafeMenu.getMenu().getBeveragePrice(detailedOrder[0]);

				if (detailedOrder.length > 1) {
					for (int i = 1; i < detailedOrder.length; i++) {
						Double ingdPrice = 0.0;
						try {
							ingdPrice = MenuIngradientPriceList.getPriceList()
									.getPrice(detailedOrder[i].replace("-", ""));
						} catch (InvalidIngredientException e) {
							System.out.println("Invalid Ingredient so this ingredient will not be excluded");
						}
						billAmount -= ingdPrice;
					}
				}
			} catch (InvalidOrderException e) {
				System.out.println("Invalid Order so this order will be excluded");
			}
		}

		return billAmount;
	}


}
