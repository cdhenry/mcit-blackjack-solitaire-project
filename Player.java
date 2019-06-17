//import java.util.ArrayList;

public class Player {
//	private ArrayList<CardPosition> hand;
//	
//	Player()
//	{
//		this.refresh();
//	}
//	
//	public void refresh() 
//	{
//		this.hand = new ArrayList<>();
//	}
//	
//	public ArrayList<CardPosition> hand() 
//	{
//		return this.hand;
//	}
	
	public void handleTopCard(Card card, int position)
	{
		int index = Board.positionToIndex(position);
		Board.mutateSquare(index, card);
	}
}
