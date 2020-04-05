

import java.util.Scanner;

public class ForceConverter
{
    public static void main (final String[] args)
    {

        Scanner scan = new Scanner(System.in);
       // Declare variables.
       double newtons;
       final double CONVERSION_FACTOR = 4.44822162;
       System.out.print("Enter a pound-force : ");
       final int pound_force = scan.nextInt(); // value to convert


     // Compute temperature in fahrenheit.
     newtons = pound_force * CONVERSION_FACTOR;

     // Print result
     System.out.println ("Pound-force: " + pound_force);
     System.out.println ("Fahrenheit Equivalent: " + newtons);

     scan.close();
  } // end main

} // end TempConverter


