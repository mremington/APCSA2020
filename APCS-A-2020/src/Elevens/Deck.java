package Elevens;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//make a Deck class
class Deck{
	public static final int NUMCARDS = 52;
	public static String[] SUITS = "CLUBS HEARTS DIAMONDS SPADES".split(" ");
	
	private List<Card> cards;
	private int top;
	private int size;
 
   //make a Deck constructor
	public Deck() {
   	//refer cards to new ArrayList
		cards = new ArrayList<Card>();
   	//set top to the top of the deck 51
		top = 51;
   	
   	//loop through all suits
		for(int s = 0; s<SUITS.length; s++) {
   		//loop through all faces 1 to 13
			for(int f = 1; f<=13; f++) {
   			//add a new TwentyOneCard to the deck
				cards.add(new Card(SUITS[s] , f));
			}
		}
		
	}
	
	public Deck(String[] ranks, String[] suits, int[] pointValues) {
		//refer cards to new ArrayList
				cards = new ArrayList<Card>();				
		
		//loop through all suits
				for(int s = 0; s<suits.length; s++) {
		   		//loop through all faces 1 to 13
					for(int r = 0; r<ranks.length; r++) {
		   			//add a new TwentyOneCard to the deck
						cards.add(new Card(ranks[r], suits[s] , pointValues[r]));
					}
				}
				size = cards.size();
				top = size-1;
				shuffle();
	}

   
   //make a dealCard() method that returns the top card
	public Card dealCard(){
		Card topCard;
		if( !isEmpty() )
			topCard = cards.get(top);
		else {
			return new Card();
		}
		
		top--;
		size--;
		return topCard;
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public int size() {
		return size;
	}
   
   //write a shuffle() method
	public void shuffle() {
		//use Colletions.shuffle
		Collections.shuffle(cards);
	}
   	
   	//reset the top card
	public void resetTop() {
		top = size()-1;
	}
	
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
