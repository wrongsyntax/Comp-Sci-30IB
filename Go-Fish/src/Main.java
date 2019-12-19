import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player();

        String[] fullDeck = deck.createDeck();
        System.out.println(Arrays.toString(fullDeck));

        String[] currentHand = player.getDealtCards(fullDeck);
        System.out.println("You've been dealt the following cards: " + Arrays.toString(currentHand));
    }
}
