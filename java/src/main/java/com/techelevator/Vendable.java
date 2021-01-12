package com.techelevator;

import java.math.BigDecimal;

public abstract class Vendable {

	private String productCode;
	private String productName;
	private BigDecimal productPrice;
	private String productType;
	private int productQuantity = 5;

	public Vendable(String productCode, String productName, BigDecimal productPrice, String productType) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
	}

	public static Vendable determineProductType(String productCode, String productName, BigDecimal productPrice,
			String productType) {

		if (productType.equalsIgnoreCase("Chip")) {
			return new Chip(productCode, productName, productPrice);

		} else if (productType.equalsIgnoreCase("Candy")) {
			return new Candy(productCode, productName, productPrice);

		} else if (productType.equalsIgnoreCase("Drink")) {
			return new Drink(productCode, productName, productPrice);

		} else {
			return new Gum(productCode, productName, productPrice);
		}
	}

	public String getReaction() {
		return getReaction();
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPriceString) {
		BigDecimal productPrice = new BigDecimal(productPriceString);
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void purchase() {
		productQuantity--;
	}
}
