
import java.util.Scanner;

public class ForceConverter
{
    public static void main (final String[] args)
    {
        double newtons, poundForce;

        Scanner scan = new Scanner(System.in);
       
       System.out.print("Enter a pound-force : ");

       poundForce = scan.nextDouble(); 

       newtons = converForce(poundForce);

       printResult(poundForce, newtons);

     scan.close();
  } 
  public static double converForce (final double poundForce){

    final double CONVERSION_FACTOR = 4.44822162;

    final double result = poundForce * CONVERSION_FACTOR;

      return result;
  }

  public static void printResult (final double poundForce, final double newtons){

     System.out.println ("Pound-force: " + poundForce);
     System.out.println ("Fahrenheit Equivalent: " + newtons);

  }

} 
