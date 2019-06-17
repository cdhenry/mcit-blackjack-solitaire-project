
public class Deck {
	private static final int STANDARD_SIZE_DECK = 52;
	private static final int ROYAL = 11;
	private static final int ACE = 14;
	private static final String[] SUITS = { "H", "C", "D", "S" };
	private static final String[] ROYALS = { "J", "Q", "K", "A" };
	private static Card[] DECK = new Card[STANDARD_SIZE_DECK];

	static {
		int value = 2;
		int suit = 0;
		int title = 0;
		
		for(int i = 0; i < DECK.length; i++)
		{
			if(value < ROYAL) 
			{
				DECK[i] = new Card(Integer.toString(value) + SUITS[suit], value);
			}
			else if (value < ACE)
			{
				DECK[i] = new Card(ROYALS[title] + SUITS[suit], ROYAL - 1);
				title++;
			}
			else 
			{
				DECK[i] = new Card(ROYALS[title] + SUITS[suit], 1);
				title = 0;
			}
			value = value < ACE ? value + 1 : 2;
			suit = value == 2 ? suit + 1 : suit;
		}
	}
	
	public static String getCardLabel(int index) {
		return DECK[index].label();
	}
	
	public static int getCardValue(int index) {
		return DECK[index].value();
	}
	
	public static Card getCard(int index) {
		return DECK[index];
	}
}
