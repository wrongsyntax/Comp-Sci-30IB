public class Main {
    public static void main(String[] args) {
        // Instance variables
        Game game = new Game();
        String cardDrawnOne;
        int cardOneID;
        int cardOnePoints;
        String cardDrawnTwo;
        int cardTwoID;
        int cardTwoPoints;
        String cardDrawnThree;
        int cardThreeID;
        int cardThreePoints;
        int totalPoints;
        String anotherCardDecision;
        String playAgain = "y";

        // Print out the instructions
        System.out.println("Welcome to the game of 21!");
        System.out.println("In this game, you will be dealt two cards.");
        System.out.println("After that, you will be able to decide if you want to stay with those two cards or be dealt a third.");
        System.out.println("The goal of the game is to get as close to 21 points as possible w/out going over.");
        System.out.println("Points are awarded as follows:");
        System.out.println("An ace is worth 1 or 11 points, face cards give you 10 points, and all other cards (excluding Joker) are worth the amount on the card.");

        while (!playAgain.equals("n")) {
            // Generate the first two cards
            cardDrawnOne = game.drawCard();
            cardOneID = game.getCardID();
            cardDrawnTwo = game.drawCard();
            cardTwoID = game.getCardID();
            System.out.println("\nYou drew these two cards: \n" + cardDrawnOne + "\n and \n" + cardDrawnTwo);

            // Calculate the points received from these two cards
            if (cardOneID == 1) {
                cardOnePoints = game.getAceDecision();
            } else if (cardOneID == 11 || cardOneID == 12 || cardOneID == 13) {
                cardOnePoints = 10;
            } else {
                cardOnePoints = cardOneID;
            }
            if (cardTwoID == 1) {
                cardTwoPoints = game.getAceDecision();
            } else if (cardTwoID == 11 || cardTwoID == 12 || cardTwoID == 13) {
                cardTwoPoints = 10;
            } else {
                cardTwoPoints = cardTwoID;
            }
            totalPoints = cardOnePoints + cardTwoPoints;
            System.out.println("You got a total of " + totalPoints + " points from those two cards.");

            // Check if the total points are below 21
            if (totalPoints < 21) {
                System.out.println("You got less than 21 points with those two cards. Would you like to draw another?");
                anotherCardDecision = game.getThirdCardDecision();
                if (anotherCardDecision.equals("y")) {
                    cardDrawnThree = game.drawCard();
                    System.out.println("The third card drawn is a " + cardDrawnThree + ".");
                    cardThreeID = game.getCardID();
                    if (cardThreeID == 1) {
                        cardThreePoints = game.getAceDecision();
                    } else if (cardThreeID == 11 || cardThreeID == 12 || cardThreeID == 13) {
                        cardThreePoints = 10;
                    } else {
                        cardThreePoints = cardThreeID;
                    }
                    totalPoints += cardThreePoints;
                    System.out.println("The new value for your total points is " + totalPoints + ".");
                } else if (anotherCardDecision.equals("n")) {
                    System.out.println("You chose to not draw another card.");
                }
            } else if (totalPoints > 21) {
                System.out.println("You got over 21 points! That's an automatic loss :(");
            }
            playAgain = game.getPlayAgain();
        }
    }
}
