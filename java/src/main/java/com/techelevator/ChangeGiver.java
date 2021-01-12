package com.techelevator;

import java.math.BigDecimal;

public class ChangeGiver {

	public void giveChange(BigDecimal change) {

		int nickel = 0;
		int dime = 0;
		int quarter = 0;

		while (change.compareTo(BigDecimal.valueOf(0.00)) == 1) {

			if (change.compareTo(BigDecimal.valueOf(0.25)) != -1) {
				quarter++;
				change = change.subtract(BigDecimal.valueOf(0.25));

			} else if (change.compareTo(BigDecimal.valueOf(0.10)) != -1) {
				dime++;
				change = change.subtract(BigDecimal.valueOf(0.10));

			} else if (change.compareTo(BigDecimal.valueOf(0.05)) != -1) {
				nickel++;
				change = change.subtract(BigDecimal.valueOf(0.05));

			} else {
				break;
			}
		}

		if (quarter > 1 && dime == 1 && nickel == 1) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarters, " + dime + " dime, and "
					+ nickel + " nickel.");

		} else if (quarter == 1 && dime == 1 && nickel == 1) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarter, " + dime + " dime, and "
					+ nickel + " nickel.");

		} else if (quarter > 1 && dime == 2 && nickel == 0) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarters and " + dime + " dimes.");

		} else if (quarter > 1 && dime == 1 && nickel == 0) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarters and " + dime + " dime.");

		} else if (quarter > 1 && dime == 0 && nickel == 1) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarters and " + nickel + " nickel.");

		} else if (quarter == 1 && dime == 2 && nickel == 0) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarter and " + dime + " dimes.");

		} else if (quarter == 1 && dime == 1 && nickel == 0) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarter and " + dime + " dime.");

		} else if (quarter == 1 && dime == 0 && nickel == 1) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarter and " + nickel + " nickel.");

		} else if (quarter == 0 && dime == 1 && nickel == 1) {
			System.out.println("\nHere is your change in coins: " + dime + " dime and " + nickel + " nickel.");

		} else if (quarter > 1 && dime == 0 && nickel == 0) {
			System.out.println("\nHere is your change in coins: " + quarter + " quarters.");

		} else if (quarter == 1 && dime == 0 && nickel == 0) {
			System.out.println("\nHere is your change: " + quarter + " quarter.");

		} else if (quarter == 0 && dime == 2 && nickel == 0) {
			System.out.println("\nHere is your change in coins: " + dime + " dimes.");

		} else if (quarter == 0 && dime == 1 && nickel == 0) {
			System.out.println("\nHere is your change: " + dime + " dime.");

		} else if (quarter == 0 && dime == 0 && nickel == 1) {
			System.out.println("\nHere is your change: " + nickel + " nickel.");
		}
	}
}
