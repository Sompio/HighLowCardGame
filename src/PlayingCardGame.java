/**
 * Per-Joel Sompio
 * Academy Java course
 * PlayingCardCame class.
 * This is the game logic.
 */

import java.util.Scanner;

public class PlayingCardGame {
    private PlayingCardDeck pcd = new PlayingCardDeck();
    Scanner scanner = new Scanner(System.in);

    private int playerScore = 0;
    private int aiScore = 0;

    public PlayingCardGame() {
        printMenu();
    }

    public void printMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("1: Play a game against the computer");
        System.out.println("2: Gamerules");
        System.out.println("3: Exit Game");
        System.out.println("---------------------------------------------------");
        int input = scanner.nextInt();
        chooseMenu(input);
    }

    public void printGameRules() {
        System.out.println("---------------------------------------------------");
        System.out.println("This game is all about having the higher number");
        System.out.println("on the cards. If both of the players card have an equal");
        System.out.println("number the game checks which one has the highest suit");
        System.out.println("---------------------------------------------------");
        printMenu();
    }

    public void chooseMenu(int index) {
        switch (index) {
            case 1:
                System.out.println("Starting game");
                playGame();
                break;
            case 2:
                printGameRules();
                break;
            case 3:
                System.out.println("Quitting game");
                System.exit(0);
        }
    }

    /**
     * playGame method. includes all logic of the game
     * instead of putting the used cards in the back of the deck
     * it removes the cards that are being played.
     * the game is over when the deck is empty.
      */
    public void playGame() {
        pcd.setCards();
        pcd.shuffleDeck(pcd.getCardDeck());

        while(!pcd.getCardDeck().isEmpty()) {
            System.out.println("press q to quit round");
            System.out.println("Is the next card hi/lo than the one showing");
            System.out.println(pcd.getTopCard().getSuit());
            System.out.println(pcd.getTopCard().getCardValue());
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            input = input.toLowerCase();

            if (input.equals("q")) {
                printMenu();
                int nextInput = scanner.nextInt();
                chooseMenu(nextInput);
            }

            if (input.equals("hi") || input.equals("lo")) {
                System.out.println("---------------------------------------------------");
                int playerCardValue = Integer.parseInt(pcd.getTopCard().getCardValue().toString());
                int currentCardIndex = pcd.getCardDeck().indexOf(pcd.getTopCard());
                int nextCardValue = Integer.parseInt(pcd.getNextCard(currentCardIndex).getCardValue().toString());
                int playerCardSuit = pcd.getSuitValue(pcd.getTopCard());
                int nextCardSuit = pcd.getSuitValue(pcd.getNextCard(currentCardIndex));

                System.out.println("playercard: " + playerCardValue);
                System.out.println("nextcat: " + nextCardValue);
                System.out.println("Suitplayer: " + playerCardSuit);
                System.out.println("suitnext: " + nextCardSuit);
                if (checkWin(input, playerCardValue, nextCardValue, playerCardSuit, nextCardSuit)) {
                    playerScore++;
                    if (aiScore == 0) {
                        aiScore = 0;
                    } else aiScore--;
                } else {
                    aiScore++;
                    if (playerScore == 0) {
                        playerScore = 0;
                    } else {
                        playerScore--;
                    }
                }
                pcd.getCardDeck().remove(pcd.getNextCard(currentCardIndex));
                pcd.getCardDeck().remove(pcd.getTopCard());
                System.out.println("Playerscore: " + playerScore);
                System.out.println("AIScore: " + aiScore);
                System.out.println("---------------------------------------------------");

            } else {
                System.out.println("Invalid input, use 'hi' or 'lo'");
            }
        }

        System.out.println("---------------------------------------------------");
        System.out.println("Game is done. Winner is: ");
        if (playerScore > aiScore) {
            System.out.println("Player with a score of: " + playerScore);
            System.out.println("AI looses with a score of: " + aiScore);
        } else {
            System.out.println("AI with a score of: " + aiScore);
            System.out.println("Player looses with a score of: " + playerScore);
        }
        System.out.println("---------------------------------------------------");
        rematch();

    }
    public boolean checkWin(String input, int playerCardValue, int nextCardValue, int playerCardSuit, int nextCardSuit) {
        if(input.equals("hi")) {
            if(playerCardValue == nextCardValue) {
                if(playerCardSuit > nextCardSuit) {
                    System.out.println("win on suit");
                    return true;
                } else {
                    System.out.println("loss on suit");
                    return false;
                }
            }
            else if(playerCardValue > nextCardValue) {
                System.out.println("Winnnnnnn");
                return true;
            } else {
                System.out.println("loss");
                return false;
            }
        } else if(input.equals("lo")) {
            if(playerCardValue == nextCardValue) {
                if(playerCardSuit < nextCardSuit) {
                    System.out.println("winn on lo suit");
                    return true;
                } else {
                    System.out.println("loss on suit");
                    return false;
                }
            } else if(playerCardValue < nextCardValue) {
                System.out.println("winn on lo");
                return true;
            } else {
                System.out.println("loss on lo");
                return false;
            }
        }
        return false;
    }

    private void rematch() {
        System.out.println("would you like to play again? y/n");
        String input = scanner.next();
        if(input.equals("y") || input.equals("n")) {
            if(input.equals("y")) {
                printMenu();
            } else {
                System.out.println("Quitting game");
                System.exit(0);
            }
        } else {
            System.out.println("Wrong input");
            rematch();
        }

    }
}
