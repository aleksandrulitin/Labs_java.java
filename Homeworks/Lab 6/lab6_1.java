import java.util.Random;

public class lab6_1

{
    public static void main(String[] args) {

    
        String[] subjects = new String[] {"I", "You", "We"};
        String[] verb = new String[] {"love", "use", "explain"};
        String[] predicates = new String[] {"Java", "Python", "NodeJS"};

        System.out.println(chooseWord(subjects) + " " + chooseWord(verb) + " " + chooseWord(predicates));
    }
    public static String chooseWord (String[] words)
    {
        return words[new Random().nextInt(words.length)];
    }
}