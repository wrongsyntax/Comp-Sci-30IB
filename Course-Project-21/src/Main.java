public class Main {
    public static void main(String[] args) {
        // Instance variables
        Game game = new Game();
        String playAgain = "y";

        // Print out the instructions
        System.out.println("Welcome to the game of 21!");
        System.out.println("In this game, you will be dealt two cards.");
        System.out.println("After that, you will be able to decide if you want to stay with those two cards or be dealt a third.");
        System.out.println("The goal of the game is to get as close to 21 points as possible w/out going over.");
        System.out.println("Points are awarded as follows:");
        System.out.println("An ace is worth 1 or 11 points, face cards give you 10 points, and all other cards (excluding Joker) are worth the amount on the card.");

        while (!playAgain.equals("n")) {
            playAgain = game.getPlayAgain();
        }
    }
}
