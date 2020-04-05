

public class TempConverter
{
   //-----------------------------------------------------------------
   //  Computes the Fahrenheit equivalent of a specific Celsius
   //  value using the formula F = (9/5)C + 32.
   //-----------------------------------------------------------------
   public static void main (final String[] args) {
        // Declare variables.
        double fahrenheitTemp;
        final double CONVERSION_FACTOR = 1.8;
        final double BASE = 32; 
        final int celsiusTemp = 5; // value to convert


      // Compute temperature in fahrenheit.
      fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;

      // Print equivalent temperatures in celsius and fahrenheit.
      System.out.println ("Celsius Temperature: " + celsiusTemp);
      System.out.println ("Fahrenheit Equivalent: " + fahrenheitTemp);
   } // end main

} // end TempConverter