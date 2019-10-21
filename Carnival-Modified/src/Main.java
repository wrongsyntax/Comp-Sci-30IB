public class Main {
    public static void main(String[] args) {
        GameBooth balloonDartToss = new GameBooth(2,"tiger plush", "sticker");
        GameBooth ringToss = new GameBooth(2,"bear keychain", "pencil");
        GameBooth breakAPlate = new GameBooth(1.5, "pig plush", "plastic dinosaur");
        Player shonda = new Player(5); //$5 spending money
        Player luis = new Player(3); //$3 spending money
        // Print info about players
        System.out.println("Shonda has $" + shonda.spendingMoney + " and does not have any prizes yet.");
        System.out.println("Luis has $" + luis.spendingMoney + " and does not have any prizes yet.");
        System.out.print("Shonda goes to Balloon Dart Toss. ");
        System.out.println(shonda.play(balloonDartToss));
        System.out.println("Shonda now has $" + shonda.spendingMoney + "and has won the following prizes: " + shonda.prizesWon);
        System.out.print("Luis goes to Ring Toss. ");
        System.out.println(luis.play(ringToss));
        System.out.println("Luis now has $" + luis.spendingMoney + " and has won the following prizes: " + luis.prizesWon);
        System.out.print("Shonda goes to Ring Toss. ");
        System.out.println(shonda.play(ringToss));
        System.out.println("Shonda now has $" + shonda.spendingMoney + "and has won the following prizes: " + shonda.prizesWon);
        System.out.print("Luis goes to Break A Plate. ");
        System.out.println(luis.play(breakAPlate));
        System.out.println("Luis now has $" + luis.spendingMoney + " and has won the following prizes: " + luis.prizesWon);
        System.out.println("Shonda won: " + shonda.showPrizes());
        System.out.println("Luis won: " + luis.showPrizes());

        // Print total prizes awarded overall
        int totalFirstPrizesWon = balloonDartToss.getFirstPrizesWon() + ringToss.getFirstPrizesWon() + breakAPlate.getFirstPrizesWon();
        System.out.println("The total number of first prizes won at the carnival is " + totalFirstPrizesWon);
        int totalConsolationPrizesWon = balloonDartToss.getConsolationPrizesWon() + ringToss.getConsolationPrizesWon() + breakAPlate.getConsolationPrizesWon();
        System.out.println("The total number of consolation prizes awarded at the carnival is " + totalConsolationPrizesWon);

        // Print prizes given out by specific booths
        int balloonDartTossFirstPrizesWon = balloonDartToss.getFirstPrizesWon();
        int balloonDartTossConsolationPrizesWon = balloonDartToss.getConsolationPrizesWon();
        int ringTossFirstPrizesWon = ringToss.getFirstPrizesWon();
        int ringTossConsolationPrizesWon = ringToss.getConsolationPrizesWon();
        int breakAPlateFirstPrizesWon = breakAPlate.getFirstPrizesWon();
        int breakAPlateConsolationPrizesWon = breakAPlate.getConsolationPrizesWon();
        System.out.println("Balloon Dart Toss gave away " + balloonDartTossFirstPrizesWon + " first prizes and " + balloonDartTossConsolationPrizesWon + " consolation prizes.");
        System.out.println("Ring Toss gave away " + ringTossFirstPrizesWon + " first prizes and " + ringTossConsolationPrizesWon + " consolation prizes.");
        System.out.println("Break a Plate gave away " + breakAPlateFirstPrizesWon + " first prizes and " + breakAPlateConsolationPrizesWon + " consolation prizes.");
    }
}
