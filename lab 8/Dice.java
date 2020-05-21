import java.util.Random;
/**
 * Dice class creates one new 6 sided die
 * Initial value will be 0 until method rollDice() is
 * executed.
 **/
public class Dice {
    private int value;

    //Constructor
    public Dice() {
        this.value = 0;
    }//end Dice

    //Roll a dice
    public int rollDice() {
        //Initialize Random
        Random roll = new Random();
        this.value = roll.nextInt(6)+1;
        return this.value;
    }//end rollDice
}//end Class Dice
