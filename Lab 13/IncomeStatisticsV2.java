// This version of IncomeStatistics includes the code for readData
// that appears in Chapter 2.
import java.util.Scanner;

public class IncomeStatisticsV2 {
    final static int LOW_END = 10;    // low end of incomes
    final static int HIGH_END = 100;  // high end of incomes
    final static int TABLE_SIZE = HIGH_END - LOW_END + 1;

    int[] incomeData;    // used to store the income data,
    // incomeData[G] stores the total number of
    // people that fall into the G-thousand-dollar group

    public IncomeStatisticsV2() {
        incomeData = new int[TABLE_SIZE];
    }  // end constructor

    // readData Chapter 2
    public boolean readData() {
        // ------------------------------------------------------
        // Reads and organizes income statistics.
        // Precondition: The calling program gives directions and
        // prompts the user. Each input line contains exactly two
        // integers in the form G N, where N is the number of people
        // with an income in the G-thousand-dollar group and
        // LOW_END <= G <= HIGH_END. An input line with values of zero for
        // both G and N terminates the input.
        // Postcondition: incomeData[G-LOW_END] = total number of people
        // with an income in the G-thousand-dollar group. The values
        // read are displayed. If either G or N is erroneous (G and
        // N are not both 0, and either G < LOW_END, G > HIGH_END,
        // or N < 0), the method ignores the data line, sets the
        // return value to false, and continues. In this case,
        // the calling program should take action.
        // The return value is true if the data is error free.
        // -------------------------------------------------------
        int group, number; // input values
        boolean result = true;
        Scanner input = new Scanner(System.in);

        for (group = LOW_END; group <= HIGH_END; ++group) {
            // clear array
            incomeData[index(group)] = 0;
        } // end for

        // Get group and number from the user.
        System.out.println("Enter: G N \nwhere " + LOW_END + " <= G <= " + HIGH_END + " and N >= 0 \nrepresenting N number of people in the G-thousand-dollar group\nEnter: 0 0 to quit.");
        group = input.nextInt();
        number = input.nextInt();

        while ((group != 0) || (number != 0)) {
            System.out.println("Income group " + group + " contains " +
                    number + " people.");

            //Ensure integers are correct
            if ( (LOW_END > group) || (group > HIGH_END) || number > HIGH_END) {
                result = false;
                break;
            }

            incomeData[index(group)] += number;
            group = input.nextInt();
            number = input.nextInt();
        } // end while
        return result;
    }  // end readData

    private int index(int group) {
        // Returns the array index corresponding to group number.
        return group - LOW_END;
    }  // end index

// other methods for class IncomeStatistics would follow
} // end IncomeStatistics
