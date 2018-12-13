

import java.util.ArrayList;


import java.util.Random;

//將每張牌利用ArrayList 定義為數字1~13 和4種花色，並將card實體化
public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	public  ArrayList<Card> usedCard; 
	private ArrayList<Card> openCard;
	public int nUsed;

	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		
		for(int a= 0; a<nDeck;a++)
		{
			for(Card.Suit s:Card.Suit.values()){
				
				for(int r=1;r<=13;r++ ){
					
					Card card = new Card(s,r);
					cards.add(card);
					
				}
			}
		}
		shuffle();
	}
		public void printDeck(){
			
			for(Card x : cards){
				x.printCard();
			}

		}
		
		
		
		
		public void shuffle(){
			
			nUsed = 0;
			usedCard = new ArrayList<Card>();
			
			for(int i=0; i< 52 ; i++){
				Random r = new Random();
				int j = r.nextInt(52);
				Card k = cards.get(j);
				
				cards.set(j, cards.get(i));
				cards.set(i, k);
				
			
			
			
				
			}
			
			openCard = new ArrayList<Card>();
			
		}

		public Card getOneCard(boolean IsOpend) {
			
			nUsed++;
			usedCard.add(cards.get(nUsed-1));
			IsOpend = true;
			if (nUsed == 52) {
				shuffle();
			}
			return cards.get(nUsed);
		}
		
		public ArrayList<Card> getAllCards(){
			return cards;
		}
		 public ArrayList<Card> getOpenedCard(){
			 return openCard;
		 }
	}


	
	
	

	
	
	


