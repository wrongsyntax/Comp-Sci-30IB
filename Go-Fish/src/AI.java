import java.util.Random;

public class AI {
    // Instance variables
    Random random = new Random();
    String[] hand;

    // Constructor
    AI(String[] hand) {
        this.hand = hand;
    }

    // Method to choose a card to ask for
    String ask() {
        String ask = hand[random.nextInt(hand.length)];
        String[] fullCard = ask.split(" ");
        return fullCard[0];
    }
}
