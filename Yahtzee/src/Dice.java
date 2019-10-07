import java.util.Random;

class Dice {
    // Instance variables
    private Random random;
    private int numberOfSides;

    // Constructor
    Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        random = new Random();
    }

    // Method to roll dice
    int[] roll() {
        int[] rolledNums = {0, 0, 0, 0, 0};
        for (int i = 0; i < rolledNums.length; i ++) {
            int roll = random.nextInt(numberOfSides) + 1;
            rolledNums[i] = roll;
        }
        return rolledNums;
    }
}
