/**
 * Student1.java
 * Exercise #1: Read and understand the driver code (test method) and the
 *		blueprint code. A student has 5 grades, to be read from the user and stored in an array.
 *              Write the methods displayGrades() and howManyCloseToAvg().
 *		See how they are called in the test method.
 * Exercise #2: Declare the array of grades as an instance variable (i.e. attribute) and
 *              update the methods so that they use this array as opposed to an
 *              array that is passed as a parameter;
 *              update the Java-doc comments appropriately.
 * Exercise #3: Update the test method so that it declares an array of 3 students,
 * 		so there are 3 students, each with 5 grades; the test method should perform the same processing as before
 * 		for each of the students.
 *
 * @author (your name)
 * @version (date)
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class Student1
{
    private int Num_Grades;

    /**
     * Constructor for objects of class Student
     */
    public Student1(int numberOfGrades)
    {
        this.Num_Grades = numberOfGrades;
    }

    /**
     * readGrades: read grades from the user and store them in an array.
     *
     * Precondition: object has been instantiated via call to constructor.
     * Postcondition: valid grades are stored in the array that was input.
     *
     * @param   grades  an array of integers, which is filled with grades read in from the user
     * @return  none
     */
    public void readGrades(int[] grades)
    {
        boolean validGrade;

        // Set up scanner object to read input from keyboard.
        Scanner scan = new Scanner (System.in);

        // Read in the appropriate number of grades from the user.
        for (int i = 0; i < this.Num_Grades; i++)
        {
            do
            {
                System.out.print("Enter grade #" + i + " (0 - 100): ");
                grades[i] = scan.nextInt();

                // Check validity of grade.
                validGrade = this.valid (grades[i]);
                if (! validGrade)
                    System.out.println("Error: grade is outside range (0 - 100).");
            }
            while (! validGrade);
        }
    }

    /**
     * valid: check the validity of a grade.
     *
     * Precondition: same as readGrades (this method is a support method of readGrades)
     * Postcondition: validity of a single grade has been checked.
     *
     * @param   oneGrade    an integer representing a single grade
     * @return  a boolean, true if oneGrade is valid; false otherwise
     */
    private boolean valid (int oneGrade)
    {
        return ((oneGrade >= 0) && (oneGrade <= 100));
    }

    /**
     * computeAverage: compute the average.
     *
     * Precondition: array of grades was initialized with valid grades.
     * Postcondition: average is returned.
     *
     * @param   grades      an array of integers
     * @return  the average of the numbers in the array of grades
     */
    public double computeAverage(int[] grades)
    {
        double result;
        int sum = 0;

        for (int i = 0; i < grades.length; i++)
            sum += grades[i];

        result = (double) sum / grades.length;
        return result;
    }

    /**
     * convertToLetterGrade: compute the letter grade from the average.
     *
     * @param   average
     * @return  a char, the equivalent letter grade
     */
    public char convertToLetterGrade (double average)
    {
        char letterGrade = 'U';

        // Compute the letter grade.
        if (average >= 90)
            letterGrade = 'A';
        else if (average >= 80)
            letterGrade = 'B';
        else if (average >= 70)
            letterGrade = 'C';
        else if (average >= 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';

        return letterGrade;
    }

    public String displayGrades(int[] array) {
        System.out.println("Grades: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");
        }//end for
        return "";
    }

    public int howManyCloseToAvg(int[] array, double average, int offset_num) {
        //Declare variable
        int results = 0;

        //Find grades within the offset
        for (int i = 0; i < array.length; i++) {
            if ( ((average-offset_num) < array[i]) && (array[i] < (average+offset_num)) ) {
                results += 1;
            }//end if
        }//end for
        return results;
    }//end howManyCloseToAvg

    /**
     * Test all public methods of this class, which
     * read a student's grades from the user, compute the average and letter grade,
     * as well as how many grades are close to the average.
     */
    public static void main(String[] args)
    {
        Student1 s = new Student1(5);
        int[] scores = new int[s.Num_Grades];
        double avg;
        int howManyWithinThree;
        char letterGrade;

        // Read in the appropriate number of grades from the user.
        s.readGrades (scores);

        // Print the grades, by defining a displayGrades method that returns a String containing all of the student's grades that are stored in the specified array.
        System.out.println (s.displayGrades(scores));

        // Calculate the average of the grades.
        avg = s.computeAverage (scores);

        // Compute how many grades are within 3 of the average.
        howManyWithinThree = s.howManyCloseToAvg (scores, avg, 3);

        // Compute the letter grade.
        letterGrade = s.convertToLetterGrade (avg);

        // Round the output of the average to two decimal places.
        DecimalFormat fmt = new DecimalFormat("0.##");

        // Print the average, the letter grade, and how many grades are close to the average.
        System.out.println("The average is " + fmt.format(avg));
        System.out.println("The letter grade is " + letterGrade);
        System.out.println("There are " + howManyWithinThree + " grades within 3 of the average.");
    }
}


