import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * A Card has a rank and a suit.
 * There are two class invariants:
 * 1) rank must be between 1 and MAX_RANK (inclusive).
 * 2) suit must be CLUBS, HEARTS, SPADES or DIAMONDS.
 *
 * @author Dr. Chays
 * @version March 28, 2020
 */
public class Card {
    // Constant.
    public final static int MAX_RANK = 13;

    // Enumerated type to satisfy second class invariant.
    public enum SuitType {CLUBS, HEARTS, SPADES, DIAMONDS}

    // Attributes.
    private SuitType suit;
    private int rank;

    /**
     * Constructor for objects of class Card
     */
    public Card() {
        // initialize rank and suit
        setRank(1);
        this.suit = SuitType.HEARTS;
    }

    /**
     * Constructor for objects of class Card
     */
    public Card(int theRank, SuitType theSuit) {
        // initialize rank and suit
        this.rank = theRank;
        this.suit = theSuit;
    }

    /**
     * getSuit:
     *
     * @return the suit
     */
    public SuitType getSuit() {
        // put your code here
        return suit;
    }

    /**
     * setSuit:
     *
     * @param theSuit
     */
    public void setSuit(SuitType theSuit) {
        this.suit = theSuit;
    }

    /**
     * getRank:
     *
     * @return the rank
     */
    public int getRank() {
        // put your code here
        return rank;
    }

    /**
     * setRank: set the rank attribute to the value of the parameter if
     * the parameter is between 1 and MAX_RANK (inclusive) to satisfy the first class invariant.
     *
     * @param theRank
     */
    public void setRank(int theRank) {
        if (theRank >= 1 && theRank <= MAX_RANK) {
            this.rank = theRank;
        }
    }

    /**
     * toString:
     *
     * @return a String representation of a Card that includes all attributes, i.e. rank and suit.
     */
    public String toString() {
        String result = "";

        if (this.rank == 1)
            result += "ACE";
        else if (this.rank == 11)
            result += "JACK";
        else if (this.rank == 12)
            result += "QUEEN";
        else if (this.rank == 13)
            result += "KING";
        else
            result += String.valueOf(this.rank); // Convert int to String

        result += " of " + this.suit.name();

        return result;
    }
}
