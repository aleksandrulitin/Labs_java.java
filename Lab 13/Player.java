/**
 * Player has cards in hand, a number of cards (currently) and a maximum number of cards.
 *
 * @author Dr. Chays
 * @version March 28, 2020
 */
public class Player {
    // attributes
    private int numCardsInHand, maxCardsInHand;
    private Card[] cardsInHand;

    /**
     * Constructor for objects of class Player
     */
    public Player(int maxCards) {
        // Initialize attributes.
        this.maxCardsInHand = maxCards;
        this.cardsInHand = new Card[this.maxCardsInHand];
        this.numCardsInHand = 0;
    }

    /**
     * putCardInHand:
     *
     * @param theCard to put in hand, as long as the maximum number of cards in hand have not been reached.
     */
    public void putCardInHand(Card theCard) {
        if (this.numCardsInHand < maxCardsInHand)
            cardsInHand[this.numCardsInHand++] = theCard;
    }

    /**
     * computeSum:
     *
     * @param boolean, true if picture cards (JACK, QUEEN, or KING) have a value of 10, false otherwise.
     * @return an int, the sum of the rank values of the cards in hand, assuming ACE has a value of 1.
     */
    public int computeSum(boolean pictureCardsWorthTen) {
        int sum = 0;

        for (int i = 0; i < this.numCardsInHand; i++)
        {
            int rankOfNextCard = this.cardsInHand[i].getRank();

            if (pictureCardsWorthTen && rankOfNextCard >= 11 && rankOfNextCard <= 13)
                sum += 10;
            else
                sum += rankOfNextCard;
        }

        return sum;
    }

    /**
     * getNumCardsInHand:
     * @return int numCardsInHand
     */
    public int getNumCardsInHand() {
        return this.numCardsInHand;
    }

    /**
     * toString:
     *
     * @return a String representation of a Card that includes all attributes, i.e. rank and suit.
     */
    public String toString() {
        String result = "";

        result += "There are " + this.numCardsInHand + " cards in hand (maximum of " + this.maxCardsInHand + "):\n";

        for (int i = 0; i < this.numCardsInHand; i++) {
            result += this.cardsInHand[i] + "\n";
        }

        return result;
    }
}