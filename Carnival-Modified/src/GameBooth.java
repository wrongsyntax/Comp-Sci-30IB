import java.lang.Math;

public class GameBooth {
    private double cost;
    private String firstPrize, consolationPrize;

    public GameBooth(double charge, String p1, String p2) {
        cost = charge;
        firstPrize = p1;
        consolationPrize = p2;
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
            return(firstPrize);
        } else {
            return(consolationPrize);
        }
    }

    public double getCost() {
        return(cost);
    }
}

