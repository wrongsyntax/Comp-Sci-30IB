import java.util.Random;

public class Player {
    // Instance variables
    String[] currentHand = new String[5];
    String[] deck;
    Random random = new Random();

    // Constructor
    Player(String[] fullDeck) {
        this.deck = fullDeck;
    }

    // Method to get cards dealt
    String[] getDealtCards() {
        for (int i = 0; i < currentHand.length; i++) {
            int randInt = random.nextInt(52);
            if (deck[randInt] != null) {
                currentHand[i] = deck[randInt];
                deck[randInt] = null;
            } else {
                i--;
            }
        }
        return currentHand;
    }
}
