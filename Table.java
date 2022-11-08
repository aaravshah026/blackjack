import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class representing a dealer table.
 * @author aaravshah026
 * @version 1.0
 */
public class Table {

    public final Card[] standardDeck;
    private Card[] shuffledDeck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;

    /**
     * Constructor for Table objects.
     */
    public Table() {
        this.standardDeck = new Card[52];
        initializeStandardDeck();
        this.shuffledDeck = new Card[52];
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
    }

    /**
     * Helper method to initialize the standard deck array.
     */
    private void initializeStandardDeck() {
        CardValue[] values = {CardValue.ACE, CardValue.TWO, CardValue.THREE, CardValue.FOUR, 
                              CardValue.FIVE, CardValue.SIX, CardValue.SEVEN, CardValue.EIGHT, 
                              CardValue.NINE, CardValue.TEN, CardValue.JACK, CardValue.QUEEN,
                              CardValue.KING};
        CardSuit[] suites = {CardSuit.HEARTS, CardSuit.DIAMONDS, CardSuit.CLUBS, CardSuit.SPADES};
        int position = 0;
        for (CardValue value: values) {
            for (CardSuit suit: suites) {
                this.standardDeck[position++] = new Card(value, suit);
            }
        }
    }

    /**
     * Method to shuffle the standard deck and store it in its variable.
     */
    private void shuffleDeck() {
        for (int i = 0; i < standardDeck.length; i++) {
            shuffledDeck[i] = standardDeck[i];
        }
        for (int i = shuffledDeck.length - 1; i > 0; i--) {
            int randIndex = (int) (Math.random() * i);
            Card temp = shuffledDeck[i];
            shuffledDeck[i] = shuffledDeck[randIndex];
            shuffledDeck[randIndex] = temp;
        }
    }

    /**
     * Helper method for giving a card to the dealer.
     */
    private void giveCardToDealer() {
        int nonNullIndex = 0;
        while (this.shuffledDeck[nonNullIndex] == null) {
            nonNullIndex++;
        }
        this.dealerHand.add(this.shuffledDeck[nonNullIndex]);
        this.shuffledDeck[nonNullIndex] = null;
    }

    /**
     * Helper method for giving a card to the player.
     */
    private void giveCardToPlayer() {
        int nonNullIndex = 0;
        while (this.shuffledDeck[nonNullIndex] == null) {
            nonNullIndex++;
        }
        this.playerHand.add(this.shuffledDeck[nonNullIndex]);
        this.shuffledDeck[nonNullIndex] = null;
    }

    /**
     * Helper method for calculating the value of a person's hand.
     * @param person String representing who's hand to calculate
     * @return int representing the value of the hand;
     */
    private int calculateValue(String person) {

        ArrayList<Card> hand = new ArrayList<>(); // hand to evaluate
        int handValue = 0; // value of the hand
        int numAces = 0; // counting number of aces
        // variable declaration

        if (person.equals("Player"))
            hand = this.playerHand;
        else if (person.equals("Dealer"))
            hand = this.dealerHand;
        else {
            System.out.println("calculateValue() input incorrect!");
            return -1;
        }
        // initialization of hand ArrayList

        for (Card card: hand) {
            handValue += card.getValue().getValue();
            if (card.getValue().getValue() == 11)
                numAces++;
        }
        // calculating initial value of hand (without the ace rule)

        while((handValue > 21) && (numAces > 0)) {
            numAces--;
            handValue -= 10;
        }
        // final hand value calculation considering aces

        return handValue;
    }

    /**
     * Helper method for determining whether the player has won the game.
     * @param hasStand boolean representing whether the player has standed
     * @return boolean representing whether the player has won the game
     */
    private boolean hasWon(boolean hasStand) {
        if (calculateValue("Player") > 21)
            return false;
        if (calculateValue("Player") == 21)
            return true;
        if (calculateValue("Dealer") > 21)
            return true;
        if (hasStand && calculateValue("Player") > calculateValue("Dealer"))
            return true;
        return false;
    }

    /**
     * Helper method for when the player decides to hit.
     */
    private void hit() {
        giveCardToPlayer();
        System.out.print("You drew " + playerHand.get(playerHand.size() - 1).toString().toLowerCase() + ". ");
    }

    /**
     * Helper method for when the player decides to stand.
     */
    private void stand() {
        while (calculateValue("Dealer") < calculateValue("Player")) {
            giveCardToDealer();
            System.out.print("The dealer drew "
                + dealerHand.get(dealerHand.size() - 1).toString().toLowerCase() + ". ");
            System.out.println("The dealer's hand value is " + calculateValue("Dealer") + ".");
        }
    }

    public void playBlackJack() {
        Scanner in = new Scanner(System.in);
        String input;
        int messagesIndex = 0;
        System.out.println();
        System.out.println("Welcome to the blackjack table! Let's get started.");
        shuffleDeck();
        System.out.println("The deck of cards has now been shuffled.");
        System.out.println();
        // pregame I/O and variable declaration

        giveCardToDealer();
        System.out.println("The dealer drew a card, placing it face down.");
        giveCardToPlayer();
        System.out.println("You drew " + playerHand.get(playerHand.size() - 1).toString().toLowerCase() + ".");
        giveCardToDealer();
        System.out.println("The dealer drew " + dealerHand.get(dealerHand.size() - 1).toString().toLowerCase() + ".");
        giveCardToPlayer();
        System.out.println("You drew " + playerHand.get(playerHand.size() - 1).toString().toLowerCase() + ".");
        System.out.println("The dealer revealed his first card. It is "
                            + dealerHand.get(0).toString().toLowerCase() + ".");
        System.out.println("The dealer's hand value is " + calculateValue("Dealer") + ".");
        System.out.println();
        // game beginning I/O

        if (!playerHand.get(0).valueEquals(playerHand.get(1)) && calculateValue("Player") != 21) {
            do {
                System.out.println("Your hand value is " + calculateValue("Player") + ". What will you do?");
                input = in.next();
                in.nextLine();
                while (!input.equals("Hit") && !input.equals("Stand")) {
                    System.out.println("Your input was invalid. Type 'Hit' or 'Stand':");
                    input = in.next();
                    in.nextLine();
                }
                if (input.equals("Hit"))
                    hit();
            } while (input.equals("Hit") && !hasWon(false) && calculateValue("Player") <= 21);
            if (!hasWon(false) && calculateValue("Player") < 21)
                stand();
        } // the majority of the game, except when splitting occurs
        else {
            // code here when splitting occurs... recursive method?
        }

        if (calculateValue("Dealer") == calculateValue("Player"))
            System.out.println("It was a tie! Play again to win");
        else if (hasWon(true))
            System.out.println("You won! Congratulations!");
        else
            System.out.println("You lost. Better luck next time.");
        in.close();
        // result I/O
    }

    public static void main (String[] args) {
        Table t = new Table();
        t.playBlackJack();
    }
}