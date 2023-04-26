/**
 * Card.java
 * Class representing a Card in a standard deck of cards.
 * 
 * @author Aarav Shah
 * @version 1.0
 */

public class Card {

    enum COLOR {
        RED,
        BLACK
    }

    enum SUIT {
        HEARTS(COLOR.RED),
        DIAMONDS(COLOR.RED),
        SPADES(COLOR.BLACK),
        CLUBS(COLOR.BLACK);

        public final COLOR color;

        private SUIT(COLOR c) {
            color = c;
        }
        private COLOR getColor() {
            return color;
        }
    }


    enum NUMBER {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10);

        public final int value;
        private NUMBER(int v) {
            value = v;
        }
        private int getValue() {
            return value;
        }
    }

    private final SUIT suit;
    private final NUMBER number;

    /**
     * Constructor method for the Card.
     * @param s the SUIT of the Card
     * @param n the NUMBER of the Card
     */
    public Card(SUIT s, NUMBER n) {
        this.suit = s;
        this.number = n;
    }

    /**
     * Getter method for the SUIT of the Card.
     * @return the SUIT of the Card
     */
    public SUIT getSuit() {
        return suit;
    }

    /**
     * Getter method for the COLOR of the Card.
     * @return the COLOR of the Card
     */
    public COLOR getColor() {
        return suit.getColor();
    }

    /**
     * Getter method for the NUMBER of the Card.
     * @return the NUMBER of the Card
     */
    public NUMBER getNumber() {
        return number;
    }

    /**
     * Getter method for the integer value of the Card.
     * @return int value of the Card
     */
    public int getValue() {
        return number.getValue();
    }

    /**
     * Method for determining whether another Card is equal to this Card.
     * @param c the other Card to compare this Card to
     * @return boolean representing whether the Cards are equal or not
     */
    public boolean isEqual(Card c) {
        return ((c.getSuit() == suit)  && (c.getNumber() == number));
    }

    /**
     * Method for getting the String representation of the Card.
     * @return String representation of the Card
     */
    public String toString() {
        return "the " + number.toString() + " of " + suit.toString();
    }
}
