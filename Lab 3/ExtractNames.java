
import java.util.Scanner;

public class ExtractNames
{
    // Extract (and print to standard output) the first and last names in "Last, First" (read from standard input).
    public static void main(final String[] args)
    {
        Scanner scan = new Scanner (System.in);
   

        System.out.println ("Enter your full name as Last, First");
        String fullName = scan.nextLine ();
        
  
        int positionOfComma = fullName.indexOf(',') ;

        // Extract the last and first names based on the index of the comma.
        String lastName = fullName.substring ( 0, positionOfComma);
        String firstName = fullName.substring ( positionOfComma +1);
        
        // Print the first name and last name.
        System.out.println ("First name: " + firstName);
        System.out.println ("Last name: " + lastName);

        scan.close();
        
    } // end main
    
} // end ExtractNames