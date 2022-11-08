/**
 * Enumeration CardSuit: describes the suit of a card.
 * @author aaravshah026
 * @version 1.0
 */
enum CardSuit {
    HEARTS   ("Hearts"),
    DIAMONDS ("Diamonds"),
    CLUBS    ("Clubs"),
    SPADES   ("Spades");

    private final String suit;

    /**
     * Constructor for enum CardSuit.
     * @param suit String representing the suit of the card
     */
    private CardSuit(String suit) {
        this.suit = suit;
    }

    /**
     * Getter for String name.
     * @return String representing the name of the card
     */
    public String toString() {
        return this.suit;
    }
}
