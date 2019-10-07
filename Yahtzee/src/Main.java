public class Main {
    public static void main(String[] args) {
        // Instantiation of Dice object
        Dice rollOne = new Dice(6);

        // Call method to roll five dice
        int[] rolledNums = rollOne.roll();

        // Instantiation of CheckAllEqual object
        CheckAllEqual check = new CheckAllEqual(rolledNums);

        // Check to see if a Yahtzee was rolled
        boolean yahtzeeRolled = check.check();

        if (yahtzeeRolled) {
            System.out.println("You rolled a Yahtzee!");
        } else {
            System.out.println("You did not roll a Yahtzee.");
        }
    }
}
