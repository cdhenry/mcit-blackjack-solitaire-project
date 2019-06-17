
public class CardPosition {
	private final Card card;
	private final int position;
	
	public CardPosition(Card card, int position) {
		this.card = card;
		this.position = position;
	}
	
	public Card card() { return this.card; }
	public int position() { return this.position; }
}
