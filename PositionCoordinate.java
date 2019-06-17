
public class PositionCoordinate {
	private static final int ROWS = 4;
	private static final int COLUMNS = 5;
	private static int[][] POSITIONS;
	
	static {
		int index = 0;
		int discardIndex = 16;
		for(int row = 0; row < ROWS; row++) 
		{
			for(int column = 0; column < COLUMNS; column++) 
			{
				if(((row == 2 || row == 3) && column == 0) ||
				   ((row == 2 || row == 3) && column == 4))
				{
					POSITIONS[discardIndex] = new int[] {row,column};
					discardIndex++;
				}
				else 
				{
					POSITIONS[index] = new int[] {row, column};
					index++;
				}
			}
		}
	}
	
	public static int[] getCoordinates(String label) {
		return POSITIONS[Integer.parseInt(label) - 1];
	}
}
