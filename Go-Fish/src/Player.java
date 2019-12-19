import java.util.Random;

public class Player {
    // Instance variables
    String[] currentHand = new String[5];
    Random random = new Random();

    // Constructor
    Player() {}

    // Method to get cards dealt
    String[] getDealtCards(String[] fullDeck) {
        for (int i = 0; i < currentHand.length; i++) {
            int randInt = random.nextInt(52);
            if (fullDeck[randInt] != null) {
                currentHand[i] = fullDeck[randInt];
                fullDeck[randInt] = null;
            } else {
                i--;
            }
        }
        return currentHand;
    }
}
