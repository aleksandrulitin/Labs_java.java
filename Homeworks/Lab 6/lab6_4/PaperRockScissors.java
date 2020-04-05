/**
 * Blueprint class.  
 *
 * @author Alekasndr Ulitin
 * @version 3/28/2020
 * 
 * Generation of computer turn
 */

import java.util.Random;

// generate computer turn
public class PaperRockScissors {

    // creating array with possible results
    private final static String[] results = new String[] {"Rock", "Paper", "Scissors"};

    // roll a number from 0 to 2
    public static int ComputerTurn() {
        Random roll = new Random();
        int computerTurn = roll.nextInt(3);
        return computerTurn;
    }

    public static String getResult(int number) {
        return results[number];
    }
}