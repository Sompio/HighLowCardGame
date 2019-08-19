/**
 * Per-Joel Sompio
 * Academy java course
 * Playingcard class. used as an object in an arraylist
 * getting its values from 2 Enums, Suits and CardValues
 */
public class PlayingCard {
    private Suits suit;
    private CardValues cardValue;

    public PlayingCard(Suits suit, CardValues cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;

    }

    public Suits getSuit() {
        return this.suit;
    }

    public CardValues getCardValue() {
        return this.cardValue;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public void setCardValue(CardValues value) {
        this.cardValue = value;
    }



}
