import java.util.Scanner;

public class BlackjackSolitaire {
	public void play() {
		Scanner in = new Scanner(System.in);
		Dealer dealer = new Dealer();
		while (!dealer.endGame())
		{
			Board.display();
			dealer.showTopCard();
			System.out.print("Choose where you'd like to place it: ");
			int position = in.nextInt();
			dealer.placeTopCard(position);
		}
		Board.display();
		System.out.println("Your Score is: " + Board.score());
		in.close();
	}
}
