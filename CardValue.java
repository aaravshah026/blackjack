/**
 * Enumeration CardValue: describes the value of a card.
 * @author aaravshah026
 * @version 1.0
 */
enum CardValue {
    ACE     ("Ace",   11),
    TWO     ("2",     2),
    THREE   ("3",     3),
    FOUR    ("4",     4),
    FIVE    ("5",     5),
    SIX     ("6",     6),
    SEVEN   ("7",     7),
    EIGHT   ("8",     8),
    NINE    ("9",     9),
    TEN     ("10",    10),
    JACK    ("Jack",  10),
    QUEEN   ("Queen", 10),
    KING    ("King",  10);

    private final String name;
    private final int value;

    /**
     * Constructor for enum CardValue.
     * @param name String representing the name of the card
     * @param value int representing the value of the card
     */
    private CardValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter for String name.
     * @return String representing the name of the card
     */
    public String toString() {
        return this.name;
    }

    /**
     * Getter for int value.
     * @return int representing the value of the card
     */
    public int getValue() {
        return this.value;
    }
}