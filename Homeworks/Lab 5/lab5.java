import java.util.Scanner;

public class lab5
{
    final static int SENTINEL = - 1;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        for(;;){
            System.out.println("Enter your grade: ");
            int grades = scan.nextInt();
            if ( grades == SENTINEL) break;

        }
    
    scan.close();
    }

}