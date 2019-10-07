import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Instantiation of Dice object
        Dice rollOne = new Dice(6);

        for (int i = 0; i < 3; i ++) {
            // Call method to roll five dice
            int[] rolledNums = rollOne.roll();
            System.out.println("You rolled " + Arrays.toString(rolledNums));

            // Instantiation of CheckAllEqual object
            CheckAllEqual check = new CheckAllEqual(rolledNums);

            // Check to see if a Yahtzee was rolled
            boolean yahtzeeRolled = check.check();

            if (yahtzeeRolled) {
                System.out.println("That's a Yahtzee! \n");
            } else {
                System.out.println("That is not a Yahtzee.");
                int sum = 0;
                for (int rolledNum : rolledNums) {
                    sum += rolledNum;
                }
                System.out.println("In the Chance category, you scored " + sum + " points. \n");
            }
        }
    }
}
