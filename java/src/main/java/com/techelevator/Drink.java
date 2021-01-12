package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Vendable {

	public Drink(String productCode, String productName, BigDecimal productPrice) {
		super(productCode, productName, productPrice, "Drink");
	}

	@Override
	public String getReaction() {
		return "Glug Glug, Yum!";
	}
}
