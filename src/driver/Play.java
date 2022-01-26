package driver;

import java.util.Scanner;

import game.Board;
import game.Marker;
import game.Player;

public class Play {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the name of first player : ");
		String name = in.nextLine();
		Player p1 = new Player(name, Marker.X);
		System.out.print("Enter the name of second player : ");
		name = in.nextLine();
		Player p2 = new Player(name, Marker.O);
		boolean p1Move = true;
		
		while (true) {
			Board board = new Board();
			int moves = 9;
			Player active;
			while (moves > 0) {
				board.printBoard();
				active = p1;
				if (!p1Move)
					active = p2;
				System.out.print(active.getName() + "'s turn, please select your move : ");
				int cell = in.nextInt();
				try {
					if (board.makeMove(cell, active.getMarker())) {
						System.out.println("Move success");
						moves--;
						p1Move = !p1Move;
						if (board.isWinner(active.getMarker())) {
							System.out.println(active.getName() + " is WINNER!!");
							break;
						}
					} else {
						System.err.println("Cell already occupied, please select a different cell");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Please enter correct cell");
				}
			}
			if(moves==0) {			
				board.printBoard();
				System.out.println("Game is Draw!!");
			}
			System.out.print("Do you want to play again? (enter 1 for Yes / any other number for No) :");
			int ans = in.nextInt();
			if (ans != 1)
				break;
		}
		in.close();

	}

}
