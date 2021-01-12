package com.techelevator;

import java.awt.Menu;
import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineCLITest {

	Menu test = new Menu();
	VendingMachineCLI tester = new VendingMachineCLI(null);

	@Test
	public void check_that_file_exists() throws FileNotFoundException {

		File test = new File("vendingmachine.csv");
		
		
		boolean expected = true;
		boolean actual = test.exists();

		Assert.assertEquals(expected, actual);

	}
}
