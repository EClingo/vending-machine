package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {

	@Test
	public void check_that_little_league_chew_is_one_dollar_and_ninety_five_cents() {

		Gum gum = new Gum("D2", "Little League Chew", new BigDecimal(0.95));
		
		BigDecimal expected = new BigDecimal(0.95);
		BigDecimal actual = gum.getProductPrice();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void check_gum_reaction() {

		Gum gum = new Gum("D4", "Triplemint", new BigDecimal(0.75));
		
		String expected = "Chew Chew, Yum!";
		String actual = gum.getReaction();
		
		Assert.assertEquals(expected, actual);
	}
}
