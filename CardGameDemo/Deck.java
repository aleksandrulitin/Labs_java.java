
/**
 * A Deck has an array of Cards.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Random;

public class Deck implements DeckInterface
{
    // Constants.
    private final int NUM_CARDS_TOTAL = 52;
    private final int NUM_CARDS_PER_SUIT = 13;
    
    // Attributes
    private Card[] cards;
    private int numCards; // logical size = current number of cards which may be less than 52.

    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        this.cards = new Card[NUM_CARDS_TOTAL]; // Allocate space in memory for all the cards.
        
        int position = 0; // positions will be 0 through 51 in the deck.
        
        // For each suit, put all cards of that suit in the deck.
        for (Card.SuitType nextSuit : Card.SuitType.values()) {
    
            for (int rank = 1; rank <= NUM_CARDS_PER_SUIT; rank++)
            {
                this.cards[position] = new Card(rank, nextSuit);            
                position++;
            }
        }
        
        this.numCards = NUM_CARDS_TOTAL;
    }

    /**
     * takeCard: take a card from the deck. It will be removed.
     *
     * @return the Card that was removed from the deck.
     */
    public Card takeCard()
    {
        this.numCards--; // There is one less card.
        return cards[this.numCards];  // Return the card at the end of the array.
    }
    
    /**
     * shuffle: shuffle the deck by randomly swapping pairs of cards a certain number of times.
     */
    public void shuffle()
    {
        Random rand = new Random();
        
        for (int i = 0; i < 100; i++)
        {
            int firstCardPosition = rand.nextInt(NUM_CARDS_TOTAL);
            int secondCardPosition = rand.nextInt(NUM_CARDS_TOTAL);
            
            this.swap (firstCardPosition, secondCardPosition);
        }
    }
    
    /**
     * swap: helper method of shuffle.
     */
    private void swap(int i, int j)
    {
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }
    
    /**
     * toString: 
     * 
     * @return a String representation of a Deck that includes all attributes, i.e. deck and numCards.
     */
    public String toString()
    {
        String result = "";
        
        result += "There are " + this.numCards + " in the deck:\n";
        
        for (int i = 0; i < this.numCards; i++)
        {
            result += this.cards[i] + "\n";
        }        
        
        return result;
    }
    
}
