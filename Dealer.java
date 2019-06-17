
public class Dealer {
	private static final int STANDARD_SIZE_DECK = 52;
	private static final int MAX_DEAL = 20;
	private static final int MAX_SCORING_SQUARES = 16;
	private int scoringSquares = 0;
	private int discardSquares = 0;
	private int topCard = 0;
	private int[] deal;
	
	public Dealer() 
	{
		this.deal = RandomOrderGenerator.getRandomOrder(STANDARD_SIZE_DECK);
	}
	
	public void shuffle() 
	{
		this.deal = RandomOrderGenerator.getRandomOrder(STANDARD_SIZE_DECK);
		this.topCard = 0;
	}
	
	public void showTopCard() 
	{
		System.out.println("The next card is " + Deck.getCardLabel(this.deal[topCard]) + ".");
	}
	
	public void placeTopCard(int position) 
	{
		Card card = Deck.getCard(this.deal[topCard]);
		int index = Board.positionToIndex(position);
		
		if (position <= MAX_SCORING_SQUARES)
		{
			Board.mutateSquare(index, card);
			this.scoringSquares++;
		}
		else
		{
			Board.mutateSquare(index, new Card(card.label(), 0));
		}
		
		this.topCard++;
	}
	
	public boolean endGame() {
		if(this.topCard == MAX_DEAL || scoringSquares == MAX_SCORING_SQUARES) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static String deny() 
	{
		
	}
	
//	private void resetSquares() {
//		this.scoringSquares = 0;
//		Board.init();
//	}
}
