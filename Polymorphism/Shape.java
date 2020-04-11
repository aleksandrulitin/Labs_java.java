/**
 * An abstract class Shape.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Shape
{
    private int x, y; // x, y coordinates

    /**   
     * area: this method will be defined in subclasses of Shape.
     * @return the area of a shape
     */
     public abstract double area();
    
    /**
     * setCoords: sets the x and y coordinates 
     * @param an int, the x coordinate
     * @param an int, the y coordinate
     */
    public void setCoords(int xVal, int yVal)
    {
        this.x = xVal;
        this.y = yVal;
    }
    
    /**
     * toString:
     * @return a String holding the x and y coordinates formatted as (x, y)
     */
    public String toString()
    { 
        return "(" + this.x + ", " + this.y + ")";
    }
}
