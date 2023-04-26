import java.util.ArrayList;

/**
 * BlackjackHand.java
 * Class representing a standard Hand in Blackjack.
 *
 * @author Aarav Shah
 * @version 1.1
 */
public class BlackjackHand {

    ArrayList<Card> hand;
    int handValue;
    int numAces;
    int numCards;

    /**
     * Constructor method for BlackjackHand.
     */
    public BlackjackHand() {
        hand = new ArrayList<Card>();
        handValue = 0;
        numAces = 0;
        numCards = 0;
    }

    /**
     * Method for adding a card to the Hand. Calculates the hand value accordingly.
     * @param card Card to add to the hand
     */
    public void add(Card card) {
        hand.add(card);
        handValue += card.getValue();
        if (card.getNumber() == Card.NUMBER.ACE) {
            numAces++;
        }
        if (handValue > 21 && numAces > 0) {
            handValue -= 10;
            numAces--;
        }
        numCards++;
    }

    /**
     * Getter method for the Hand.
     * @return the Hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Getter method for the Hand value.
     * @return int representing the value of the Hand
     */
    public int getHandValue() {
        return handValue;
    }

    /**
     * Getter method for the number of cards in the Hand.
     * @return int representing the number of cards in the Hand
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * Method for resetting the Hand to an empty Hand.
     */
    public void resetHand() {
        hand = new ArrayList<Card>();
        handValue = 0;
        numCards = 0;
    }
}
