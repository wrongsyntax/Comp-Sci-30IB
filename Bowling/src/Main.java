public class Main {
    public static void main(String[] args) {
        // Instance variables
        Game game = new Game();
        Frame frame = new Frame();
        int randInt;
        int currentFrame = 1;
        int pinsLeft;
        int throwsLeft;
        int guess;
        int points = 0;
        int pinsKnockedDown = 0;

        // Print out the instructions of the game
        System.out.println("Welcome to Bowling!");
        System.out.println("In this version of the game, you will have to guess the randomly generated number between 1 and 10.");
        System.out.println("The closer you are to that number, the more pins you knock down. Simple, right?");
        System.out.println("If you guess the number exactly, that's a strike, which gets you 20 points.");
        System.out.println("Otherwise, each pin knocked down is worth one point, unless you get a spare, in which case you get 10 points. \n");

        // Play the game for all 10 frames
        while (currentFrame <= 10) {
            // Print information about the current frame
            System.out.println("\nFrame: " + currentFrame);
            System.out.println("Points: " + points);

            // Set up a new frame
            pinsLeft = frame.getPins();
            throwsLeft = frame.getThrowsLeft();

            while (throwsLeft != 0) {
                // Generate a random number, with the maximum possible being the number of pins left
                randInt = game.getRandomInt(pinsLeft);
                // Get the player's guess as to what the number is
                guess = game.rollBall(pinsLeft);
                // This variable is a bit ambiguous
                // It is the difference between the guess and the random integer
                // TODO: Points are awarded by how far you are from the number right now. This needs to be fixed
                pinsKnockedDown = Math.abs(guess - randInt);

                // Determine whether or not the player got a strike, spare, or just one point per pin
                if (guess == randInt && throwsLeft == 2) {
                    points += 20;
                    System.out.println("Strike!");
                    pinsLeft -= 10;
                    throwsLeft = 0;
                } else if (pinsKnockedDown > 0) {
                    System.out.println("You knocked down " + pinsKnockedDown + " pins.");
                    pinsLeft = pinsLeft - pinsKnockedDown;
                    if (pinsLeft == 0 && throwsLeft == 1) {
                        // TODO: Weird bug happens here if the random int is guessed correctly, the input goes into a unending loop asking for and input
                        System.out.println("Spare!");
                        points += 15;
                        throwsLeft -= 1;
                    } else {
                        points += Math.abs(randInt - guess);
                        throwsLeft -= 1;
                    }
                }
            }
            System.out.println("You knocked down " + (10 - pinsLeft) + " pins this frame.");

            // Move to the next frame
            currentFrame += 1;
        }

        // Print out the final score
        System.out.println("\n");
        System.out.println("In this game of bowling, you scored " + points + " points total.");
    }
}
