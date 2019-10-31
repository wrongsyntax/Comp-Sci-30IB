import java.util.Random;

class Pins {
    // Instance Variables
    private Random random;

    // Constructor
    Pins() {
        random = new Random();
    }

    // Method to get a random number
    // Using the Throw class, this is used to award points according to how close the player's guess was to this number
    int chooseRandInt() {
        return random.nextInt(10) + 1;
    }
}
