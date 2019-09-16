import java.util.Random;

public class Dice {
    // Instance variables
    private Random random;
    private int numberOfSides;

    // Constructor
    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        random = new Random();
    }

    public int roll() {
        int result  = random.nextInt(numberOfSides) + 1;
        return result;
    }
}
