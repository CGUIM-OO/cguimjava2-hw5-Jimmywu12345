
public class Card {
	

//�w�q���,Club=1, Diamond=2, Heart=3, Spade=4
public enum Suit{Club, Diamond, Heart, Spade};
private Suit suit;
private int rank ;

public Card (Suit s , int r){
	
	suit = s;
	rank = r;
	
	}


//print�X�d����(���,�Ʀr)
public void printCard(){
	System.out.println(getSuit() + ","+getRank());
}
 
public Card.Suit getSuit(){
	return suit;
}
public int getRank(){
	return rank;
}

}