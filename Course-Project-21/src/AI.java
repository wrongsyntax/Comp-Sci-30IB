import java.util.Random;

public class AI {
    private String name = "Steev";
    private int cardOneID;
    private String cardDrawnOne;
    private int cardTwoID;
    private String cardDrawnTwo;
    private int cardThreeID;
    private String cardDrawnThree;
    private Random decider = new Random();
    private int intDecision;
    private String stringDecision;

    // Constructor
    AI() {
        cardOneID = 0;
        cardTwoID = 0;
        cardThreeID = 0;
        cardDrawnOne = "";
        cardDrawnTwo = "";
        cardDrawnThree = "";
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

    // Methods to make decisions
    int aceDecision() {
        intDecision = decider.nextInt(2);
        if (intDecision == 0) {
            intDecision = 1;
        } else if (intDecision == 1) {
            intDecision = 11;
        }
        return intDecision;
    }

    String thirdCardDecision() {
        intDecision = decider.nextInt(2);
        if (intDecision == 0) {
            stringDecision = "y";
        } else if (intDecision == 1) {
            stringDecision = "n";
        }
        return stringDecision;
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
