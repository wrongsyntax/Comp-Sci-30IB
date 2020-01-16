import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player();
        Player opponent = new Player();
        String[] fullDeck = deck.createDeck();
        boolean playing = true;

        // Deal the player's first five cards
        String[] currentHand = player.getDealtCards(fullDeck);
        System.out.println("You've been dealt the following cards: " + Arrays.toString(currentHand));

        // Deal the opponent's first five cards
        String[] opponentHand = opponent.getDealtCards(fullDeck);
        AI steev = new AI();
        // This is temporary
        System.out.println("Leaked info - opponent's hand: " + Arrays.toString(opponentHand));

        // Update the draw pile to contain the remaining cards in the game class
        Game game = new Game(fullDeck);

        while (playing) {
            // Player asks the opponent for a card with this
            String ask = game.askForCard();
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
                } else {        // If the player doesn't have the card they asked for
                    System.out.println("You don't seem to have that card. Try again.");
                    ask = game.askForCard();
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

            // Opponent asks the opponent for a card with this
            ask = steev.ask(opponentHand);
            System.out.println("Steev asked for: " + ask);

            done = false;
            otherPlayerHasCard = false;
            while (!done) {
                if (game.checkForCard(opponentHand, ask)) {      // Check if the opponent has the card they asked for
                    if (game.checkForCard(currentHand, ask)) {     // Check if the player has that card as well
                        System.out.println("You have that card!");
                        otherPlayerHasCard = true;
                    } else {
                        System.out.println("You don't have that card. Steev has to go fish!");
                    }
                    done = true;
                } else {        // If the player doesn't have the card they asked for
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
                System.out.println("Steev now have the following cards: " + Arrays.toString(opponentHand));
            }

            hasFullSet = game.checkFullSet(opponentHand);
            System.out.println("Full sets in Steev's hand: " + hasFullSet);
        }
    }
}


