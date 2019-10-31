import java.util.Scanner;

class Game {
    // Instance Variables
    private int frames;
    private int throwsLeft;
    private int points;
    private int randChosenInt;
    private Pins pins;
    private Scanner scanner;

    // Constructor
    Game(Pins pins, int randChosenInt) {
        this.pins = pins;
        this.randChosenInt = randChosenInt;
        frames = 10;
        throwsLeft = 2;
        points = 0;
        scanner = new Scanner(System.in);
    }

    // Method to ask for a number
    // This is to see how close the number is to the randomly generated one and award points accordingly
    int askForNum() {
        System.out.println("Guess a number between 1 and 10: ");
        return scanner.nextInt();
    }

    // Method to knock down the pins
    // If the numbers are the same, it's a strike
    int awardPoints(int guess) {
        return points;
    }
}
