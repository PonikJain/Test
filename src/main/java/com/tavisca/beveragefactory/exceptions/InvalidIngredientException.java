package com.tavisca.beveragefactory.exceptions;

public class InvalidIngredientException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidIngredientException(){
		super("Invalid Menu Item passed");
	}
	
}
