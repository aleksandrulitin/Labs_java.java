/**
 * CardGame has a deck of cards and a certain number of players, each of whom has a hand of cards.
 * The playGame method is abstract because the definition
 * depends on which card game it is, so definition is deferred to subclasses.
 *
 * @author Dr. Chays
 * @version March 28, 2020
 */
public abstract class CardGame
{
    // Attributes.
    protected Player[] players;
    protected int numPlayers;
    private Deck deck;
    private int maxNumCardsPerHand;

    /**
     * Constructor for objects of class CardGame
     */
    public CardGame(int theNumPlayers, int theMaxNumCardsPerHand)
    {
        // Initialize attributes.
        this.numPlayers = theNumPlayers;
        this.maxNumCardsPerHand = theMaxNumCardsPerHand;
        
        this.players = new Player[numPlayers]; // Allocate space for array players
        
        for (int i = 0; i < this.numPlayers; i++) 
        {
            this.players[i] = new Player(this.maxNumCardsPerHand);
        }
        
        this.deck = new Deck();
    }
    
    /**
     * playGame: abstract method, whose definition/implementation is deferred to subclass.
     */
    public abstract void playGame();
    
    /**
     * getDeck:
     * @return the deck.
     */
    public Deck getDeck()
    {
        return this.deck;   
    }
    
    /**
     * dealCard: deals a card from the deck to player # playerNum
     * @param int playerNum, a number between 1 and this.numPlayers
     * @return the dealt card
     */
    public Card dealCard(int playerNum)
    {
        // Get next card from deck.
        Card nextCard = this.deck.takeCard();
        
        // Put next card in player's hand.
        this.players[playerNum].putCardInHand(nextCard);
        
        return nextCard;
    }
    
        
    /**
     * dealStartingHands: deal the starting hands.
     * 
     * @param int numCardsToDeal, how many cards to give to each player.
     */
    public void dealStartingHands(int numCardsToDeal)
    {
        // Make sure each player gets numCardsToDeal cards.
        for (int i = 0; i < numCardsToDeal; i++) 
        {
            for (int j = 0; j < this.numPlayers; j++) 
            {
                // Deal a card from the deck to player # j+1.
                this.dealCard(j);   
            }
        }
    }
    
    /**
     * getSumForPlayer:
     * 
     * @param int playerNum, assumed to be valid: 1 <= playerNum <= this.numPlayers
     * @return an int, the sum of playerNum's cards, assuming ACE = 1, JACK = 11, QUEEN = 12. KING = 13, cards 2 through 10 = same as number on the card.
     */
    public int getSumForPlayer(int playerNum)
    {
        return players[playerNum].computeSum(false);
    }
    
    /**
     * hasMaxNumCards:
     * 
     * @param int playerNum
     * @return boolean, true if specified player has the maximum number of cards, false otherwise.
     */
    public boolean hasMaxNumCards(int playerNum)
    {
        return (this.players[playerNum].getNumCardsInHand() == maxNumCardsPerHand);
    }
    
    /**
     * toString: 
     * 
     * @return a String representation of a Deck that includes all attributes, i.e. deck and numCards.
     */
    public String toString()
    {
        String result = "";
        
        result += "There are " + this.numPlayers + " players in the game:\n";
        
        for (int i = 0; i < this.numPlayers; i++)
        {
            result += "Player " + i + ":\n"; 
            result += this.players[i] + "\n";
        }        
        
        return result;
    }
}
