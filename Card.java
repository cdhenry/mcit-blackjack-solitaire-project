
public class Card {
	private final String label;
	private final int value;
	
	public Card(String label, int value) {
		this.label = label;
		this.value = value;
	}
	
	public String label() { return this.label; }
	public int value() { return this.value; }
}
