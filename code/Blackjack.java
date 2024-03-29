import java.util.Scanner;

/**
 * Blackjack.java
 * Class containing all the methods needed to play a game of standard Blackjack, without splitting,
 * doubling down, or insurance.
 *
 * @author Aarav Shah
 * @version 1.1
 */
public class Blackjack {

    Deck deck;
    BlackjackHand userHand;
    BlackjackHand dealerHand;
    Scanner in = new Scanner(System.in);

    /**
     * Constructor method for a Blackjack table.
     */
    public Blackjack() {
        deck = new Deck();
        userHand = new BlackjackHand();
        dealerHand = new BlackjackHand();
    }

    /**
     * Method to draw cards for the user, with the user's permission.
     */
    public void DrawUser() {
        System.out.println();
        System.out.print("Would you like to draw a card? Y/N: ");
        String userInput = in.nextLine();
        while (!userInput.equals("Y") && !userInput.equals("N")) {
            System.out.print("Please type Y for yes, N for no: ");
            userInput = in.nextLine();
        }
        // the String userInput is either "Y" or "N" depending on if they want to draw a card

        while (userInput.equals("Y") && userHand.getHandValue() < 21) {
            Card c = deck.removeCard();
            userHand.add(c);
            System.out.println("You draw " + c.toString() + ". Your hand value is " +
                    userHand.getHandValue());
            // draw the card, add it to the user's hand, and inform the user of the card

            if (userHand.getHandValue() < 21) {
                System.out.print("Would you like to draw another card? Y/N: ");
                userInput = in.nextLine();
                while (!userInput.equals("Y") && !userInput.equals("N")) {
                    System.out.print("Please type Y for yes, N for no: ");
                    userInput = in.nextLine();
                }
            }
            // re-ask the user if they want another card
        }
        // while loop that repeatedly draws cards to the user as long as the user agrees and
        // the user's hand value is below 21

        System.out.println();
    }

    /**
     * Method for dealing out cards to the dealer, after the user is done adding cards.
     */
    public void DrawDealer() {
        while (dealerHand.getHandValue() <= userHand.getHandValue() &&
        dealerHand.getHandValue() < 21) {
            Card c = deck.removeCard();
            dealerHand.add(c);
            System.out.println("The dealer draws " + c.toString());
        }
        // adds cards to the dealer hand until either the dealer hand is better than
        // the user hand, or the dealer hand is over 21.

        System.out.println("The dealer's final hand value is " + dealerHand.getHandValue());
        System.out.println();
    }

    /**
     * Method for informing the user of the results of the game and asking for a rematch.
     * @return boolean representing whether the user wants to play again or not
     */
    public boolean calculateResult() {
        String userInput;
        if (userHand.getHandValue() <= 21 && (userHand.getHandValue() > dealerHand.getHandValue() ||
                dealerHand.getHandValue() > 21)) {
            System.out.print("You win! Congratulations! Would you like to play again? Y/N: ");
            userInput = in.nextLine();
        } else if (userHand.getHandValue() == dealerHand.getHandValue()) {
            System.out.println("You draw with the dealer! Time to redraw cards...");
            userInput = "Y";
        } else {
            System.out.print("You lose! What a shame. Would you like to play again? Y/N: ");
            userInput = in.nextLine();
        }
        while (!userInput.equals("Y") && !userInput.equals("N")) {
            System.out.print("Please type Y for yes, N for no: ");
            userInput = in.nextLine();
        }
        return (userInput.equals("Y"));
    }

    /**
     * Method to play a game of Blackjack against a computer dealer.
     * @return boolean representing whether the user wants to play again or not
     */
    public boolean playOneBlackjackGame() {
        System.out.println("Welcome to the Blackjack table! Get ready to play!");
        DrawUser();
        boolean result;
        if (userHand.getHandValue() >= 21) {
            result = calculateResult();
        } else if (userHand.getHandValue() == 0) {
            System.out.println("Thank you for coming! Have a great day.");
            return false;
        } else {
            DrawDealer();
            result = calculateResult();
        }
        if (!result) {
            System.out.println("Thank you for coming! Have a great day.");
        }
        reset();
        return result;
    }
    
    /**
     * Method to reset the blackjack table.
     */
    public void reset() {
        deck = new Deck();
        userHand = new BlackjackHand();
        dealerHand = new BlackjackHand();
    }
}
