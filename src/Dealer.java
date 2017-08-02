import java.util.ArrayList;

public class Dealer {
	
	String name;
	ArrayList<Card> hand;
	
	public Dealer(String name){
		
		this.name = name;
		hand = new ArrayList<Card>();
	}
	
	//The dealer will act according to a fixed algorithm.
	public void autoPlay(){
		
	}
}
