import java.util.Random;

class Numbers {
    // Instance variables
    private Random random;
    private int maxNum;

    // Constructor
    Numbers(int maxNum) {
        this.maxNum = maxNum;
        random = new Random();
    }

    // Private function to draw one random number
    private int drawNumber() {
        return random.nextInt(maxNum) + 1;
    }

    // Function to randomly draw six numbers using drawNumber() and store in an array
    int[] draw() {
        int[] drawnNums = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            int draw = drawNumber();
            drawnNums[i] = draw;
        }
        return drawnNums;
    }
}
