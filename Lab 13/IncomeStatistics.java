import java.util.Scanner;
public class IncomeStatistics {
    final static int LOW_END = 10; // low end of incomes
    final static int HIGH_END = 100; // high end of incomes
    final static int TABLE_SIZE = HIGH_END - LOW_END + 1;

    int[] incomeData; // used to store the income data,
    // incomeData[G] stores the total number of
    // people that fall into the G-thousand-dollar group

    public IncomeStatistics() {
        incomeData = new int[TABLE_SIZE];
    } // end constructor

    public void readData() {
        // -----------------------------------------------------
        // Reads and organizes income statistics.
        // Precondition: The calling code gives directions and
        // prompts the user. Input data is error-free, and each
        // input line is in the form G N, where N is the number of
        // people with an income in the G-thousand-dollar group
        // and LOW_END <= G <= HIGH_END. An input line with values
        // of zero for both G and N terminates the input.
        // Postcondition: incomeData[G-LOW_END] = total number of
        // people with an income in the G-thousand-dollar group
        // for each G read. The values read are displayed.
        // -------------------------------------------------------
        int group, number; // input values
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
            System.out.println("Income group "+group+" contains " +
                    number + " people.");
            incomeData[index(group)] += number;
            group = input.nextInt();
            number = input.nextInt();
        } // end while
    } // end readData

    private int index(int group) {
        // Returns the array index corresponding to group number.
        return group - LOW_END;
    } // end index

    // other methods for class IncomeStatistics would follow

} // end IncomeStatistics