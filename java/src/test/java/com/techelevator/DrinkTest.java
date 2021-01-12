package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {

	@Test
	public void check_that_cola_cost_is_one_dollar_and_twenty_five_cents() {

		Drink drink = new Drink("C1", "Cola", new BigDecimal(1.25));
		
		BigDecimal expected = new BigDecimal(1.25);
		BigDecimal actual = drink.getProductPrice();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void check_drink_reaction() {

		Drink drink = new Drink("C3", "Mountain Melter", new BigDecimal(1.50));
		
		String expected = "Glug Glug, Yum!";
		String actual = drink.getReaction();
		
		Assert.assertEquals(expected, actual);
	}
}
