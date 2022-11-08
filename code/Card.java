/**
 * Class Card: describes Card objects in a game of blackjack.
 * @author aaravshah026
 * @version 1.1
 */
public class Card {

    private CardValue value;
    private CardSuit suit;

    /**
     * Constructor for Card objects.
     * @param value CardValue representing the value of the Card
     * @param suit CardSuit representing the suit of the Card
     */
    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("The %s of %s", this.value.toString().toLowerCase(), this.suit.toString().toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if ((this.getSuit() != ((Card) o).getSuit()) || (this.getValue() != ((Card) o).getValue()))
            return false;
        return true;
    }

    public boolean valueEquals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (this.getValue() != ((Card) o).getValue())
            return false;
        return true;
    }

    /**
     * Getter for the suit of the Card.
     * @return CardSuit representing the suit of the Card
     */
    public CardSuit getSuit() {
        return this.suit;
    }

    /**
     * Getter for the value of the Card.
     * @return CardValue representing the value of the Card
     */
    public CardValue getValue() {
        return this.value;
    }
}
