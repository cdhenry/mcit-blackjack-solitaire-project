
public class Deal {
	private static final int STANDARD_SIZE_DECK = 52;
	private int index = 0;
	private int[] deal;
	
	public Deal() 
	{
		this.deal = RandomOrderGenerator.getRandomOrder(STANDARD_SIZE_DECK);
	}
	
	public void newDeal() 
	{
		this.deal = RandomOrderGenerator.getRandomOrder(STANDARD_SIZE_DECK);
	}
	
	public int getIndex() 
	{
		return this.index;
	}
	
	public void showTopCard() 
	{
		System.out.println("The next card is " + Deck.getCardLabel(this.deal[index]) + ".");
	}
	
	public void placeTopCard(Hand hand, int position) 
	{
		hand.addCard(Deck.getCard(index), position);
		this.index++;
	}
	
	public void deny() 
	{
		
	}
	
	public static void main(String[] args) 
	{
		Deal myDeal = new Deal();
		myDeal.showTopCard();
	}
}
