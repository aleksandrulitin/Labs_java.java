
/**
 * An interface specifies an Abstract Data Type (ADT).
 * An ADT is a collection of data and operations on the data,
 * e.g. a deck of cards and operations such as shuffle, choose card...
 * e.g. a collection of accounts the operations such as deposit, withdraw...
 * All methods in an interface are abstract.
 *
 * @author Dr. Chays
 * @version March 18, 2020
 */
public interface DeckInterface
{    
    /**
     * takeCard: take a card from the deck. It will be removed.
     *
     * @return the Card that was removed from the deck.
     */
    public Card takeCard();
    
    /**
     * shuffle: shuffle the deck by randomly swapping pairs of cards a certain number of times.
     */
    public void shuffle();
    
    /**
     * toString: 
     * 
     * @return a String representation of a Deck that includes all attributes, i.e. deck and numCards.
     */
    public String toString();
    
}
