//********************************************************************
//  Circle.java       Author: 
//
//  Represents one circle with a radius.
//********************************************************************

public class Circle
{
   private final double PI = 3.14;  

   private double radius; 

   //-----------------------------------------------------------------
   //  Constructor: Sets the initial radius.
   //-----------------------------------------------------------------
   public Circle(double radiusVal)
   {
      this.radius = radiusVal;  // "this." is optional but makes the code more readable by saying here that radius is a state variable (a.k.a. attribute) as opposed to some other kind of variable.
   } // end of constructor

   //-----------------------------------------------------------------
   //  Compute the area and return the result.
   //-----------------------------------------------------------------
   public double computeArea()
   {
      double result;

      result = PI * (radius * radius);
      
      return result;
   } // end of method computeArea()

   //-----------------------------------------------------------------
   //  Compute the circumference and return the result.
   //-----------------------------------------------------------------
   public double computeCircumference()
   {
      double result;

      result = 2 *PI * radius;
      
      return result;
   } // end of method computeCircumference()
   
} // end of class Circle
