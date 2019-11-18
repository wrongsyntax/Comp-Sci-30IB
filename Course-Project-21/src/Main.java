public class Main {
    public static void main(String[] args) {
        // Instance variables
        Game game = new Game();
        // player one instance variables
        Player playerOne = new Player();
        String playerOneName;
        int playerOnePoints;
        // player two instance variables
        Player playerTwo = new Player();
        String playerTwoName;
        int playerTwoPoints;
        String playAgain = "y";

        // Print out the instructions
        System.out.println("Welcome to the game of 21!");
        System.out.println("In this game, you will be dealt two cards.");
        System.out.println("After that, you will be able to decide if you want to stay with those two cards or be dealt a third.");
        System.out.println("The goal of the game is to get as close to 21 points as possible w/out going over.");
        System.out.println("Points are awarded as follows:");
        System.out.println("An ace is worth 1 or 11 points, face cards give you 10 points, and all other cards (excluding Joker) are worth the amount on the card.");

        // Player stuff
        System.out.println("\nPlease enter player one's name: ");
        playerOne.setName();
        playerOneName = playerOne.getName();
        System.out.println("Please enter player two's name: ");
        playerTwo.setName();
        playerTwoName = playerTwo.getName();

        while (!playAgain.equals("n")) {
            // Draw the first two cards for player one
            playerOne.setCardDrawnOne(game.drawCard());
            playerOne.setCardOneID(game.getCardID());
            playerOne.setCardDrawnTwo(game.drawCard());
            playerOne.setCardTwoID(game.getCardID());
            playerOnePoints = playerOne.getPoints(game.getPointsForCard(playerOne.getCardOneID())) + playerOne.getPoints(game.getPointsForCard(playerOne.getCardTwoID()));
            System.out.println("\n" + playerOneName + " drew the following two cards: \n" + playerOne.getCardDrawnOne() + "\n and \n" + playerOne.getCardDrawnTwo());
            System.out.println(playerOneName + " got " + playerOnePoints + " points from those two cards.");

            // Draw the first two cards for player two
            playerTwo.setCardDrawnOne(game.drawCard());
            playerTwo.setCardOneID(game.getCardID());
            playerTwo.setCardDrawnTwo(game.drawCard());
            playerTwo.setCardTwoID(game.getCardID());
            playerTwoPoints = playerTwo.getPoints(game.getPointsForCard(playerTwo.getCardOneID())) + playerTwo.getPoints(game.getPointsForCard(playerTwo.getCardTwoID()));
            System.out.println("\n" + playerTwoName + " drew the following two cards: \n" + playerTwo.getCardDrawnOne() + "\n and \n" + playerTwo.getCardDrawnTwo());
            System.out.println(playerTwoName + " got " + playerTwoPoints + " points from those two cards.");

            playAgain = game.getPlayAgain();
        }
    }
}
