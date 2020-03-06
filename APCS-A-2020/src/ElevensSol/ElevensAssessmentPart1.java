package ElevensSol;


public class ElevensAssessmentPart1 {

	public static void main(String[] args) {
		
		//Given the included Card and Deck classes, create a deck that holds 52 cards, contains suits(Clubs, Spades, Hearts, and Diamonds), 
		//with the following point values: Aces = 11, Kings, Queens, & Jacks = 10, all other cards = face value
		
		//Test #1: all cards should print to the console.
		//Hint for Task#1: Use the toString method for the Deck
		
		//Test #2: the total value of all card point values should print to be equal to 380
		//Hint for Task#2: get the point value from the Deck method that returns a Card. each card has a method to return its point value
		
		String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
		int[] pointValues = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		Deck d = new Deck(ranks, suits, pointValues);
		
		System.out.println(d);
		
		int totalPointValue = 0;
		
		for(int c = 1; c<=52; c++) {
			totalPointValue += d.deal().pointValue();
		}
		
		System.out.println("Total point value for all cards: " + totalPointValue);
		

	}

}
