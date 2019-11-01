import java.util.Scanner;
import java.util.Random;

public class Game {
    // Instance variables
    private int framesLeft;
    private int throwsLeft;
    private int points;
    private int pinsLeft;
    private Scanner scanner;
    private Random random;

    // Constructor
    Game() {
        framesLeft = 10;
        pinsLeft = 10;
        throwsLeft = 2;
        points = 0;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    // Method to roll the ball
    int rollBall() {

    }
}