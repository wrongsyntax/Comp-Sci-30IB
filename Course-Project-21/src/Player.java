import java.util.Scanner;

public class Player {
    // Instance Variables
    private String name;
    private Scanner scanner = new Scanner(System.in);
    private int points;
    private int cardOneID;
    private int cardTwoID;
    private int cardThreeID;

    // Constructor
    Player() {
        name = scanner.nextLine();
        points = 0;
        cardOneID = 0;
        cardTwoID = 0;
        cardThreeID = 0;
    }

    // Methods to set the values for the card IDs
    void setCardOneID(int ID) {
        cardOneID = ID;
    }
    void setCardTwoID(int ID) {
        cardTwoID = ID;
    }
    void setCardThreeID(int ID) {
        cardThreeID = ID;
    }

    // Method to set the points for this player
    void setPoints(int inPoints) {
        points = inPoints;
    }

    // Getter methods for the IDs and points
    int getCardOneID() {
        return cardOneID;
    }
    int getCardTwoID() {
        return cardTwoID;
    }
    int getCardThreeID() {
        return cardThreeID;
    }
    int getPoints() {
        return points;
    }
}
