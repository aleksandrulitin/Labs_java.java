
/**
 * Driver will be replaced by your particular game such as BlackJack, War, Rummy, etc.
 *
 * @author Dr. Chays
 * @version March 28, 2020
 */

import java.util.Scanner;

public class Driver 
{
    /**
     * Plays games of modified Blackjack (described in Blackjack class) until the user decides to stop.
     */
    public static void main(String[] args)
    {
        // Constants.
        final int NUM_PLAYERS = 2;
        final int MAX_NUM_CARDS = 10;
       
        String playAgain; // stores user's response (yes/no) to whether or not they want to play again.
        
        do {
            // Create a game with 2 players and 10 cards maximum per player.
            Blackjack myGame = new Blackjack(NUM_PLAYERS, MAX_NUM_CARDS); 
            Deck myDeck = myGame.getDeck();
            
            // Print deck before shuffling.
            System.out.println("Unshuffled deck:");
            System.out.println(myGame.getDeck()); 
            
            // Shuffle the cards.
            myDeck.shuffle();
            
            // Print deck after shuffling.
            System.out.println("Shuffled deck:");
            System.out.println(myGame.getDeck()); 
     
            // Play one game.
            myGame.playGame();
            
            // Ask if user wants to play another game.
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to play again? Type yes or no.");
            playAgain = scan.next();
        
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("End of run.");
        
    }
}
