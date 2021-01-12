package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Vendable {

	public Gum(String productCode, String productName, BigDecimal productPrice) {
		super(productCode, productName, productPrice, "Gum");
	}

	@Override
	public String getReaction() {
		return "Chew Chew, Yum!";
	}
}
