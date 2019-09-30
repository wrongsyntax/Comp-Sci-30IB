import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Instantiation of Numbers object
        Numbers lottery = new Numbers(49);
        Guess guessNums = new Guess();

        // Call method to get a guess
        int[] lotteryGuess = guessNums.guess();

        // Call method to draw numbers
        int[] drawnNums = lottery.draw();

        // Compare guess with drawn numbers
        System.out.println("The drawn numbers are: " + Arrays.toString(drawnNums) + ".");
        if (lotteryGuess == drawnNums) {
            System.out.println("Congratulations! You won $10,000,000!");
        } else {
            System.out.println("You've lost the lottery this time. Try again next time!");
        }
    }
}
