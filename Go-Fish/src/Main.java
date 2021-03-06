import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        String[] fullDeck = deck.createDeck();
        Player player = new Player(fullDeck);
        Player opponent = new Player(fullDeck);
        AI steev = new AI();
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        int playerPoints = 0;
        int opponentPoints = 0;

        System.out.println("Before beginning, please enter the amount of points you would like to play to, between 1 and 13:  ");
        String pointsToPlayTo = scanner.nextLine();
        while (!(pointsToPlayTo.equals("1") || pointsToPlayTo.equals("2") || pointsToPlayTo.equals("3") || pointsToPlayTo.equals("4") || pointsToPlayTo.equals("5") || pointsToPlayTo.equals("6") || pointsToPlayTo.equals("7") || pointsToPlayTo.equals("8") || pointsToPlayTo.equals("9") || pointsToPlayTo.equals("10") || pointsToPlayTo.equals("11") || pointsToPlayTo.equals("12") || pointsToPlayTo.equals("13"))) {
            System.out.println("Please enter only a value between 1 and 13 - inclusive.");
            pointsToPlayTo = scanner.nextLine();
        }

        System.out.println("Now, please choose whether to play the game on your own (1) or to simulate a game (2).");
        String gameDecision = scanner.nextLine();
        while (!(gameDecision.equals("1") || gameDecision.equals("2"))) {
            System.out.println("Please input only \"1\" or \"2\".");
            gameDecision = scanner.nextLine();
        }

        // Deal the player's first five cards
        String[] currentHand = player.getDealtCards();
        System.out.println("You've been dealt the following cards: " + Arrays.toString(currentHand));

        // Deal the opponent's first five cards
        String[] opponentHand = opponent.getDealtCards();
        // This is temporary
        System.out.println("Leaked info - opponent's hand: " + Arrays.toString(opponentHand));

        // Update the draw pile to contain the remaining cards in the game class
        Game game = new Game(fullDeck);

        while (playerPoints != Integer.parseInt(pointsToPlayTo) && opponentPoints != Integer.parseInt(pointsToPlayTo)) {
            // Print out how many cards are left in the draw pile
            int nullCount = 0;
            for (String s : game.drawPile) {
                if (s == null) {
                    nullCount++;
                }
            }
            System.out.println("Cards left in draw pile: " + (52 - nullCount));

            // PLAYER'S TURN
            // Player asks the opponent for a card with this
            String ask = null;
            if (gameDecision.equals("1")) {
                ask = game.askForCard(currentHand);
            } else if (gameDecision.equals("2")) {
                ask = steev.ask(currentHand);

            }
            System.out.println("You asked for: " + ask);

            boolean done = false;
            boolean otherPlayerHasCard = false;
            while (!done) {
                if (game.checkForCard(currentHand, ask)) {      // Check if the player has the card they asked for
                    if (game.checkForCard(opponentHand, ask)) {     // Check if the opponent has that card as well
                        System.out.println("The opponent has that card!");
                        otherPlayerHasCard = true;
                    } else {
                        System.out.println("The opponent doesn't have that card. Go fish!");
                    }
                    done = true;
                } else {      // If the player doesn't have the card they asked for
                    System.out.println("You don't seem to have that card. Try again.");
                    ask = game.askForCard(currentHand);
                    System.out.println("You asked for: " + ask);
                }
            }

            if (otherPlayerHasCard) {
                // Remove the card from the opponent's hand and add it to the player's hand
                opponentHand = game.removeCardFromHand(opponentHand, opponentHand[game.cardIndex]);
                currentHand = game.addCardToHand(currentHand, game.getCardsToRemove());
                System.out.println("You now have the following cards: " + Arrays.toString(currentHand));
                System.out.println("Opponent now has the following cards: " + Arrays.toString(opponentHand));
            } else {
                currentHand = game.goFish(currentHand);
                System.out.println("You now have the following cards: " + Arrays.toString(currentHand));
            }

            boolean hasFullSet = game.checkFullSet(currentHand);
            System.out.println("Full sets in your hand: " + hasFullSet);
            System.out.println();
            if (hasFullSet) {       // Remove the cards of the full set and add points
                currentHand = game.removeCardFromHand(currentHand, game.fullSetCard);
                playerPoints++;
                System.out.println("You now have " + playerPoints + " points.");
                System.out.println();
            }

            // OPPONENT'S TURN
            // Opponent asks the opponent for a card with this
            ask = steev.ask(opponentHand);
            System.out.println("Steev asked for: " + ask);

            done = false;
            otherPlayerHasCard = false;
            while (!done) {
                if (game.checkForCard(opponentHand, ask)) {     // Check if the opponent has the card they asked for
                    if (game.checkForCard(currentHand, ask)) {     // Check if the player has that card as well
                        System.out.println("You have that card!");
                        otherPlayerHasCard = true;
                    } else {
                        System.out.println("You don't have that card. Steev has to go fish!");
                    }
                    done = true;
                } else {    // If the player doesn't have the card they asked for
                    System.out.println("Steev asked for a card he doesn't seem to have. He'll have to try again.");
                    ask = steev.ask(opponentHand);
                    System.out.println("Steev asked for: " + ask);
                }
            }

            if (otherPlayerHasCard) {
                // Remove the card from the player's hand and add it to the opponent's hand
                currentHand = game.removeCardFromHand(currentHand, currentHand[game.cardIndex]);
                opponentHand = game.addCardToHand(opponentHand, game.getCardsToRemove());
                System.out.println("You now have the following cards: " + Arrays.toString(currentHand));
                System.out.println("Opponent now has the following cards: " + Arrays.toString(opponentHand));
            } else {
                opponentHand = game.goFish(opponentHand);
                // Temporary
                System.out.println("Steev now has the following cards: " + Arrays.toString(opponentHand));
            }

            hasFullSet = game.checkFullSet(opponentHand);
            System.out.println("Full sets in Steev's hand: " + hasFullSet);
            if (hasFullSet) {       // Remove the cards of the full set and add points
                opponentHand = game.removeCardFromHand(opponentHand, game.fullSetCard);
                opponentPoints++;
                System.out.println("The opponent now has " + opponentPoints + " points.");
                System.out.println();
            }
        }

        // Announce the winner and end the game
        if (playerPoints == Integer.parseInt(pointsToPlayTo)) {
            System.out.println("\nYou won the game! Congratulations!");
        } else {
            System.out.println("\nSteev won this game... Better luck next time");
        }
    }
}


