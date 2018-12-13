
public class Card {
	

//定義花色,Club=1, Diamond=2, Heart=3, Spade=4
public enum Suit{Club, Diamond, Heart, Spade};
private Suit suit;
private int rank ;

public Card (Suit s , int r){
	
	suit = s;
	rank = r;
	
	}


//print出卡片為(花色,數字)
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