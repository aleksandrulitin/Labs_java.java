import java.util.Scanner;

public class TempConverter
{
   
   public static void main (final String[] args) {

        double celsiusTemp;
        final double fahrenheitTemp;

        final Scanner scan = new Scanner(System.in);

        System.out.println("Enter a temprature in Celius:  ");

        celsiusTemp = scan.nextDouble();

        fahrenheitTemp = convertTemp(celsiusTemp);

        printResult(celsiusTemp, fahrenheitTemp);

        scan.close();

   } 

   public static double convertTemp (final double celsiusTemp){

        final double CONVERSION_FACTOR = 1.8;

        final double BASE = 32; 

        final double result = celsiusTemp * CONVERSION_FACTOR + BASE;

        return result;
   }

   public static void printResult (final double celsiusTemp, final double fahrenheitTemp){

        System.out.println("Temprature in celius:   "  + celsiusTemp);
        System.out.println("Tempratire in fahreheiTemp:  " + fahrenheitTemp);
   }
} 