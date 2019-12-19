public class Deck {
    // Instance variables
    int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    String[] fullDeck = new String[52];

    // Constructor
    Deck() {}

    // Method to create full deck of cards by joining the ranks and suits arrays
    String[] createDeck() {
        int cardNumber = 0;
        for (int rank : ranks) {
            for (String suit : suits) {
                if (rank == 1) {
                    fullDeck[cardNumber] = "Ace" + " of " + suit;
                } else if (rank == 11) {
                    fullDeck[cardNumber] = "Jack" + " of " + suit;
                } else if (rank == 12) {
                    fullDeck[cardNumber] = "Queen" + " of " + suit;
                } else if (rank == 13) {
                    fullDeck[cardNumber] = "King" + " of " + suit;
                } else {
                    fullDeck[cardNumber] = rank + " of " + suit;
                }
                cardNumber++;
            }
        }
        return fullDeck;
    }
}
