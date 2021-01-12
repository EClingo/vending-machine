package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Vendable {

	public Chip(String productCode, String productName, BigDecimal productPrice) {
		super(productCode, productName, productPrice, "Chip");
	}

	@Override
	public String getReaction() {
		return "Crunch Crunch, Yum!";
	}
}
