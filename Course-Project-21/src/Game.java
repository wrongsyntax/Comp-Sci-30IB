import java.util.Random;
import java.util.Scanner;

class Game {
    // Instance variables
    private Random random;
    private Scanner scanner;
    private int cardInt;
    private String card;
    private String[] possibleSuits = {"Diamonds", "Hearts", "Spades", "Clubs"};
    private String suitOnCard;
    private int aceDecision;
    private String thirdCardDecision;
    private String playAgain;
    private Boolean done = false;

    // Constructor
    Game() {
        random = new Random();
        scanner = new Scanner(System.in);
        cardInt = 0;
        card = "";
        suitOnCard = "";
        aceDecision = 0;
        thirdCardDecision = "";
        playAgain = "";
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

    // Method to ask the player if the ace will be 1 or 11 points
    private int getAceDecision() {
        System.out.println("Please enter how many points you would like your ace to be worth, 1 or 11 points: ");
        String aceDecisionString = scanner.nextLine();
        while (!done) {
            if (aceDecisionString.equals("1") || aceDecisionString.equals("11")) {
                try {
                    aceDecision = Integer.parseInt(aceDecisionString);
                    done = true;
                } catch (Exception e) {
                    System.out.println("Please enter only 1 or 11: ");
                    aceDecisionString = scanner.nextLine();
                }
            } else {
                System.out.println("Please enter only 1 or 11: ");
                aceDecisionString = scanner.nextLine();
            }
        }
        return aceDecision;
    }

    // Method to ask the player if they want a third card
    String getThirdCardDecision() {
        System.out.println("Please enter either y/n: ");
        thirdCardDecision = scanner.nextLine();
        while (!(thirdCardDecision.equals("y") || thirdCardDecision.equals("n"))) {
            System.out.println("Please enter only \"y\" or \"n\": ");
            thirdCardDecision = scanner.nextLine();
        }
        return thirdCardDecision;
    }

    // Method to ask player if they would like to play another round
    String getPlayAgain() {
        System.out.println("\nWould you like to play another round?");
        System.out.println("Please enter either y/n: ");
        playAgain = scanner.nextLine();
        while (!(playAgain.equals("y") || playAgain.equals("n"))) {
            System.out.println("Please enter only \"y\" or \"n\": ");
            playAgain = scanner.nextLine();
        }
        return playAgain;
    }

    // Method to return the points received for a card
    int getPointsForCard(int cardID) {
        int points;
        if (cardID == 1) {
            points = getAceDecision();
        } else if (cardID == 11 || cardID == 12 || cardID == 13) {
            points = 10;
        } else {
            points = cardID;
        }
        return points;
    }

    // Method to get just the number associated with the card
    int getCardID() {
        return cardInt;
    }
}
