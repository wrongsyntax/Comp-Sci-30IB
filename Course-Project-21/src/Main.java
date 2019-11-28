import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instance variables
        Game game = new Game();
        // player one instance variables
        Player playerOne = new Player();
        String playerOneName;
        int playerOnePoints = 0;
        // player two instance variables
        Player playerTwo = new Player();
        String playerTwoName;
        int playerTwoPoints = 0;
        // ai instance variables
        AI steev = new AI();
        String playAgain = "y";
        String anotherCardDecision;
        Scanner scanner = new Scanner(System.in);
        String gameType = "";
        int gameTypeInt = 0;

        // Print out the instructions
        System.out.println("Welcome to the game of 21!");
        System.out.println("In this game, you will be dealt two cards.");
        System.out.println("After that, you will be able to decide if you want to stay with those two cards or be dealt a third.");
        System.out.println("The goal of the game is to get as close to 21 points as possible w/out going over.");
        System.out.println("Points are awarded as follows:");
        System.out.println("An ace is worth 1 or 11 points, face cards give you 10 points, and all other cards (excluding Joker) are worth the amount on the card.");

        System.out.println("Would you like to play a one player or two player game? (1/2)");
        boolean done = false;
        gameType = scanner.nextLine();
        while (!done) {
            if (gameType.equals("1") || gameType.equals("2")) {
                try {
                    gameTypeInt = Integer.parseInt(gameType);
                    done = true;
                } catch (Exception e) {
                    System.out.println("Please enter only 1 or 2");
                    gameType = scanner.nextLine();

                }
            } else {
                System.out.println("Please enter only 1 or 2");
                gameType = scanner.nextLine();
            }
        }

        if (gameTypeInt == 1) {
            // One player game logic
            // Get the player's name
            System.out.println("Please enter your name: ");
            playerOne.setName();
            playerOneName = playerOne.getName();
            playerTwoName = "Steev";

            // Introduce the opponent
            System.out.println("You will be facing Steev, a super smart AI that does stuff based on randomly generated numbers.");

            while (!playAgain.equals("n")) {
                // Draw the first two cards
                playerOne.setCardDrawnOne(game.drawCard());
                playerOne.setCardOneID(game.getCardID());
                playerOne.setCardDrawnTwo(game.drawCard());
                playerOne.setCardTwoID(game.getCardID());
                System.out.println("\n" + playerOneName + " drew the following two cards: \n" + playerOne.getCardDrawnOne() + "\n and \n" + playerOne.getCardDrawnTwo());
                playerOnePoints = game.getPointsForCard(playerOne.getCardOneID()) + game.getPointsForCard(playerOne.getCardTwoID());
                System.out.println(playerOneName + " got " + playerOnePoints + " points from those two cards.");

                // Ask player one if they want another card if they have less than 21 points
                if (playerOnePoints < 21) {
                    System.out.println(playerOneName + ", you got less than 21 points. Would you like to draw another card?");
                    anotherCardDecision = game.getThirdCardDecision();
                    if (anotherCardDecision.equals("y")) {
                        playerOne.setCardDrawnThree(game.drawCard());
                        playerOne.setCardThreeID(game.getCardID());
                        System.out.println("The new card you drew is the " + playerOne.getCardDrawnThree());
                        playerOnePoints += game.getPointsForCard(playerOne.getCardThreeID());
                        System.out.println(playerOneName + " now has " + playerOnePoints + " points.");
                    } else if (anotherCardDecision.equals("n")) {
                        System.out.println("Okay then, you still have " + playerOnePoints + " points.");
                    }
                }

                // Draw the first two cards for player two
                steev.setCardDrawnOne(game.drawCard());
                steev.setCardOneID(game.getCardID());
                steev.setCardDrawnTwo(game.drawCard());
                steev.setCardTwoID(game.getCardID());
                System.out.println("\n" + playerTwoName + " drew the following two cards: \n" + steev.getCardDrawnOne() + "\n and \n" + steev.getCardDrawnTwo());
                if (steev.getCardOneID() != 1 && steev.getCardTwoID() != 1) {
                    playerTwoPoints = game.getPointsForCard(steev.getCardOneID()) + game.getPointsForCard(steev.getCardTwoID());
                } else if (steev.getCardOneID() == 1 && steev.getCardTwoID() != 1) {
                    playerTwoPoints = steev.aceDecision() + game.getPointsForCard(steev.getCardTwoID());
                } else if (steev.getCardOneID() != 1 && steev.getCardTwoID() == 1) {
                    playerTwoPoints = game.getPointsForCard(steev.getCardTwoID() + steev.aceDecision());
                } else if (steev.getCardOneID() == 1 && steev.getCardTwoID() == 1) {
                    playerTwoPoints = steev.aceDecision() + steev.aceDecision();
                }
                System.out.println(playerTwoName + " got " + playerTwoPoints + " points from those two cards.");


                // Ask player two if they want another card if they have less than 21 points
                if (playerTwoPoints < 21) {
                    System.out.println(playerTwoName + " got less than 21 points.");
                    anotherCardDecision = steev.thirdCardDecision();
                    if (anotherCardDecision.equals("y")) {
                        steev.setCardDrawnThree(game.drawCard());
                        steev.setCardThreeID(game.getCardID());
                        System.out.println("Steev chose to draw another card and got the " + steev.getCardDrawnThree());
                        if (steev.getCardThreeID() == 1) {
                            playerTwoPoints += steev.aceDecision();
                        } else if (steev.getCardThreeID() != 1) {
                            playerTwoPoints += game.getPointsForCard(steev.getCardThreeID());
                        }
                        System.out.println(playerTwoName + " now has " + playerTwoPoints + " points.");
                    } else if (anotherCardDecision.equals("n")) {
                        System.out.println(playerTwoName + " chose not to draw another card and still has " + playerTwoPoints);
                    }
                }

                // Determine the winner through a series of if statements
                System.out.println("\nNow that both players have their cards, let's see who won: ");
                if (playerOnePoints > 21 && playerTwoPoints > 21) {
                    System.out.println("It seems that both players got more than 21 points! It seems you'll have to play another round to determine a winner.");
                } else if (playerOnePoints > 21 && playerTwoPoints < 21) {
                    System.out.println(playerOneName + " got more than 21 points but " + playerTwoName + " didn't. " + playerTwoName + " wins!");
                } else if (playerOnePoints < 21 && playerTwoPoints > 21) {
                    System.out.println(playerTwoName + " got more than 21 points. " + playerOneName + " wins this round!");
                } else if (playerOnePoints < 21 && playerTwoPoints < 21) {
                    // Use the difference between the points to determine the winner if both players have less than 21 points
                    if ((playerOnePoints - playerTwoPoints) > 0) {
                        System.out.println(playerOneName + " got closer to 21 without going over, so they won!");
                    } else if ((playerOnePoints - playerTwoPoints) < 0) {
                        System.out.println(playerTwoName + " got closer to 21 points without going over so they win this time!");
                    } else if (playerOnePoints == playerTwoPoints) {
                        System.out.println("Both players got the same points. It's a tie!");
                    }
                } else if (playerOnePoints == 21 && playerTwoPoints != 21) {
                    System.out.println(playerOneName + " got exactly 21 points! They win!");
                } else if (playerOnePoints != 21 && playerTwoPoints == 21) {
                    System.out.println(playerTwoName + " got exactly 21 points! They win!");
                }

                playAgain = game.getPlayAgain();
            }
        } else if (gameTypeInt == 2) {
            // Two player game logic
            // Player stuff
            System.out.println("\nPlease enter player one's name: ");
            playerOne.setName();
            playerOneName = playerOne.getName();
            System.out.println("Please enter player two's name: ");
            playerTwo.setName();
            playerTwoName = playerTwo.getName();

            while (!playAgain.equals("n")) {
                // Draw the first two cards for player one
                playerOne.setCardDrawnOne(game.drawCard());
                playerOne.setCardOneID(game.getCardID());
                playerOne.setCardDrawnTwo(game.drawCard());
                playerOne.setCardTwoID(game.getCardID());
                System.out.println("\n" + playerOneName + " drew the following two cards: \n" + playerOne.getCardDrawnOne() + "\n and \n" + playerOne.getCardDrawnTwo());
                playerOnePoints = game.getPointsForCard(playerOne.getCardOneID()) + game.getPointsForCard(playerOne.getCardTwoID());
                System.out.println(playerOneName + " got " + playerOnePoints + " points from those two cards.");

                // Ask player one if they want another card if they have less than 21 points
                if (playerOnePoints < 21) {
                    System.out.println(playerOneName + ", you got less than 21 points. Would you like to draw another card?");
                    anotherCardDecision = game.getThirdCardDecision();
                    if (anotherCardDecision.equals("y")) {
                        playerOne.setCardDrawnThree(game.drawCard());
                        playerOne.setCardThreeID(game.getCardID());
                        System.out.println("The new card you drew is the " + playerOne.getCardDrawnThree());
                        playerOnePoints += game.getPointsForCard(playerOne.getCardThreeID());
                        System.out.println(playerOneName + " now has " + playerOnePoints + " points.");
                    } else if (anotherCardDecision.equals("n")) {
                        System.out.println("Okay then, you still have " + playerOnePoints + " points.");
                    }
                }

                // Draw the first two cards for player two
                playerTwo.setCardDrawnOne(game.drawCard());
                playerTwo.setCardOneID(game.getCardID());
                playerTwo.setCardDrawnTwo(game.drawCard());
                playerTwo.setCardTwoID(game.getCardID());
                System.out.println("\n" + playerTwoName + " drew the following two cards: \n" + playerTwo.getCardDrawnOne() + "\n and \n" + playerTwo.getCardDrawnTwo());
                playerTwoPoints = game.getPointsForCard(playerTwo.getCardOneID()) + game.getPointsForCard(playerTwo.getCardTwoID());
                System.out.println(playerTwoName + " got " + playerTwoPoints + " points from those two cards.");

                // Ask player two if they want another card if they have less than 21 points
                if (playerTwoPoints < 21) {
                    System.out.println(playerTwoName + ", you got less than 21 points. Would you like to draw another card?");
                    anotherCardDecision = game.getThirdCardDecision();
                    if (anotherCardDecision.equals("y")) {
                        playerTwo.setCardDrawnThree(game.drawCard());
                        playerTwo.setCardThreeID(game.getCardID());
                        System.out.println("The new card you drew is the " + playerTwo.getCardDrawnThree());
                        playerTwoPoints += game.getPointsForCard(playerTwo.getCardThreeID());
                        System.out.println(playerTwoName + " now has " + playerTwoPoints + " points.");
                    } else if (anotherCardDecision.equals("n")) {
                        System.out.println("Okay then, you still have " + playerTwoPoints + " points.");
                    }
                }

                // Determine the winner through a series of if statements
                System.out.println("\nNow that both players have their cards, let's see who won: ");
                if (playerOnePoints > 21 && playerTwoPoints > 21) {
                    System.out.println("It seems that both players got more than 21 points! It seems you'll have to play another round to determine a winner.");
                } else if (playerOnePoints > 21 && playerTwoPoints < 21) {
                    System.out.println(playerOneName + " got more than 21 points but " + playerTwoName + " didn't. " + playerTwoName + " wins!");
                } else if (playerOnePoints < 21 && playerTwoPoints > 21) {
                    System.out.println(playerTwoName + " got more than 21 points. " + playerOneName + " wins this round!");
                } else if (playerOnePoints < 21 && playerTwoPoints < 21) {
                    // Use the difference between the points to determine the winner if both players have less than 21 points
                    if ((playerOnePoints - playerTwoPoints) > 0) {
                        System.out.println(playerOneName + " got closer to 21 without going over, so they won!");
                    } else if ((playerOnePoints - playerTwoPoints) < 0) {
                        System.out.println(playerTwoName + " got closer to 21 points without going over so they win this time!");
                    } else if (playerOnePoints == playerTwoPoints) {
                        System.out.println("Both players got the same points. It's a tie!");
                    }
                } else if (playerOnePoints == 21 && playerTwoPoints != 21) {
                    System.out.println(playerOneName + " got exactly 21 points! They win!");
                } else if (playerOnePoints != 21 && playerTwoPoints == 21) {
                    System.out.println(playerTwoName + " got exactly 21 points! They win!");
                }

                playAgain = game.getPlayAgain();
            }
        }
    }
}
