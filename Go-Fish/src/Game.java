import java.util.Random;
import java.util.Scanner;

public class Game {
    // Instance variables
    Random random = new Random();
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
            try {
                cardRank = cardRank.substring(0, 1).toUpperCase() + cardRank.substring(1);
            } catch (StringIndexOutOfBoundsException s) {
                System.out.println("ERROR: NO INPUT DETECTED");
            }
            if (!cardRank.equals("Ace") && !cardRank.equals("2") && !cardRank.equals("3") && !cardRank.equals("4") && !cardRank.equals("5") && !cardRank.equals("6") && !cardRank.equals("7") && !cardRank.equals("8") && !cardRank.equals("9") && !cardRank.equals("10") && !cardRank.equals("Jack") && !cardRank.equals("Queen") && !cardRank.equals("King")) {
                System.out.println("That isn't a valid card.");
            } else {
                done = true;
            }
        }
        return cardRank;
    }

    // Method to check for card in a given deck
    boolean checkForCard(String[] hand, String cardToCheckFor) {
        boolean check = false;
        for (int i = 0; i < hand.length; i++) {
            String s = hand[i];
            check = s.contains(cardToCheckFor);
            if (check) {
                cardIndex = i;
                break;
            }
        }
        return check;
    }

    // Method to add card to current hand
    String[] addCardToHand(String[] hand, String cardToAdd) {
        String[] newHand = new String[hand.length + 1];
        // Copy the cards already in hand
        System.arraycopy(hand, 0, newHand, 0, hand.length);
        // Add the new card
        newHand[hand.length] = cardToAdd;
        return newHand;
    }


    // Method to remove card from current hand
    String[] removeCardFromHand(String[] hand, String cardToRemove) {
        // FIXME: Bug occurs where if the opponent has more than one of the same rank of card, the player only gets one of them
        // -----------------------------------
        // TODO: Possible fix for bugs:
        /*
        The program works properly when the opponent only has one card of the rank that is asked for.
        If there is more than one card of the same rank, the program only detects one, since it's comparing the entire string,
        including the suit.
         */
        // -----------------------------------
        String[] newHand = new String[hand.length];
        for (int i = 0; i < newHand.length; i++) {
            if (!hand[i].equals(cardToRemove)) {
                newHand[i] = hand[i];
            }
        }

        // Count how many cards were taken from the hand
        int nullCount = 0;
        for (String s : newHand) {
            if (s == null) {
                nullCount++;
            }
        }

        // Remove the null elements from the array
        String[] temp = newHand;
        newHand = new String[hand.length - nullCount];
        int index = 0;
        for (int k = 0; k < temp.length; k++) {
            if (temp[k] != null) {
                newHand[index] = temp[k];
                index++;
            }
        }
        return newHand;
    }

    // Method to take a card from the draw pile
    String[] goFish(String[] drawPile, String[] hand) {
        String[] newHand = new String[hand.length + 1];
        System.arraycopy(hand, 0, newHand, 0, hand.length);
        // Pick up a random card from the draw pile b/c the draw pile is not shuffled: therefore can't take top card
        String cardToAdd = drawPile[random.nextInt(drawPile.length)];
        // Add the randomly drawn card to the hand if it isn't null
        boolean done = false;
        while (!done) {
            if (cardToAdd != null) {
                newHand[hand.length] = cardToAdd;
                done = true;
            } else {
                cardToAdd = drawPile[random.nextInt(drawPile.length)];
            }
        }
        return newHand;
    }

    // Method to check for a full set of cards
    boolean checkFullSet(String[] hand) {
        String[] cardToCheckFor;
        String[] cardBeingChecked;
        int numOfSet;
        boolean check = false;
        for (int i = 0; i < hand.length; i++) {
            numOfSet = 0;
            cardToCheckFor = hand[i].split(" ");
            for (int j = i; j < hand.length; j++) {
                cardBeingChecked = hand[j].split(" ");
                if (cardToCheckFor[0].equals(cardBeingChecked[0])) {        // Compare the ranks of both cards to determine if they are the same
                    numOfSet++;
                }
            }
            if (numOfSet == 4) {
                System.out.println("You have a full set!");
                check = true;
            }
        }
        return check;
    }
}
