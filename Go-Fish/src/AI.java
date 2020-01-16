import java.util.Random;

public class AI {
    // Instance variables
    Random random = new Random();

    // Constructor
    AI() {}

    // Method to choose a card to ask for
    String ask(String[] hand) {
        String ask = hand[random.nextInt(hand.length)];
        String[] fullCard = ask.split(" ");
        return fullCard[0];
    }
}
