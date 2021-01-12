package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private Menu menu;
	private BigDecimal balance = new BigDecimal(0.00);
	private ChangeGiver changeGiver = new ChangeGiver();
	private LogWriter logWriter = new LogWriter();

	private List<Vendable> products = new ArrayList<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {

		File vendingMachineFile = new File("vendingmachine.csv");
		Scanner fileScanner = new Scanner(vendingMachineFile);
		Scanner userInput = new Scanner(System.in);

		while (fileScanner.hasNextLine()) {
			String inventoryLine = fileScanner.nextLine();
			String[] inventoryArray = inventoryLine.split("\\|");

			BigDecimal productPrice = new BigDecimal(inventoryArray[2]);
			products.add(Vendable.determineProductType(inventoryArray[0], inventoryArray[1], productPrice,
					inventoryArray[3]));
		}

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println("\nCODE : PRODUCT              : PRICE    : # REMAINING");

				for (Vendable item : products) {
					System.out.println(String.format("%-4s", item.getProductCode()) + " : "
							+ String.format("%-20s", item.getProductName()) + " : "
							+ String.format("$%.2f", item.getProductPrice()) + "    : " + item.getProductQuantity());
				}

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				boolean purchase = false;

				while (!purchase) {
					System.out.println("\nCurrent Money Provided: $" + balance);
					String purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						System.out.print("\nPlease enter only $1, $2, $5, or $10 at a time >>>\n$");
						String depositAmount = userInput.nextLine();

						if (depositAmount.equals("1") || depositAmount.equals("2") || depositAmount.equals("5")
								|| depositAmount.equals("10")) {

							logWriter.feedBalanceLog(balance, depositAmount);

							balance = balance.add(new BigDecimal(depositAmount));

						} else {
							System.out.println("\nThat is an unacceptable amount!");
						}

					} else if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_PRODUCT)) {
						System.out.println("\nPlease enter the code of desired product >>>");
						String purchaseInput = userInput.nextLine();

						boolean validProductCode = false;

						for (Vendable item : products) {

							if (item.getProductCode().equalsIgnoreCase(purchaseInput)) {
								validProductCode = true;
							}
						}

						if (!validProductCode) {
							System.out.println("\nNot a valid code!");
							continue;
						}

						for (Vendable item : products) {

							if (purchaseInput.equalsIgnoreCase(item.getProductCode())
									&& balance.compareTo(item.getProductPrice()) == -1) {
								System.out.println("\nYou need to feed more money to buy that product!");
								break;
							}

							if (purchaseInput.equalsIgnoreCase(item.getProductCode())
									&& item.getProductQuantity() > 0) {

								logWriter.productOptionLog(balance, item);

								item.purchase();
								System.out.println("\nYou purchased " + item.getProductName() + " at a cost of $"
										+ item.getProductPrice() + ".");
								System.out.println(item.getReaction());

								balance = balance.subtract(item.getProductPrice());
								break;

							} else if (purchaseInput.equalsIgnoreCase(item.getProductCode())
									&& item.getProductQuantity() == 0) {
								System.out.println("\nThat product is SOLD OUT.");
								break;
							}
						}

					} else {
						logWriter.finishTransactionLog(balance);
						changeGiver.giveChange(balance);

						purchase = true;
						balance = new BigDecimal(0.00);
					}
				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("\nThanks for using our vending machine!");

				userInput.close();
				fileScanner.close();
				System.exit(1);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("\nHello and welcome to our...\n");
		System.out.println("|***************************************|");
		System.out.println("|***************************************|");
		System.out.println("|*********** Vending Machine ***********|");
		System.out.println("|************ Capstone v1.0 ************|");
		System.out.println("|***************************************|");
		System.out.println("|***************************************|");
		System.out.println("\nCo-Developed by Eric Clingo and Brandon Wakefield\n");

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();
	}
}
