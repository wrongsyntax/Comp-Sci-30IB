import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player();
        Player opponent = new Player();
        Game game = new Game();
        String[] drawPile;
        String[] fullDeck = deck.createDeck();

        String[] currentHand = player.getDealtCards(fullDeck);
        System.out.println("You've been dealt the following cards: " + Arrays.toString(currentHand));

        String[] opponentHand = opponent.getDealtCards(fullDeck);
        System.out.println("Leaked info - opponent's hand: " + Arrays.toString(opponentHand));

        drawPile = fullDeck;

        String ask = game.askForCard();
        System.out.println("You asked for: " + ask);

        boolean done = false;
        boolean otherPlayerHasCard = false;
        while (!done) {
            if (game.checkForCard(currentHand, ask)) {
                if (game.checkForCard(opponentHand, ask)) {
                    System.out.println("The opponent has that card!");
                    otherPlayerHasCard = true;
                } else {
                    System.out.println("The opponent doesn't have that card. Go fish!");
                }
                done = true;
            } else {
                System.out.println("You don't seem to have that card. Try again.");
                ask = game.askForCard();
                System.out.println("You asked for: " + ask);
            }
        }

        if (otherPlayerHasCard) {
            currentHand = game.addCardToHand(currentHand, opponentHand[game.cardIndex]);
            opponentHand = game.removeCardFromHand(opponentHand, opponentHand[game.cardIndex]);
            System.out.println("You now have the following cards: " + Arrays.toString(currentHand));
            System.out.println("Opponent now has the following cards: " + Arrays.toString(opponentHand));
        }
    }
}
