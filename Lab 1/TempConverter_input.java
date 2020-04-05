

import java.util.Scanner;

public class TempConverter_input
{
   //-----------------------------------------------------------------
   //  Computes the Fahrenheit equivalent of a specific Celsius
   //  value using the formula F = (9/5)C + 32.
   //-----------------------------------------------------------------
   public static void main (final String[] args) {

         Scanner scan = new Scanner(System.in);
        // Declare variables.
        double fahrenheitTemp;
        final double CONVERSION_FACTOR = 1.8;
        final double BASE = 32;
        System.out.print("Enter a celius temprature: ");
        final int celsiusTemp = scan.nextInt(); // value to convert


      // Compute temperature in fahrenheit.
      fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;

      // Print equivalent temperatures in celsius and fahrenheit.
      System.out.println ("Celsius Temperature: " + celsiusTemp);
      System.out.println ("Fahrenheit Equivalent: " + fahrenheitTemp);
      scan.close();
   } // end main

} // end TempConverter