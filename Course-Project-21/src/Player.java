import java.util.Scanner;

class Player {
    // Instance Variables
    private String name;
    private Scanner scanner = new Scanner(System.in);
    private int cardOneID;
    private String cardDrawnOne;
    private int cardTwoID;
    private String cardDrawnTwo;
    private int cardThreeID;
    private String cardDrawnThree;

    // Constructor
    Player() {
        name = "";
        points = 0;
        cardOneID = 0;
        cardTwoID = 0;
        cardThreeID = 0;
        cardDrawnOne = "";
        cardDrawnTwo = "";
        cardDrawnThree = "";
    }

    // Method to set the name of the player
    void setName() {
        name = scanner.nextLine();
    }

    // Methods to set the values for the cards
    void setCardOneID(int ID) {
        cardOneID = ID;
    }
    void setCardTwoID(int ID) {
        cardTwoID = ID;
    }
    void setCardThreeID(int ID) {
        cardThreeID = ID;
    }
    void setCardDrawnOne(String card) {
        cardDrawnOne = card;
    }
    void setCardDrawnTwo(String card) {
        cardDrawnTwo = card;
    }
    void setCardDrawnThree(String card) {
        cardDrawnThree = card;
    }

    // Getter methods for the cards, points, and name
    int getCardOneID() {
        return cardOneID;
    }
    int getCardTwoID() {
        return cardTwoID;
    }
    int getCardThreeID() {
        return cardThreeID;
    }
    String getName() {
        return name;
    }
    String getCardDrawnOne() {
        return cardDrawnOne;
    }
    String getCardDrawnTwo() {
        return cardDrawnTwo;
    }
    String getCardDrawnThree() {
        return cardDrawnThree;
    }
}
