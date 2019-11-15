import java.util.Random;
import java.util.Scanner;

public class Game {
    // Instance variables
    private Random random;
    private Scanner scanner;
    private int cardInt;
    private String card;
    private String[] possibleSuits = {"Diamonds", "Hearts", "Spades", "Clubs"};
    private String suitOnCard;

    // Constructor
    Game() {
        random = new Random();
        scanner = new Scanner(System.in);
        cardInt = 0;
        card = "";
        suitOnCard = "";
    }

    // Method to generate a random card
    String drawCard() {
        // Draw a random number the corresponds to a card
        cardInt = random.nextInt(13) + 1;
        if (cardInt == 1) {
            card = "Ace";
        } else if (cardInt > 1 && cardInt < 11) {
            // The number is converted to a string to be stored in the card variable
            card = String.valueOf(cardInt);
        } else if (cardInt == 11) {
            card = "Jack";
        } else if (cardInt == 12) {
            card = "Queen";
        } else if (cardInt == 13) {
            card = "King";
        }

        // Randomly determine the suit on the card drawn
        suitOnCard = possibleSuits[random.nextInt(4)];
        card = card + " of " + suitOnCard;

        return card;
    }

    // Method to get just the number associated with the card
    int getCardInt() {
        return cardInt;
    }
}
