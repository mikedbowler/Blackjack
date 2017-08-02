
public class Card {
	
	String name;
	Suit suit;
	int value;
	
	public Card(String name, Suit suit, int value){
		
		this.name=name;
		this.suit=suit;
		this.value=value;	
	}
	
	public void changeValue(){
		
		//Allows player to change an Ace's value
		if(name.contains("A")){
			
			//Can only change from 1 to 11 or 11 to 1.
			if(value == 1){
				value = 11;
			}
			else{
				value = 1;
			}
		}
		
		//Not an Ace, print error.
		System.out.println("Card is not an Ace");
		return;
	}
}
