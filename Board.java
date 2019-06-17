
public class Board {
	private static final int SIDE_LENGTH = 5;
	public static final int BOARD_LENGTH = SIDE_LENGTH * SIDE_LENGTH;
	private static final int DISCARD_START_INDEX = 20;
	private static Square[] BOARD = new Square[ BOARD_LENGTH ];
	private static int score = 0;
	
	static 
	{
		init();
	}
	
	public static void init() 
	{
		int index = 0;
		
		for(int row = 0; row < SIDE_LENGTH; row++) 
		{
			for(int column = 0; column < SIDE_LENGTH; column++) 
			{
				if(((row == 2 || row == 3) && column == 0) ||
				   ((row == 2 || row == 3) && column == 4) ||
				   ((row == 4 && column == 4)))
				{
					
					BOARD[index] = new Square(new Card("BLANK", 0), row, column);
				}
				else 
				{
					BOARD[index] = new Square(new Card(Integer.toString(indexToPosition(index)), 0), row, column);
				}
				index++;
			}
		}
	}
	
	public static void display()
	{
		for(int square = 0; square < BOARD_LENGTH; square++)
		{
			String label = BOARD[square].card().label();
			int labelLength = BOARD[square].card().label().length();
			
			if(square == DISCARD_START_INDEX)
			{
				System.out.println("");
				System.out.print("Discard: " + label + "   ");
			}
			else
			{
				System.out.print(normalizeSpacing(labelLength, label));
			}
			
			if(square != 0 && (square + 1) % 5 == 0)
			{
				System.out.println("");
			}
		}
		System.out.println("");
	}
	
	public static boolean mutateSquare(int index, Card card)
	{
//		if(BOARD[index].card().value() == 0 &&  ) 
			BOARD[index].setCard(card);
	}
	
	public static int score() {
		for (int hand = 0; hand < SIDE_LENGTH; hand++) {
			int rowTotal = 0;
			int colTotal = 0;
			
			for(int i = 0; i < BOARD_LENGTH; i++) {
				int cardValue = BOARD[i].card().value();
				
				if(BOARD[i].row() == hand) 
				{
					rowTotal += cardValue;
				}
				if(BOARD[i].column() == hand)
				{
					colTotal += cardValue;
				}
			}
			
			if((hand == 0 || hand == 3) && colTotal == 21)
			{
				score += 10;
				addToScore(rowTotal);
			}
			else
			{
				addToScore(rowTotal);
				addToScore(colTotal);
			}
		}

		return score;
	}
	
	private static void addToScore(int total) 
	{
		score = total == 21 ? score + 7 : score; 
		score = total == 20 ? score + 5 : score; 
		score = total == 19 ? score + 4 : score; 
		score = total == 18 ? score + 3 : score; 
		score = total == 17 ? score + 2 : score;
		score = total <= 16 ? score + 1 : score;
	}
	
	public static int positionToIndex(int position) 
	{
		if (position < 11) 
		{
			return position - 1;
		}
		else if(position > 13 && position < 17)
		{
			return position + 2;
		}
		else if(position > 16)
		{
			return position + 3;
		}
		return position;
	}
	
	public static int indexToPosition(int index) 
	{
		if (index < 10) 
		{
			return index + 1;
		}
		else if(index > 15 && index < 19)
		{
			return index - 2;
		}
		else if(index > 19 && index < 24)
		{
			return index - 3;
		}
		return index;
	}
	
	private static String normalizeSpacing(int labelLength, String label) 
	{
		switch(labelLength)
		{
			case 1:
				return "   " + label + "   ";
			case 2:
				return "  " + label + "   ";
			case 3:
				return " " + label + "   ";
			default:
				return "       ";
		}
	}
}

//for(int i = 0; i < hand.size(); i++)
//{
//	if(hand.get(i).position() == Integer.parseInt(BOARD[square].card().label())) 
//	{
//		String label = hand.get(i).card().label();
//		int labelLength = hand.get(i).card().label().length();
//		System.out.print(normalizeSpacing(labelLength,label));
//	}
//}
//
//String label = BOARD[square].card().label();
//int labelLength = BOARD[square].card().label().length();
//System.out.print(normalizeSpacing(labelLength,label));
//
//if(hand != null)
//{
//	mutateSquare(square, hand[square]);
//}

//private static final int ROWS = 4;
//private static final int COLUMNS = 5;
//private static int[][] POSITIONS = new int[20][20];
//private static Card[][] BOARD = new Card[ROWS][COLUMNS];
//
//static {
//	int index = 0;
//	int discardIndex = 16;
//	for(int row = 0; row < ROWS; row++) 
//	{
//		for(int column = 0; column < COLUMNS; column++) 
//		{
//			if(((row == 2 || row == 3) && column == 0) ||
//			   ((row == 2 || row == 3) && column == 4))
//			{
//				POSITIONS[discardIndex] = new int[] {row,column};
//				BOARD[row][column] = new Card("BLANK", 0);
//				discardIndex++;
//			}
//			else 
//			{
//				POSITIONS[index] = new int[] {row, column};
//				BOARD[row][column] = new Card(Integer.toString(index + 1), 0);
//				index++;
//			}
//		}
//	}
//}
//
//public static Card[][] init() 
//{
//	return BOARD;
//}
//
//public static int[] getCoordinates(int position) 
//{
//	for(int i = 0; i < POSITIONS[position].length; i++) {
//		System.out.println(POSITIONS[position][i]);
//	}
//	return POSITIONS[position];
//}


//
//public void calculateScore() {
//	
//}
//public static void display(Hand hand) 
//{
//	for(int row = 0; row < ROWS; row++) 
//	{
//		for(int column = 0; column < COLUMNS; column++) 
//		{
//			if(BOARD[row][column].label() == "0") 
//			{
//				System.out.print("       ");
//			}
//			else
//			{
//				if(BOARD[row][column].label().length() < 2) 
//				{
//					System.out.print("   " + BOARD[row][column].label() + "   ");
//				}
//				else 
//				{
//					System.out.print("  " + BOARD[row][column].label() + "   ");
//				}
//			}
//		}
//		System.out.println("");
//	}
//}

//private static final int ROWS = 4;
//private static final int COLUMNS = 5;
//private static final int BOARD_LENGTH = ROWS * COLUMNS;
//private static final int DISCARD_START_INDEX = 15;
//private Square[] board = new Square[ BOARD_LENGTH ];
//private int score = 0;
//
//Board() {
//	initializeBoard();
//}
//
//public void initializeBoard() {
//	int index = 0;
//	int discard = DISCARD_START_INDEX;
//	
//	for(int row = 0; row < ROWS; row++) {
//		for(int column = 0; column < COLUMNS; column++) {
//			if(((row == 2 || row == 3) && column == 0) ||
//			   ((row == 2 || row == 3) && column == 4))
//			{
//				this.board[discard] = new Square("0", 0, new int[] { row, column });
//				discard++;
//			}
//			else 
//			{
//				this.board[index] = new Square(Integer.toString(index + 1), 0, new int[] { row, column });
//				index++;
//			}
//		}
//	}
//}
//
//public void displayBoard(Hand player) {
//	for(CardPosition cardPosition : player.hand) {
//		
//	}
//	for(int square = 0; square < BOARD_LENGTH; square++) {
//		if(square < DISCARD_START_INDEX) {
//			this.board[square].setValue()
//		}
//	}
//}
//
//public int[] getCoordinates(int position) {
//	return this.board[position - 1].coordinates();
//}

//public int getScore() {
//	
//}
