import java.util.ArrayList;

public class Hand 
{
//	private static final int ROW = 0;
//	private static final int COLUMN = 1;
	private static final int ROWS = 4;
	private static final int COLUMNS = 5;
	private static final int LAST_HAND_INDEX = 16;
	private static final int MAX_DISCARDS = 4;
	private int score = 0;
	private Card[][] hand = new Card[ROWS][COLUMNS];
	private ArrayList<Card> discardPile = new ArrayList<>();

//	public ArrayList<CardPosition> hand = new ArrayList<CardPosition>();
	
//	public void addCardPosition(Card card, String position) 
//	{
//		CardPosition cardPosition = new CardPosition(card, position);
//		this.hand.add(cardPosition);
//	}
	
//	Hand() 
//	{
//		this.hand = Board.init();
//	}
//	
	public void displayHand() 
	{
		for(int row = 0; row < ROWS; row++) 
		{
			for(int column = 0; column < COLUMNS; column++) 
			{
				if(this.hand[row][column].label() == "BLANK") 
				{
					System.out.print("       ");
				}
				else
				{
					if(this.hand[row][column].label().length() < 2) 
					{
						System.out.print("   " + this.hand[row][column].label() + "   ");
					}
					else 
					{
						System.out.print("  " + this.hand[row][column].label() + "   ");
					}
				}
			}
			System.out.println("");
		}
	}
	
	public void addCard(Card card, int position)
	{
		if (position > LAST_HAND_INDEX) 
		{
			this.discardPile.add(card);
		}
		else
		{
//			int[] coordinates = Board.getCoordinates(position);
//			System.out.println(this.hand[coordinates[ROW]][coordinates[COLUMN]]);
//			this.hand[coordinates[ROW]][coordinates[COLUMN]] = card;
		}
	}
	
	public void displayDiscardPile() 
	{
		for(int i = 0; i < MAX_DISCARDS; i++)
		{
			if(this.discardPile.size() - i >= 0)
			{
				System.out.print(this.discardPile.get(i).label());
			}
			else
			{
				System.out.print(LAST_HAND_INDEX + i);
			}
		}
		System.out.println("");
	}
	
	public int score() {
		for(int row = 0; row < ROWS; row++)
		{
			int total = 0;
			for(Card card: this.hand[row]) 
			{
				total += card.value();
			}
			
			this.addToScore(total);
		}
		
		for(int column = 0; column < COLUMNS; column++)
		{
			int total = 0;
			for(int row = 0; row < ROWS; row++) 
			{
				total += this.hand[row][column].value();
			}
			if((column == 0 || column == 3) && total == 21) {
				this.score += 10;
			}
			else
			{
				this.addToScore(total);
			}
		}
		
		return score;
	}
	
	private void addToScore(int total) 
	{
		this.score = total == 21 ? score + 7 : score; 
		this.score = total == 20 ? score + 5 : score; 
		this.score = total == 19 ? score + 4 : score; 
		this.score = total == 18 ? score + 3 : score; 
		this.score = total == 17 ? score + 2 : score;
		this.score = total <= 16 ? score + 1 : score;
	}
}
