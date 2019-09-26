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
        for (int i = 0; i < drawnNums.length; i++) {
            int draw = drawNumber();
            drawnNums[i] = draw;
        }

        // Check if there are any duplicates in the array, if there are, redraw
        int numOfDuplicates = 0;
        for (int x = 0; x < drawnNums.length; x++) {
            int numToCheck = drawnNums[x];
            numOfDuplicates = 0;
             for (int y = 0; y < drawnNums.length; y++) {
                if (numToCheck == drawnNums[y]) {
                    numOfDuplicates++;
                }
                if (numOfDuplicates >= 2) {
                    return draw();
                }
            }
        }

        return drawnNums;
    }
}
