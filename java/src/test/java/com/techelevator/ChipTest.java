package com.techelevator;

import java.math.BigDecimal;

import org.junit.Test;

import org.junit.Assert;


public class ChipTest {

	@Test
	public void check_that_a1_is_potato_crisps() {

		Chip chip = new Chip("A1", "Potato Crisps", new BigDecimal(3.05));
		
		String expected = "A1";
		String actual = chip.getProductCode();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void check_chip_reaction() {

		Chip chip = new Chip("A3", "Grain Waves", new BigDecimal(2.75));
		
		String expected = "Crunch Crunch, Yum!";
		String actual = chip.getReaction();
		
		Assert.assertEquals(expected, actual);
	}

}
