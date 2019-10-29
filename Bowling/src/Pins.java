import java.util.Random;

public class Pins {
    // Instance Variables
    private int numOfPins;
    private int strikePoints;
    private int sparePoints;
    private int pointsPerPin;
    private int points;
    private Random random;

    // Constructor
    public Pins() {
        numOfPins = 10;
        strikePoints = 20;
        sparePoints = 15;
        pointsPerPin = 1;
        points = 0;
        random = new Random();
    }

    // Method to get a random number
    // Using the Throw class, this is used to award points according to how close the player's guess was to this number
    int chooseRandInt() {
        return random.nextInt(10) + 1;
    }

    // Method to knock down the pins
    // If the numbers are the same, it's a strike
    int pointsAwarded(int randInt, int guess) {
        // TODO: Figure out a way to award a different number of points according to how close the guess is
        return points;
    }
}
