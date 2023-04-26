import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Deck {

    ArrayList<Card> deck;
    int numCards;

    /**
     * Constructor method for the Deck.
     */
    public Deck() {
        this.deck = new ArrayList<Card>();
        for (Card.SUIT s: Card.SUIT.values()) {
            for (Card.NUMBER n: Card.NUMBER.values()) {
                deck.add(new Card(s, n));
            }
        }
        this.numCards = 52;
        // creates a standard deck of 52 cards, each with a unique suit and number enum
    }

    /**
     * Copy constructor method for the Deck.
     * @param d The Deck to copy from
     */
    public Deck(Deck d) {
        this.numCards = d.getNumCards();
        this.deck = new ArrayList<Card>();
        this.deck.addAll(d.getDeck());
    }

    /**
     * Method for adding a Card to the Deck.
     * @throws IllegalArgumentException if the Card is already in the Deck
     * @param card the Card to add to the Deck
     */
    public void addCard(Card card) {
        if (this.containsCard(card)) {
            throw new IllegalArgumentException(card.toString() + " is already in the deck!");
        }
        numCards++;
        this.deck.add(card);
    }

    /**
     * Method for removing a random Card from the Deck.
     * @throws ArrayIndexOutOfBoundsException if the Deck is already empty
     * @return the Card that was removed
     */
    public Card removeCard() {
        if (this.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("cannot remove card from empty deck!");
        }
        int index = (int) (Math.random() * 51);
        numCards--;
        return deck.remove(index);
    }

    /**
     * Method for removing a specific Card from the Deck.
     * @throws ArrayIndexOutOfBoundsException if the Deck is already empty
     * @throws NoSuchElementException if the specified Card is not in the Deck
     * @param card the Card to remove from the Deck
     */
    public void removeCard(Card card) {
        if (this.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("cannot remove card from empty deck!");
        }
        if (!this.containsCard(card)) {
            throw new NoSuchElementException(card.toString() + " is not in the deck!");
        }
        numCards--;
        this.deck.remove(card);
    }

    /**
     * Method for determining whether a Card is present in the Deck.
     * @param card the Card to search for in the Deck
     * @return boolean representing whether the Card is present or not
     */
    public boolean containsCard(Card card) {
        for (Card c: this.deck) {
            if (c.isEqual(card)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for getting the specified Card out the Deck.
     * @param card the Card to search for in the Deck
     * @return the Card in the Deck that matches
     */
    public Card getCard(Card card) {
        for (Card c: this.deck) {
            if (c.isEqual(card)) {
                return c;
            }
        }
        throw new NoSuchElementException(card.toString() + " is not in the deck!");
    }

    /**
     * Getter method for the Deck.
     * @return the Deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Getter method for the number of Cards in the Deck.
     * @return the number of Cards in the Deck
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * Method for resetting the Deck to a standard Deck.
     */
    public void reset() {
        this.deck = new ArrayList<Card>();
        for (Card.SUIT s: Card.SUIT.values()) {
            for (Card.NUMBER n: Card.NUMBER.values()) {
                deck.add(new Card(s, n));
            }
        }
        this.numCards = 52;
    }
    // adds all cards back and resets numCards to 52 (standard deck size)

    /**
     * Method for determining if the Deck is empty.
     * @return boolean representing whether the Deck is empty or not
     */
    public boolean isEmpty() {
        return (numCards == 0);
    }
}
