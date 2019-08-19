/**
 * Per-Joel Sompio
 * Academy Java course
 * PlayingCardDeck class. used as an arraylist to store
 * PlayingCard objects.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayingCardDeck {
    ArrayList<PlayingCard> deck = new ArrayList<>();

    /**
     * creating new Cards and giving them a value and suit
     */
    public void setCards() {
        for (Suits suit: Suits.values()) {
            for (CardValues value : CardValues.values()) {
                deck.add(new PlayingCard(suit, value));
            }
        }
    }

    public ArrayList<PlayingCard> getCardDeck() {
        return this.deck;
    }

    public void shuffleDeck(ArrayList list) {
        Collections.shuffle(list, new Random());
    }

    public PlayingCard getTopCard() {
        try {
            return this.deck.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * this method is useless for this program since it doesnt
     * delete any of the cards. and the whole game logic depends
     * on deleting cards as they are being used.
     *
     * @param playingCard1
     */
    public void putCardInTheEndOfDeck(PlayingCard playingCard1) {
        int index;
        for (PlayingCard card: deck) {
            if(card.equals(playingCard1)) {
                index = deck.indexOf(card);
                deck.set(index, deck.get(51));
                deck.set(51, playingCard1);
            }
        }
    }

    public void printOutDeck() {
        int counter = 0;

        for (PlayingCard card: deck) {
            counter++;
            System.out.println(card.getSuit());
            System.out.println(card.getCardValue());
            System.out.println();
        }
        System.out.println(counter + "number of cards");
    }

    /**
     * getNextCard method. takes an index as a parameter
     * and and returns the card which is next to the current card
     * @param index
     * @return
     */
    public PlayingCard getNextCard(int index) {
        try {
            return deck.get(index+1);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Deck is empty");
            System.out.println(deck.size());
        }
        return null;
    }

    /**
     * getSuitValue method.
     * This method assigns a value to the suits which is then used
     * as a comparator to see which card suit trumps the other one
     * @param card
     * @return
     */
    public int getSuitValue(PlayingCard card) {
        int value = 0;
        if (card.getSuit() == Suits.CLUBS) {
            value = 1;
        } else if (card.getSuit() == Suits.DIAMONDS) {
            value = 2;
        } else if (card.getSuit() == Suits.HEARTS) {
            value = 3;
        } else if (card.getSuit() == Suits.SPADES) {
            value = 4;
        }
        return value;
    }
}