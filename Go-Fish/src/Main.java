import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player();
        Player opponent = new Player();
        Game game = new Game();
        String[] drawPile;
        String[] fullDeck = deck.createDeck();

        // Deal the player's first five cards
        String[] currentHand = player.getDealtCards(fullDeck);
        System.out.println("You've been dealt the following cards: " + Arrays.toString(currentHand));

        // Deal the opponent's first five cards
        String[] opponentHand = opponent.getDealtCards(fullDeck);
        // This is temporary
        System.out.println("Leaked info - opponent's hand: " + Arrays.toString(opponentHand));

        // Update the draw pile to contain the remaining cards
        drawPile = fullDeck;

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
            currentHand = game.addCardToHand(currentHand, opponentHand[game.cardIndex]);
            opponentHand = game.removeCardFromHand(opponentHand, opponentHand[game.cardIndex]);
            System.out.println("You now have the following cards: " + Arrays.toString(currentHand));
            System.out.println("Opponent now has the following cards: " + Arrays.toString(opponentHand));
        } else {
            currentHand = game.goFish(drawPile, currentHand);
            System.out.println("You now have the following cards: " + Arrays.toString(currentHand));
        }

        boolean hasFullSet = game.checkFullSet(currentHand);
        System.out.println("Full sets in your hand: " + hasFullSet);
    }
}
