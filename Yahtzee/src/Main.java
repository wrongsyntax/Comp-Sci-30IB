import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Instantiation of Dice object
        Dice rollOne = new Dice(6);

        // Call method to roll five dice
        int[] rolledNums = rollOne.roll();
        System.out.println("You rolled " + Arrays.toString(rolledNums));

        // Instantiation of CheckAllEqual object
        CheckAllEqual check = new CheckAllEqual(rolledNums);

        // Check to see if a Yahtzee was rolled
        boolean yahtzeeRolled = check.check();

        if (yahtzeeRolled) {
            System.out.println("That's a Yahtzee!");
        } else {
            System.out.println("That is not a Yahtzee.");
        }
    }
}
