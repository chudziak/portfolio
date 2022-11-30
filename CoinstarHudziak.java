/*
  * CoinstarHudziak.java
  * @description Class that acts as a Coinstar machine
  * @version 1.0, 2021-09-22
  * @author Connor Hudziak
*/

//Ref: starter document from Professor Zelenberg from moodle on 9/15

import java.util.Scanner;

// ref: Math.round()
// https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/Math.html#round(float)

public class CoinstarHudziak{

	//attributes
	private int totalQuarters, totalDimes, totalNickels, totalPennies;
	private double totalValue, totalBitcoin;
	private int totalCents, totalHundreds, totalFifties, totalTwenties, totalTens, totalOnes, decison1;
	private Scanner input;

	//methods

	//-------------------------------------------
	// Constructor
	//-------------------------------------------
	public CoinstarHudziak(){
		input = new Scanner(System.in);

		totalQuarters = 0;
		totalDimes = 0;
		totalNickels = 0;
		totalPennies = 0;

		totalValue = 0;
	}

	//-------------------------------------------
	// prompts user to give total coinage
	//-------------------------------------------
	public void intake(){
		System.out.println("Enter the total number of quarters: ");
		totalQuarters = input.nextInt();
		System.out.println("You entered " + totalQuarters + " quarters.");

		System.out.println("Enter the total number of dimes: ");
		totalDimes = input.nextInt();
		System.out.println("You entered " + totalDimes + " dimes.");

		System.out.println("Enter the total number of nickels: ");
		totalNickels = input.nextInt();
		System.out.println("You entered " + totalNickels + " nickels.");

		System.out.println("Enter the total number of pennies: ");
		totalPennies = input.nextInt();
		System.out.println("You entered " + totalPennies + " pennies.");
	}
	//-------------------------------------------
	// Creates total value
	//-------------------------------------------
	public void totalValue(){
		totalQuarters = totalQuarters * 25;
		totalDimes = totalDimes * 10;
	 	totalNickels = totalNickels * 5;
		totalPennies = totalPennies * 1;
		totalValue = totalQuarters + totalDimes + totalNickels + totalPennies;
		totalValue = totalValue /100.0;
		System.out.println("Your total is " + totalValue);

	}




	//-------------------------------------------
	// returns the total number of bills in cash
	//-------------------------------------------
	public void cash(){
		System.out.println("You have " + totalValue);
		// deduct 10% from totalValue
		double deducted = Math.round(totalValue * 10.0) / 100.0;
		totalValue = Math.round((totalValue - deducted)*100.0) / 100.0;

		System.out.println("You will get " + totalValue); //check
		// print numbers of bills
		System.out.println(deducted + " Was deducted as a service fee.");
		int cents = (int) Math.round( totalValue * 100); // total amount in cents


		totalHundreds = cents / 10000;
		cents = cents % 10000; //gives remainder after division
		System.out.println(totalHundreds + " Hundreds"); // check

		totalFifties = cents / 5000;
		cents = cents % 5000; //gives remainder after division
		System.out.println(totalFifties + " Fifties"); // check

		totalTwenties = cents / 2000;
		cents = cents % 2000; //gives remainder after division
		System.out.println(totalTwenties + " Twenties"); // check

		totalTens = cents / 1000;
		cents = cents % 1000;
		System.out.println(totalTens + " Tens"); // check

		totalOnes = cents / 100;
		cents = cents % 100; //gives remainder after division
		System.out.println(totalOnes + " Ones"); // check

		totalQuarters = cents / 25;
		cents = cents % 25; //gives remainder after division
		System.out.println(totalQuarters + " Quarters"); // check

		totalDimes = cents / 10;
		cents = cents % 10; //gives remainder after division
		System.out.println(totalDimes + " Dimes"); // check

		totalNickels = cents / 5;
		cents = cents % 5; //gives remainder after division
		System.out.println(totalNickels + " Nickels"); // check

		totalPennies = cents / 1;
		cents = cents % 1; //gives remainder after division
		System.out.println(totalPennies + " Pennies"); // check
	}
	//-------------------------------------------
	// returns a gift card in normal amount
	//-------------------------------------------
	public void giftCard(){
		System.out.println("You will now be issued a gift card in the amount of " + totalValue);
	}

	//-------------------------------------------
	// returns bitcoin
	//-------------------------------------------
	public void bitcoin(){
		totalBitcoin = (totalValue / 45735.10);
		System.out.println("You now have " + totalBitcoin + " Bitcoin");
	}

	//-------------------------------------------
	// Asks the user which method they want to receive
	//-------------------------------------------
	public void cashOut(){
		System.out.println("How would you like payment? Type 1 for Cash, 2 for Gift Card, or 3 for Bitcoin?");
		decison1 = input.nextInt();
		if (decison1 == 1)
			cash();
		if (decison1 == 2)
			giftCard();
		if (decison1 == 3)
			bitcoin();
		}
}
