import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Guess {
    // Instance variables
    private Scanner scanner;

    // Constructor
    Guess() {
        scanner = new Scanner(System.in);
    }

    // Function to get six integers
    int[] guess() {
        // Get input of 6 integers in a list to separate values with whitespace
        List<Integer> guessList = new ArrayList<Integer>();
        System.out.println("Enter 6 numbers between 1 and 49 separated with a space:");
        while (guessList.size() < 6) {
            guessList.add(scanner.nextInt());
        }

        // Change list to an array
        int[] guessArray = new int[guessList.size()];
        for (int i = 0; i < guessArray.length; i++) {
            guessArray[i] = guessList.get(i);
        }
        return guessArray;
    }
}
