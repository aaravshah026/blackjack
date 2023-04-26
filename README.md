# Blackjack Game
These files allow a user to play a game of standard blackjack 1-vs-1 against a computer dealer. A normal set of 52 cards is used. Run Table.java and follow the on-screen instructions to play!

Files:
Table.java - The current driver class. Contains the runnable main method to play the game.
Blackjack.java - Contains the methods necessary to play Blackjack.
BlackjackHand.java - The class representing a hand in Blackjack, including hand value calculations
Deck.java - The class representing the standard deck of cards. Backed by an ArrayList.
Card.java - The class representing the card object, which is the backbone of the Deck class and the Blackjack game.

Version 1:
Created a rudimentary playable Blackjack game. The user is able to hit and stand during their turn, but is currently unable to split or double down. The user can choose whether or not to play again during a win or loss, but must play again in the case of a tie.

Future Plans:
Version 2: Add the game rules of the dealer upcard. This requires a rework of the dealer mechanics in Blackjack.java.
Version 3: Add splitting as a choice for the user, which will require a dynamic number of BlackjackHand objects.
