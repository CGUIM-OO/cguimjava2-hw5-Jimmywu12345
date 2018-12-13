import java.util.ArrayList;

public class Table {
	static final int MAXPLAYER = 4; // �̦h�@�i�P��৤�X�ӤH
	private Deck deck; //�s��Ҧ����P
	private Player[] player; //�s��Ҧ������a
	private Dealer dealer; //�s��@�Ӳ��a
	int[] pos_betArray; //�s��C�Ӫ��a�b�@���U���`
	
public Table (int nDeck){
	 deck = new Deck(nDeck); //Deck class�����
	 player = new Player[MAXPLAYER];
	 	
}

//�NPlayer���P��W(pos���P���m�A�̦hMAXPLAYER�H�Ap�h��Player instance)
public void set_player(int pos, Player p){ 
	
	player[pos] = p;  
	
}	

public Player[] get_player(){
	
	return player;
}

public void set_dealer(Dealer d){
	
	dealer = d;
}

//dealer���}���P ��2�i

public Card get_face_up_card_of_dealer(){
	
	Card dealeropen = dealer.getOneRoundCard().get(1);
	return dealeropen;
	
	
}

private void ask_each_player_about_bets(){
	
	

	{
		pos_betArray = new int[player.length];
		for (int i = 0; i < player.length; i++) 
		{
			if (player[i] != null)
			{
				player[i].sayHello();				
				
				if (player[i].makeBet() > player[i].getCurrentChips())
				{
		          pos_betArray[i] = 0;
		        }
		       else
		       	{
		          pos_betArray[i] = player[i].makeBet();
		       	}
			}
		}
	}
		
			
		
	}
	
	

private void distribute_cards_to_dealer_and_players(){
	//�o2�i�P�����a
	for(int i = 0; i< player.length;i++){
		
		ArrayList<Card> playercards = new ArrayList<Card>();
		playercards.add(deck.getOneCard(true));
		playercards.add(deck.getOneCard(true));
		player[i].setOneRoundCard(playercards);
		
		
		//�o�@�i�\�ۤ@�i���}���P�����a
	}
	    ArrayList<Card> dealercards = new ArrayList<Card>();
	    dealercards.add(deck.getOneCard(false));
	    dealercards.add(deck.getOneCard(true));
	    dealer.setOneRoundCard(dealercards);
	    
	    
	    
	    System.out.print("Dealer's face up card is ");
	    
	  
}

//�ݪ��a�n���n�P
private void ask_each_player_about_hits(){
	for(int i = 0; i< player.length;i++){
		ArrayList<Card> playercards = new ArrayList<Card>();
		boolean hit = false;
		
		do{
			hit=player[i].hit_me(this); 
			if(hit){
				playercards.add(deck.getOneCard(true));
				player[i].setOneRoundCard(playercards);
				System.out.print("Hit! ");
				System.out.println(player[i].getName()+"'s Cards now:");
				for(Card c :playercards){
					c.printCard();
				}
			}
			else{
				System.out.println(player[i].getName()+", Pass hit!");
				System.out.println(player[i].getName()+", Final Card:");
				for(Card c : playercards){
					c.printCard();
				}
			}
		}while(hit);
		
		
		
		
	}
	
	
	
}

private void ask_dealer_about_hits(){
	ArrayList<Card> dealercards = new ArrayList<Card>();
	boolean hit = false;
	
	do{
		hit=dealer.hit_me(this); 
		
		if(hit){
			dealercards.add(deck.getOneCard(true));
			dealer.setOneRoundCard(dealercards);
			System.out.print("Hit! ");
			
		}
		
		else if(dealer.getTotalValue() > 21) {
			
			hit = false;
			
			
			
		}
		
	}while(hit);
	
	 System.out.print("Dealer hit it over ");
	
}

private void calculate_chips(){
	 System.out.print("Dealer's card value is " + dealer.getTotalValue()+ " ,Cards:");
	 dealer.printAllCard();
	 
	 for(int i = 0; i< player.length;i++){
		 System.out.print(player[i].getName()+" card value is "+ player[i].getTotalValue());
		 
		 if(player[i].getTotalValue()>21 && dealer.getTotalValue()>21){
				System.out.println(",chips have no change! The Chips now is: "+ player[i].getCurrentChips());
				
			}else if(player[i].getTotalValue()<=21&& dealer.getTotalValue()>21){
				player[i].increaseChips(pos_betArray[i]);
				System.out.println(",Get "+pos_betArray[i]+" Chips, the Chips now is: "+player[i].getCurrentChips());
				
				
			}else if(player[i].getTotalValue()>21&&dealer.getTotalValue()<=21){
				player[i].increaseChips(- pos_betArray[i]);
				System.out.println(", Loss "+pos_betArray[i]+" Chips, the Chips now is: "+player[i].getCurrentChips());
				
				
			}else if(player[i].getTotalValue()>dealer.getTotalValue()&&player[i].getTotalValue()<=21){
				player[i].increaseChips(pos_betArray[i]);
				System.out.println(",Get "+pos_betArray[i]+" Chips, the Chips now is: "+player[i].getCurrentChips());
				
				
			}else if(player[i].getTotalValue()<dealer.getTotalValue()&&dealer.getTotalValue()<=21){
				player[i].increaseChips(-pos_betArray[i]);
				System.out.println(", Loss "+pos_betArray[i]+" Chips, the Chips now is: "+player[i].getCurrentChips());
				
				
			}else{
				System.out.println(",chips have no change! The Chips now is: "+ player[i].getCurrentChips());
			}
		 
		 
	 }
	 
	 
	 
	 
	
	
	
}


public int[] get_players_bet(){
	
	return pos_betArray;
}

public void play(){
	ask_each_player_about_bets();
	distribute_cards_to_dealer_and_players();
	ask_each_player_about_hits();
	ask_dealer_about_hits();
	calculate_chips();
}







	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
