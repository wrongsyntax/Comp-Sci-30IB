import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Instantiation of Numbers object
        Numbers lottery = new Numbers(49);

        // Call method to draw numbers
        for (int z = 0; z <= 20; z++) {
            int[] drawnNums = lottery.draw();
            System.out.println("The drawn numbers are " + Arrays.toString(drawnNums) + ".");
        }
    }
}
