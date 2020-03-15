package com.tavisca.beveragefactory.exceptions;

public class InvalidOrderException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidOrderException(){
		super("Invalid Menu Item passed");
	}
	
}
