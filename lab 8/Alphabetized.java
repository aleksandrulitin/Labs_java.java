import java.util.Scanner;

public class Alphabetized {

    public static void main(String[] args) {
        String[] name, names;
        name = getInput();
        names = sortNames(name);
        printNames(names);
    }

    public static String[] getInput() {
        // declare variables
        int name;

        // setup scanner
        Scanner scan1 = new Scanner(System.in);
        System.out.print("How many names do you want sorted?: ");
        name = scan1.nextInt();

        // receive user input
        String[] names = new String[name];
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter all the names: ");

        for(int i = 0; i < name; i++) {
            names[i] = scan2.nextLine();
        }
        return names;
    }

    public static String[] sortNames(String[] name) {

        int numberOfNames = name.length;
        String[] names = new String[numberOfNames];
        String temp;

        // sort names
        for (int i = 0; i < numberOfNames; i++) {
            for (int j = i + 1; j < numberOfNames; j++) {
                if (names[i].compareTo(names[j])>0) {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        return names;
    }

    public static void printNames(String[] name) {

        int numberOfNames = name.length;
        String[] names = new String[numberOfNames];

        // print sorted names
        System.out.print("Names in Sorted Order: ");
        for (int i = 0; i < numberOfNames - 1; i++) {
            System.out.println(names[i] + ", ");
        }

        System.out.print(names[numberOfNames - 1]);}
}