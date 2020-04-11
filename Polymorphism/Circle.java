/**
 * A Circle with a radius, and a method to compute area.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Shape
{
    // Instance data
    private double radius;
    
    /**
     * Constructor: initialize radius.
     */
    public Circle(int x, int y, double r)
    {
       super.setCoords(x, y);
       this.radius = r;
    }

    
    /**
     * area: compute area of a circle.
     * @return a double, the area of a circle.
     */
    public double area()
    {
       return (Math.PI * Math.pow(this.radius, 2));   
    }
}
