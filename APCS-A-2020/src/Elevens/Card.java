package Elevens;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
 
public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	//instance variables
		//String suit
	private String suit;

	private String rank;
		//int face
	private int face;
	
	private int pointValue;
	
	public Card() {
		setSuit("NULL");
		setRank("NULL");
		setFace(0);
		setPointValue(0);
	}

  	//constructors
	public Card(String cardSuit, int cardFaceValue) {
		//initializes a new Card with the given suit, and face value
		suit = cardSuit;
		face = cardFaceValue;
	}
	
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		//initializes a new Card with the given rank, suit, and point value
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}
	
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public int getPointValue() {
		return pointValue;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}


  	//toString
	public String toString() {
		if(pointValue==0) {
			return FACES[face]+ " of " + suit;
		}
		else {
			return rank + " of " + suit + " (point value = " + pointValue + ")";
		}
	}

	public boolean matches(Card otherCard) {
		// TODO Auto-generated method stub
		if(this.getSuit().equals(otherCard) && this.getRank().equals(otherCard) && this.getPointValue()==otherCard.getPointValue())
			return true;
		else if(this.getSuit().equals(otherCard.getSuit()) && this.getFace()==otherCard.getFace())
			return true;
		return false;
	}

 }