package game;

public class Board {
	Marker[][] board;
	final Integer SIZE = 3;
	
	public Board() {
		board = new Marker[SIZE][SIZE];
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				board[i][j]=Marker.E;
			}
		}
	}
	
	public void printBoard() {
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(board[i][j]!=Marker.E)
					System.out.print(board[i][j]+ " ");
				else 
					System.out.print(encodeCell(i, j)+ " "); 
			}
			System.out.println();
		}
	}
	
	public boolean makeMove(int cell, Marker marker) throws Exception {
		int x = getRow(cell);
		int y = getCol(cell);
		if(x>=SIZE || y>=SIZE) throw new Exception("Cell is out of bound");
		if(board[x][y] != Marker.E) return false;
		board[x][y]=marker;
		return true;
	}
	
	private int encodeCell(int x, int y) {
		return (SIZE*x)+y+1;
	}
	
	private int getRow(int cell) {
		cell--;
		return cell/SIZE;
	}

	private int getCol(int cell) {
		cell--;
		return cell%SIZE;
	}
	
	private Marker isWinBoard() {
		//check each row
		for(int i=0;i<SIZE;i++) {
			for(int j=1;j<SIZE;j++) {
				if(board[i][j]!=board[i][j-1])
					break;
				if(j==SIZE-1) return board[i][j];
			}		
		}
		
		//for each col
		for(int i=0;i<SIZE;i++) {
			for(int j=1;j<SIZE;j++) {
				if(board[j][i]!=board[j-1][i])
					break;
				if(j==SIZE-1) return board[j][i];
			}		
		}
		//for primary diagonal
		for(int i=1;i<SIZE;i++) {
			if(board[i][i]!=board[i-1][i-1]) break;
			if(i==SIZE-1) return board[i][i];
		}
		
		//for secondary diagonal
		for(int i=1;i<SIZE;i++) {
			if(board[i][SIZE-i-1] != board[i-1][SIZE-i]) break;
			if(i==SIZE-1) return board[i][SIZE-i-1];
		}
		
		return Marker.E; //In case no one wins
	}
	
	public boolean isWinner(Marker marker) {
		return marker == isWinBoard();
	}
	
}
