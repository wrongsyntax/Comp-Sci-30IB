import java.util.Scanner;

public class Throw {
    // Instance Variables
    private Scanner scanner;

    // Constructor
    public Throw() {
        scanner = new Scanner(System.in);
    }

    // Method to ask for a number
    // This is to see how close the number is to the randomly generated one and award points accordingly
    int askForNum() {
        System.out.println("Guess a number between 1 and 10, including both: ");
        return scanner.nextInt();
    }
}
