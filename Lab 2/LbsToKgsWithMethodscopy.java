
import java.text.DecimalFormat;

import java.util.Scanner;



public class LbsToKgsWithMethodscopy
{
   public static void main (final String[] args) {
 
      double lbs, kgs;

      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter a lbs:  ");
      lbs = scan.nextDouble();
      System.out.println("Enter a lbs:  ");

   
      kgs = convertToKgs(lbs);

      printWeight(lbs, kgs);

      scan.close();
   } 


   public static double convertToKgs(final double lbs) {
      
      final double LBS_PER_KG = 2.2;

      final double kgs = lbs / LBS_PER_KG;

      return kgs;
   } 

 
   public static void printWeight(final double lbs, final double kgs) {
      
      final DecimalFormat fmt = new DecimalFormat("0.###");
      
      System.out.println("The given weight in pounds is " + fmt.format (lbs));
      System.out.println("The equivalent weight in kilograms is " + fmt.format (kgs));
   } 


   
} 