/**
 * Driver class for the current Blackjack project.
 * 
 * @author Aarav Shah
 * @version 1.0
 */

public class Table {
    public static void main(String[] args) {
        Blackjack blackjackTable = new Blackjack();
        boolean playAgain = true;
        while (playAgain) {
            playAgain = blackjackTable.playOneBlackjackGame();
        }
    }
}
