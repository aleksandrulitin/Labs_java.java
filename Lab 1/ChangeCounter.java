

import java.util.Scanner;

public class ChangeCounter

{
    public static void main(String[]ags) 
    
    {
        Scanner scan = new Scanner(System.in);

        //Define variable
        double quarters, dimes, nickels, pennies, sum, result;

        //Define constant
        final int value_quarters, value_dimes, value_nickels, value_dollar;

        //Value of coins
        value_quarters = 25;
        value_dimes = 10;
        value_nickels =5;
        value_dollar = 100;

        //Input coins
        System.out.println("Enter a number of quarters:  ");
        quarters = scan.nextDouble();
        System.out.println("Enter a number of dimes:  ");
        dimes = scan.nextDouble();
        System.out.println("Enter a number of nickels:  ");
        nickels = scan.nextDouble();
        System.out.println("Enter a number of pennies:  ");
        pennies = scan.nextDouble();

        //main

        //Compute coins to the dollars
        sum = (quarters * value_quarters) + (dimes * value_dimes) + (nickels * value_nickels) + pennies;

        result = sum / value_dollar;

        //print the result
        System.out.println("Total value:  " + result);  

        scan.close();

        //end of main
    }

	// Read the weight in pounds from the user, and return it (data type: double).
	   public static double readLbs() {
	      // Set up Scanner object
	      final Scanner scan = new Scanner(System.in);
	      
	
	      System.out.print("Enter a weight in pounds: ");
	      final double lbs = scan.nextDouble();
	
	      scan.close();
	
	      return lbs;
	
	   } // end readLbs
}