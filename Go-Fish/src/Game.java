import java.util.Scanner;

public class Game {
    // Instance variables
    Scanner input = new Scanner(System.in);
    int cardIndex = 0;

    // Constructor
    Game() {}

    // Method to ask for a card
    String askForCard() {
        String cardRank = null;
        boolean done = false;
        while (!done) {
            System.out.println("Enter the rank of the card you would like: ");
            cardRank = input.nextLine();
            cardRank = cardRank.substring(0, 1).toUpperCase() + cardRank.substring(1);
            if (!cardRank.equals("Ace") && !cardRank.equals("2") && !cardRank.equals("3") && !cardRank.equals("4") && !cardRank.equals("5") && !cardRank.equals("6") && !cardRank.equals("7") && !cardRank.equals("8") && !cardRank.equals("9") && !cardRank.equals("10") && !cardRank.equals("Jack") && !cardRank.equals("Queen") && !cardRank.equals("King")) {
                System.out.println("That isn't a valid card.");
            } else {
                done = true;
            }
        }
        return cardRank;
    }

    // Method to check for card in a given deck
    boolean checkForCard(String[] givenDeck, String cardToCheckFor) {
        boolean check = false;
        for (int i = 0; i < givenDeck.length; i++) {
            String s = givenDeck[i];
            check = s.contains(cardToCheckFor);
            if (check) {
                cardIndex = i;
                break;
            }
        }
        return check;
    }

    // Method to add card to current hand
    String[] addCardToHand(String[] currentHand, String cardToAdd) {
        String[] newHand = new String[currentHand.length + 1];
        System.arraycopy(currentHand, 0, newHand, 0, currentHand.length);
        newHand[currentHand.length] = cardToAdd;
        return newHand;
    }

    // Method to remove card from current hand
    String[] removeCardFromHand(String[] currentHand, String cardToRemove) {
        // TODO: Bug occurs where if the opponent has more than one of the same rank of card, the player only gets one of them
        String[] newHand = new String[currentHand.length];
        for (int i = 0; i < newHand.length; i++) {
            if (!currentHand[i].equals(cardToRemove)) {
                newHand[i] = currentHand[i];
            }
        }

        int nullCount = 0;
        for (String s : newHand) {
            if (s == null) {
                nullCount++;
            }
        }

        newHand = new String[currentHand.length - nullCount];
        for (int k = 0; k < newHand.length; k++) {
            if (currentHand[k] != null) {
                newHand[k] = currentHand[k];
            }
        }
        return newHand;
    }
}
