package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

	@Test
	public void check_that_b2_is_cowtales() {

		Candy candy = new Candy("B2", "Cowtales", new BigDecimal(1.50));
		
		String expected = "Cowtales";
		String actual = candy.getProductName();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void check_candy_reaction() {

		Candy candy = new Candy("B4", "Crunchie", new BigDecimal(1.75));
		
		String expected = "Munch Munch, Yum!";
		String actual = candy.getReaction();
		
		Assert.assertEquals(expected, actual);
	}

}
