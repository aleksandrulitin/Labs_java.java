/**
 * Driver class = main class
 * 
 * @author Alekasndr Ulitin
 * @version 3/28/2020
 * 
 * Classic Rock Paper Scissors game
 */

import java.util.Scanner;

public class Game {

    // in main class program recieving computer turn from Bluprint class, and user turn from method. Calculating result.
    public static void main(String[] args) {
     
        boolean Round = true;

        int userTurn, winCount = 0, loseCount = 0, drawCount = 0;

        do {
           
            // get user number from method
            userTurn = userInput();

           
            // get computer number from blueprint class
            int computerTurn = PaperRockScissors.ComputerTurn();

            //  printing results
            System.out.println("Computer rolled a " + PaperRockScissors.getResult(computerTurn));
            System.out.println("You guessed " + PaperRockScissors.getResult(userTurn));

            //Calculating who won in a game
            if(userTurn==computerTurn) {
                System.out.println("Draw!");
                drawCount += 1;
            }
            else if (userTurn==0 && computerTurn==2 || userTurn==1 && computerTurn==0 || userTurn==2 && computerTurn==1){
                System.out.println("You Win.");
                winCount += 1;
            } 
            else if (userTurn==0 && computerTurn==1 || userTurn==1 && computerTurn==2 || userTurn==2 && computerTurn==0){
                System.out.println("You Lose.");
                loseCount += 1;
            }

            // asking for new round
            Round = more();

           
            System.out.println("\n");

        } while(Round); 

        // print results from collection
        printResults(winCount,loseCount, drawCount);
    }
    // Printing results after each game
    public static void printResults(int winCount, int loseCount, int drawCount) {
        System.out.println("You won "+winCount+" times.");
        System.out.println("You lost "+loseCount+" times.");
        System.out.println("You have a draw "+drawCount+" times.");
    }

    // Asking for user turn number
    public static int userInput() {
       
        boolean Error = true;
        int playerTurn;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Select Rock(1), Paper(2) or Scissors(3): ");
            playerTurn = scan.nextInt() - 1;

            // Checking if user input right number
            if((playerTurn >= 0) && (playerTurn <= 2)) {
                Error = false;
            }
        }while(Error);

        

        return playerTurn;
    }
    // Giving a chance for a new game
    public static boolean more() {
      
        boolean process = true, Error;
        int anotherOne;
        Scanner scan = new Scanner(System.in);

        do {
            Error = true;
            System.out.print("Would you like to play again? Enter '1' for yes and '0' for no: ");
            anotherOne = scan.nextInt();

            // Checking if user input right number
            if((anotherOne >=0) && (anotherOne <= 1)); 
            {
                Error = false;
                if(anotherOne==0) {
                    process = false;
                }
            }
        }while(Error);

        

        return process;
    }
}