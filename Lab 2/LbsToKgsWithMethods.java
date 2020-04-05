/**
 * LbsToKgsWithMethods converts a weight in pounds to a weight in kilograms.
 */

import java.text.DecimalFormat;

import Lab1.ChangeCounter;

public class LbsToKgsWithMethods
{
   /**
    * Input (from the user): weight in pounds.
    * Output (to the screen): weight in kilograms.
    * Assumptions: The user will enter valid input, i.e. a positive value for pounds.
    */
   public static void main (final String[] args) {
      // Declare variables
      double lbs, kgs;

      // Read the weight in pounds from the user.
      lbs = ChangeCounter.readLbs();

      // Calculate the weight in kilograms.
      kgs = convertToKgs(lbs);

      // Print the weight in pounds and kilograms.
      printWeight(lbs, kgs);
   } // end main

   // convertToKgs receives a weight in lbs (of type double) and returns the
   // equivalent weight in kgs (of type double).
   public static double convertToKgs(final double pounds) {
      // Declare constant
      final double LBS_PER_KG = 2.2;

      final double result = pounds / LBS_PER_KG;

      return result;
   } // end convertToKgs

   // Print the specified weights in pounds and kilograms, both of type double.
   public static void printWeight(final double lbs, final double kgs) {
      // Round the output to three decimal places
      final DecimalFormat fmt = new DecimalFormat("0.###");
      
      System.out.println("The given weight in pounds is " + fmt.format (lbs));
      System.out.println("The equivalent weight in kilograms is " + fmt.format (kgs));
   } // end printWeight


   
} // end LbsToKgsWithMethods