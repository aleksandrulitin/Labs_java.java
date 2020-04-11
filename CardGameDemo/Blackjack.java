
/**
 * Blackjack inherits from CardGame.  
 * Blackjack is a subclass of CardGame.
 * Blackjack overrides the playGame method.
 *
 * @author Dr. Chays
 * @version March 28, 2020
 */

import java.util.Scanner;

public class Blackjack extends CardGame
{
    // Constant.
    final int BLACKJACK = 21;
     
    // Attributes.
    String name;
    
    /**
     * Constructor for objects of class CardGame
     */
    public Blackjack(int theNumPlayers, int theMaxNumCardsPerHand)
    {
        // Initialize attributes.
        super(theNumPlayers, theMaxNumCardsPerHand);
        this.name = "Blackjack";
    }
    
    /**
     * playGame: plays a modified game of Blackjack.
     * Objective: get as close to 21 without going over.  If dealer gets 21, dealer wins.  If dealer goes over 21, dealer loses.  Otherwise, same rules apply to each player,
     * who is playing against the dealer.  If no one got 21 or over, then the hand (player vs dealer) with the highest sum wins.
     * Each player starts with 2 cards; picture cards (Jack, Queen, King) count as 10; Ace counts as 1; other cards' values are same as the number on the card (2 through 10).
     * Player 0 is the dealer; all other players have the option to "hit" (get a new card), except the dealer; they stop drawing cards when they reach a given maximum 
     * (attribute of super class) or they say "stop".
     */
    @Override
    public void playGame()
    {
            final int NUM_CARDS_TO_START = 2;
        
            // Deal 2 cards to each player.
            super.dealStartingHands(NUM_CARDS_TO_START);
            
            // Print the game's data, including what cards the dealer and each player has.
            System.out.println(super.toString());
            
            // Player 1 is the dealer. Assume no further cards for dealer.
            // If dealer has a sum of 21, dealer wins.  If dealer went over 21, dealer loses.  Otherwise let player 2 hit or stay, up to a maximum of this.maxNumCardsPerHand.
            int dealerTotal = this.getSumForPlayer(0);
            
            // Check if dealer has a total of 21, or over.
            if (dealerTotal == BLACKJACK)
            {
                System.out.println("Dealer wins.");
            }
            else if (dealerTotal > BLACKJACK)
            {
                System.out.println("Dealer loses.");
            }
            else
            {
                // For each player (other than the dealer), check for win, check if player went over 21; otherwise, ask player if they want to hit or stay, up to super.maxNumCardsPerHand.
                for (int playerNum = 1; playerNum < numPlayers; playerNum++) 
                {
                    int playerTotal = this.getSumForPlayer(playerNum);
                    if (playerTotal == BLACKJACK)
                    {
                        System.out.println("Player " + playerNum + " wins.");
                    }
                    else if (playerTotal > BLACKJACK)
                    {
                        System.out.println("Player " + playerNum + " loses.");
                    }
                    else
                    {
                        // Ask user if they want to hit or stay.
                        Scanner scan = new Scanner(System.in);
                        System.out.println("Player " + playerNum + ", type hit or stay: ");
                        String hitOrStay = scan.next();
               
                        while (hitOrStay.equalsIgnoreCase("hit"))
                        {
                             // Deal next card to player.
                             Card dealtCard = super.dealCard(playerNum);
                             System.out.println("Card drawn: " + dealtCard);
                             
                             // Update player's total.
                             playerTotal = this.getSumForPlayer(playerNum);
                             System.out.println("Player's new total: " + playerTotal);
                             
                             // Check if player reached BLACKJACK or over, or if player has the maximum number of cards allowed per hand.
                             if (playerTotal >= BLACKJACK || super.hasMaxNumCards(playerNum))
                                break;
                                
                             // Ask user if they want another card.
                             System.out.println("Player " + playerNum + ", type hit or stay: ");
                             hitOrStay = scan.next();
                        }
                        
                        // Determine the result of the game for player p: win, loss or push/tie.
                        String result = determineResultForPlayer(playerNum, dealerTotal, playerTotal);
                        System.out.println(result);
                    }
                }
            }
    }
    
    
    /**
     * getSumForPlayer:
     * 
     * @param int playerNum, assumed to be valid: 1 <= playerNum <= this.numPlayers
     * @return an int, the sum of playerNum's cards, assuming ACE = 1, JACK = 10, QUEEN = 10. KING = 10, cards 2 through 10 = same as number on the card..
     */
    @Override
    public int getSumForPlayer(int playerNum)
    {
        return players[playerNum].computeSum(true); // parameter is set to true if picture cards have a value of 10.
    }
    
    /**
     * determineResultForPlayer:
     * 
     * @param int playerNum
     * @param int dealerTotal
     * @param int playerTotal
     * @return String result of game based on whether the player got 21, more than 21, or more or less than dealer (win/loss/tie for the given player)
     * Precondition: It has already been determined that the dealer did not get 21 or over.
     */
    public String determineResultForPlayer(int playerNum, int dealerTotal, int playerTotal)
    {
        String result = "";
        
        if (playerTotal == dealerTotal)
        {
            result += "Push/tie";
        }
        else if (playerTotal == BLACKJACK || (playerTotal < BLACKJACK && playerTotal > dealerTotal))
        {
            result += "Player " + playerNum + " wins.";
        }
        else // if playerTotal > BLACKJACk || dealerTotal >= playerTotal
        {
            result += "Player " + playerNum + " loses.";
        }
        
        return result;
    }
}