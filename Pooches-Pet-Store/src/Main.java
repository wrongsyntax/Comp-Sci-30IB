import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        String[] soundLevels = {"quiet", "moderate", "loud"};
        String[] directions = {"left", "right", "up", "down", "forwards", "backwards"};
        int randInt;

        // Instantiate objects
        Bird polly = new Bird("Polly", "black", 5.3f, 0.35f, "Bird Section", "green", "fruit eating", 20.3f);
        Cat whiskers = new Cat("Whiskers", "yellow", 2.5f, 6.1f, "Main Area", "black", "white", "medium", 5);
        Fish bubbles = new Fish("Bubbles", "blue", 0.9f, 0.024f, "Aquarium", true, true, "bony", "small");

        while (true) {
            randInt = rand.nextInt(13);
            switch (randInt) {
                case 0:
                    System.out.println(polly.squawk());
                    break;
                case 1:
                    System.out.println(polly.fly());
                    break;
                case 2:
                    System.out.println(whiskers.groom());
                    break;
                case 3:
                    System.out.println(whiskers.meow());
                    break;
                case 4:
                    System.out.println(whiskers.purr(soundLevels[rand.nextInt(soundLevels.length)]));
                    break;
                case 5:
                    System.out.println(bubbles.detectLight());
                    break;
                case 6:
                    System.out.println(bubbles.swim(directions[rand.nextInt(directions.length)]));
                    break;
                case 7:
                    System.out.println(polly.eat("sunflower seeds"));
                    break;
                case 8:
                    System.out.println(polly.sleep(rand.nextInt(12)));
                    break;
                case 9:
                    System.out.println(whiskers.eat("cat food"));
                    break;
                case 10:
                    System.out.println(whiskers.sleep(rand.nextInt(20)));
                    break;
                case 11:
                    System.out.println(bubbles.eat("fish food"));
                    break;
                case 12:
                    System.out.println(bubbles.sleep(rand.nextInt(3)));
                    break;
            }

            Thread.sleep(rand.nextInt(10000));
        }
    }
}
