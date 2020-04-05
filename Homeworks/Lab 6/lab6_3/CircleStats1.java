/**
 * CircleStats calculates the area and circumference of a circle, given its radius.
 */

import java.util.Scanner;

public class CircleStats1
{
   /**
    * Input (from the user): radius
    * Output (to the screen): area and circumference of a circle with the given radius
    */
   public static void main (String[] args)
   {
      // Declare variables
      double radius, area, circumference;
   
      // Set up Scanner object
      Scanner keyboard = new Scanner (System.in);

      // Input a radius from the user.
      System.out.print ("Enter the radius of a circle: ");
      radius = keyboard.nextDouble ();
      
      // Create a Circle object (circ) with the given radius. 
      Circle circ = new Circle (radius);
      
      // Calculate the area and circumference by invoking the appropriate methods on circ.
      area = circ.computeArea();
      circumference = circ.computeCircumference();
      
      // Print the area and circumference of the circle with the given radius.
      System.out.println ("A circle with a radius of " + radius +
                          " has an area of " + area +
                          " and a circumference of " + circumference);
   } // end main
   
} // end CircleStats

