package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Vendable {

	public Candy(String productCode, String productName, BigDecimal productPrice) {
		super(productCode, productName, productPrice, "Candy");
	}

	@Override
	public String getReaction() {
		return "Munch Munch, Yum!";
	}
}
