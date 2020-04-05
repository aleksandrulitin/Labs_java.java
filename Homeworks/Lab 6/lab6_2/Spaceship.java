/**
 * Blueprint class.  A Spaceship has x and y coordinates,a name and a captain.
 * 
 * @author Dr. Chays 
 * @version 2018 October 17 (to be revised)
 */
public class Spaceship
{    
    // attributes = instance data = state variables = properties = characteristics
    private int x, y;
    private String name, captain;

    // Constructor initializes an object/instance of Spaceship by initializing all attributes.
    public Spaceship(int theX, int theY, 
                     String theName, String theCaptain)
    {
        // Initialize attributes.
        this.x = theX;
        this.y = theY;
        this.name = theName;
        this.captain = theCaptain;
        // Note: "this." is optional but makes the code more readable 
        // by saying here that x, y, name, captain are attributes as opposed to some other kind of variable. 
    }
    
    // toString: returns a String representation of this Spaceship, that includes the values of all its attributes.
    public String toString ()
    {
        String result;
        result = "A Spaceship named " + this.name + 
                 " is at coordinate (" + this.x + ", " + this.y + ").\n" + 
                 "The captain is " + this.captain + ".\n";
        return result;
    }
    
    // Accessor for captain.
    public String getCaptain ()
    {
        return this.captain;
    }
    
    // Mutator for captain.
    public void setCaptain (String theNewCaptain)
    {
        //if (theNewCaptain.length() > 0)
        this.captain = theNewCaptain;    
    }
    
} // end class Spaceship
