import java.util.Scanner;
import java.util.Random;

public class Game {
    // Instance variables
    private int throwsLeft;
    private int points;
    private int pinsLeft;
    private int randomInt;
    private int guess;
    private Scanner scanner;
    private Random random;

    // Constructor
    Game() {
        pinsLeft = 10;
        points = 0;
        randomInt = 0;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    // Method to generate and return a random integer
    int getRandomInt(int pinsLeft) {
        // Generate a random number to compare with the player's guess later
        randomInt = random.nextInt(pinsLeft) + 1;
        return randomInt;
    }

    // Method to roll the ball
    int rollBall(int maxNum) {
        // Ask for the player to guess a number since points are awarded based on this
        System.out.println("Enter a number between 1 and " + maxNum + ": ");
        guess = scanner.nextInt();
        return guess;
    }
}