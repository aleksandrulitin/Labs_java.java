/**
 * Driver class = main class
 * 
 * @author Dr. Chays, revised by ...
 * @version 2018 October 17 (to be revised)
 */
public class StarTrek
{
    public static void main (String[] args) {
        // Create a spaceship.
        Spaceship enterprise = new Spaceship (40, 50, "Enterprise", "Kirk"); 
        // enterprise is an object of type Spaceship, i.e. enterprise is an instance of the Spaceship class.
        
        // Print enterprise's data.
        System.out.println (enterprise.toString()); // OR System.out.println (enterprise);
        
        // Change captain to Picard.
        enterprise.setCaptain ("Picard");
        
        // Print new captain.
        System.out.println("The new captain is " + enterprise.getCaptain());

        Spaceship falcon = new Spaceship(50, 34, "Millennium falcon", "Han Solo");
        System.out.println(falcon.toString());
    } // end main
} // end class
