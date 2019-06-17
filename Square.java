
public class Square {
	private Card card;
	private final int row;
	private final int column;
	
	public Square(Card card, int row, int column) {
		this.card = card;
		this.row = row;
		this.column = column;
	}
	
	public Card card() { return this.card; }
	public int row() { return this.row; }
	public int column() { return this.column; }

	public void setCard(Card card) { this.card = card; }
}
