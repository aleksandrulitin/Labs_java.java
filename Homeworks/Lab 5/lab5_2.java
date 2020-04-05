import java.util.Scanner;

public class lab5_2
{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        for(;;){
            System.out.println("Enter your grade: ");
            int grades = scan.nextInt();
            if ( is_valid(grades)) break;
        }

    }
    public static boolean is_valid ( int grades){
        return grades > 0 && grades < 100;
    }
      
}