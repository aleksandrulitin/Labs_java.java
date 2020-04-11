/**
 * Demonstrate polymorphism.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PolymorphismDemo
{
    /**
     * main: passes a Shape (which can be a Rectangle or Circle) to a method displayArea.
     */
    public static void main(String[] args)
    {  
       Circle c = new Circle (0, 0, 5);
       double areaOfCircle = computeArea (c);
       System.out.println ("The circle's area is: " + areaOfCircle);
     
       Rectangle r = new Rectangle (10, 10, 3, 4);
       double areaOfRectangle = computeArea (r);
       System.out.println ("The rectangle's area is: " + areaOfRectangle);
       
       System.out.println ("The circle's coordinates are: " + c.toString() );
       System.out.println ("The rectangle's coordinates are: " + r.toString() );

        if (c instanceof Shape) {}
    }

    /**
     * displayArea: computes the area of a given Shape.
     * @param a Shape
     * @return a double, the area of the given Shape
     */
    public static double computeArea (Shape s)
    {
        return s.area();   
    }
}
