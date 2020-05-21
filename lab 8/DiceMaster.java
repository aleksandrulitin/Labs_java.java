import java.util.Scanner;

/**
 * DiceMaster: Game where the player/user guesses the sum of 2 six-sided dice being rolled
 */
public class DiceMaster {
    public static void main(String[] args) {
        //Declare variables
        boolean gameRun = true;
        int input, winCount = 0, loseCount = 0;

        //Initialize Objects to be used
        Dice d1 = new Dice();
        Dice d2 = new Dice();

        System.out.println("Welcome to Dice Master!");

        //Start game loop
        do {
            //Collect user input
            input = userInput();

            //Roll Dice
            int rollD1 = d1.rollDice();
            int rollD2 = d2.rollDice();

            //Find Sum of roll
            int sum = rollD1 + rollD2;

            //Print results of Roll for player
            System.out.println("Dice 1 rolled a: "+rollD1);
            System.out.println("Dice 2 rolled a: "+rollD2);
            System.out.println("The sum of the rolls is: "+sum);
            System.out.println("You guessed: "+input);

            //Check if player won
            if(input==sum) {
                System.out.println("You Win!");
                winCount += 1;
            }//end if
            else {
                System.out.println("You Lose.");
                loseCount += 1;
            }//end else

            //Ask to play again
            gameRun = newRound();

            //Print a break between games
            System.out.println("\n");

        } while(gameRun); //end gameLoop

        //Print results of game
        printResults(winCount,loseCount);
    }//end main

    /**
     * isValid: Determine if a number is between 2 and 12 inclusively
     * @param num - user-entered number
     * @return - boolean variable
     */
    public static boolean isValid(int num) {
        return (num > 1) && (num <= 12);
    }//end isValid

    /**
     * playAgain: Determine if the user enters either 1 or 0
     * @param num - user-entered number
     * @return - boolean variable
     */
    public static boolean playAgain(int num) {
        return (num >= 0) && (num <= 1);
    }//end playAgain

    /**
     * printResults: Print data about the game once finished
     * @param winCount - # of times user won
     * @param loseCount - # of times user lost
     */
    public static void printResults(int winCount, int loseCount) {
        System.out.println("Thanks for playing!");
        System.out.println("You won "+winCount+" times.");
        System.out.println("You lost "+loseCount+" times.");
    }//end printResults

    /**
     * userInput: Collect the user's input between 2 and 12 inclusively
     * @return - user's inputted number
     */
    public static int userInput() {
        //Declare variables & Scanner
        boolean badInput = true;
        int input;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Enter an integer between 2 and 12: ");
            input = scan.nextInt();

            //Check input
            if(isValid(input)) {
                badInput = false;
            }//end if
        }while(badInput);
        return input;
    }//end userInput

    /**
     * newRound: Collect either 0 or 1 from the user to determine if they want to play again
     * 1 = yes (true) ; 0 = no (false)
     * @return - boolean variable
     */
    public static boolean newRound() {
        //Declare variables/Scanner
        boolean gameRun = true, badInput;
        int input;
        Scanner scan = new Scanner(System.in);

        do {
            badInput = true;
            System.out.print("Would you like to play again? Enter '1' for yes and '0' for no: ");
            input = scan.nextInt();

            //Check input
            if(playAgain(input)) {
                badInput = false;
                if(input==0) {
                    gameRun = false;
                }//end if
            }//end if
        }while(badInput);
        return gameRun;
    }//end newRound
}//end DiceMaster
