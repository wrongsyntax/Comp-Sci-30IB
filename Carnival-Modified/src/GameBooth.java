import java.lang.Math;

public class GameBooth {
    private double cost;
    private String firstPrize, consolationPrize;
    private int firstPrizesWon;
    private int consolationPrizesWon;

    public GameBooth(double charge, String p1, String p2) {
        cost = charge;
        firstPrize = p1;
        consolationPrize = p2;
        firstPrizesWon = 0;
        consolationPrizesWon = 0;
    }

    public String start() {
        int toss;
        int successes = 0;
        /* play game */
        for (int i = 0; i < 3; i++) { //player gets three tries
            toss = (int)(Math.random() + 0.5); //0 or 1
            if (toss == 1) {
                successes += 1; //1 is a successful toss
            }
        }
        if (successes == 3) {
            firstPrizesWon += 1;
            return(firstPrize);
        } else {
            consolationPrizesWon += 1;
            return(consolationPrize);
        }
    }

    public double getCost() {
        return(cost);
    }

    public int getFirstPrizesWon() {
        return firstPrizesWon;
    }

    public int getConsolationPrizesWon() {
        return consolationPrizesWon;
    }
}

