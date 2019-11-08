package controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import service.CommercialData;
import utility.Utility;

public class Commercial {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		int ch;
		Utility u = new Utility();

		do {

			System.out.println("1.Create new Account");
			System.out.println("2.Buy Share");
			System.out.println("3.Sell  Share");
			System.out.println("4.print Net worth");
			System.out.println("5.Print  Report");
			System.out.println("6.Exit");
			System.out.println("Enter your choice");
			ch = Utility.readInt();
			switch (ch) {
			case 1:
				u.createAccount();
				break;

			case 2: {
				System.out.println("Enter Amount");
				int amount = Utility.readInt();
				System.out.println("Enter Symbol");
				String Symbol = Utility.readString();
				u.buy(amount, Symbol);

				break;
			}

			case 3: {
				System.out.println("Enter Amount");
				int amount = Utility.readInt();
				System.out.println("Enter Symbol");
				String Symbol = Utility.readString();
				u.sell(amount, Symbol);

				break;
			}

			case 4:
				System.out.println("$ " + u.valueOf());
				break;
			case 5:
				u.printReport();
				break;
			case 6:
				System.out.println("Existing ");
				System.exit(0);
				break;

			default:

				System.out.println("invalid Options");

			}
		} while (ch != 6);

	}

}