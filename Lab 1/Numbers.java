

import java.util.Scanner;

public class Numbers

{
    public static void main(String[] aStrings) 
    {
        //Define variable
        double number_1, number_2, number_3, sum, average;
        Scanner scan = new Scanner(System.in);

        //Value of coins
        number_1 = scan.nextDouble();
        number_2 = scan.nextDouble();
        number_3 = scan.nextDouble();

        //main

        //Comput a sum and average
        sum = number_1 + number_2 + number_3;
        average = sum / 3;

        //print the result
        System.out.println("The sum is : "+sum);
        System.out.println("The average is : "+average);

        scan.close();

        //end of main
    }
}




