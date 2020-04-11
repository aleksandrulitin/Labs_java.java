/**
 * A Rectangle with a length and width, and a method to compute area.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Shape
{
    // Instance data
    private double length, width;
    
    /**
     * Constructor: initialize length and width
     */
    public Rectangle(int x, int y, double l, double w)
    {
       super.setCoords(x, y);
       this.length = l;
       this.width = w;
    }

    /**
     * area: compute area of a rectangle.
     * @return a double, the area of a rectangle
     */
     @Override
     public double area()
     {
        return this.length * this.width;   
     }
}
