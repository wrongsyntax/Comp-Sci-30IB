public class Main {
    public static void main(String[] args) {

        /*
        // instantiation of the objects
        Person bob = new Person ("Bob");
        Person stephanie = new Person ("Stephanie");
        Person emerson = new Person ("Emerson");

        bob.setHeight (175);
        bob.setWeight(80);
        stephanie.setHeight(250);
        stephanie.setWeight(50);
        emerson.setHeight(50);
        emerson.setWeight(300);

        System.out.println(bob.getName() + ", body mass index is " + String.format("%.2f", bob.bodyMassIndex()));
        System.out.println(stephanie.getName() + ", body mass index is " + String.format("%.2f", stephanie.bodyMassIndex()));
        System.out.println(emerson.getName() + ", body mass index is " + String.format("%.2f", emerson.bodyMassIndex()));
        */

        // Instantiation of Dice object
        Dice diceOne = new Dice(6);
        Dice diceTwo = new Dice(10);

        // Calling method too roll the dice
        int diceResult = diceOne.roll();
        System.out.println(diceResult);
        diceResult = diceTwo.roll();
        System.out.println(diceResult);
    }
}