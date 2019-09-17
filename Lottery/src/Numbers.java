import java.util.Random;

public class Numbers {
    // Instance variables
    private Random random;
    private int maxNum;

    // Constructor
    public Numbers(int maxNum) {
        this.maxNum = maxNum;
        random = new Random();
    }

    public int[] draw() {
        int[] drawnNums = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            int draw = random.nextInt(maxNum) + 1;
            drawnNums[i] = draw;
        }
        return drawnNums;
    }
}
