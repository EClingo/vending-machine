package com.techelevator;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {

	public void feedBalanceLog(BigDecimal balance, String depositAmount) {
		try (Logger log = new Logger("Log.txt")) {

			DecimalFormat formatBD = new DecimalFormat("##0.00");
			BigDecimal feedBalance = balance.add(new BigDecimal(depositAmount));
			BigDecimal feedDeposit = new BigDecimal(depositAmount);

			log.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a ")) + "FEED MONEY:"
					+ " $" + formatBD.format(feedDeposit) + " $" + formatBD.format(feedBalance));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void productOptionLog(BigDecimal balance, Vendable item) {
		try (Logger log = new Logger("Log.txt")) {

			DecimalFormat formatBD = new DecimalFormat("##0.00");
			BigDecimal logBalanceAfterPurchase = balance.subtract(item.getProductPrice());

			log.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a "))
					+ item.getProductName() + " " + item.getProductCode() + " $" + formatBD.format(balance) + " $"
					+ formatBD.format(logBalanceAfterPurchase));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void finishTransactionLog(BigDecimal balance) {
		try (Logger log = new Logger("Log.txt")) {

			DecimalFormat formatBD = new DecimalFormat("##0.00");

			log.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a ")) + "GIVE CHANGE:"
					+ " $" + formatBD.format(balance) + " $0.00");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
