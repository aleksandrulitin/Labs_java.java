/** 
 * DrawFiguresUpdated draws figures, using multiple static(class) methods in the same class.
 *
 * @author DC
 * @version 2018 October 10
 */
public class DrawFiguresUpdated
{
    
    // Draw figures.
    public static void main (String[] args)
    {
        
        drawDiamond(); // calling a method drawDiamond defined in the same class
        
        System.out.println ();
        
        drawX(); // calling a method drawX defined in the same class
        
        System.out.println ();
        
        // Draw 2 rockets, by calling the same method twice. 
        // We are passing a String as a parameter to the drawRocket method.
        drawRocket_us("\n");
        drawRocket_ru("\n");
       
    } // end main

    // Draw a diamond.
    public static void drawDiamond()
    {
        drawCone();
        drawV(); 
    }
    
    // Draw an X.
    public static void drawX()
    {
        drawV();
        drawCone();
    }    
        
    // Draw a rocket.
    // Parameter: extra, a String storing something extra to print after drawing the rocket.
    public static void drawRocket_us(String extra)
    {
        drawCone();
        drawBox();
        System.out.println ("| US |");
        drawBox();
        drawCone();
        System.out.println(extra); // Print extra (a String received from calling method)
    }

    public static void drawRocket_ru(String extra)
    {
        drawCone();
        drawBox();
        System.out.println ("| RU |");
        drawBox();
        drawCone();
        System.out.println(extra); // Print extra (a String received from calling method)
    }
    
    // Draw a cone.
    public static void drawCone()
    {        
        System.out.println ("  /\\ ");
        System.out.println (" /  \\");
    }    
    
    // Draw a V.
    public static void drawV()
    {
        System.out.println (" \\  /");
        System.out.println ("  \\/ ");
    }    
    
    // Draw a box.
    public static void drawBox()
    {
        System.out.println ("+----+");
        System.out.println ("|    |");
        System.out.println ("|    |");
        System.out.println ("+----+"); 
    }
    
} // end DrawFigs
