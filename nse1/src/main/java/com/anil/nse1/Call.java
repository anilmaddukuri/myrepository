package com.anil.nse1;

public class Call {
	
	private int strike;
	private double initalPrice;
	private boolean isSold = false;

	public Call(int strike, double initialPrice, boolean isSold) {
		this.strike = strike;
		this.initalPrice = initialPrice;
		this.isSold = isSold;
	}
	
	public double evaluate(double finalPrice) {
		if(this.isSold) {
			// call is initially sold. so the final price indicates the bought price.
			// so you will make profit only if final price < initial price
			return (this.initalPrice - finalPrice);
		} else {
			// call is initially bought. so the final price indicates the selling price
			// so you will make profit only if final price > initial price.
			return (finalPrice - this.initalPrice);
		}
	}
}
