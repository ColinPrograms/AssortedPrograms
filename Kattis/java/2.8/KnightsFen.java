import java.util.*;

//https://open.kattis.com/problems/knightsfen
public class KnightsFen {
	private static int lowestMoves = 11;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.nextLine());
		//TestCases
		for(int k = 0; k < testCases; k++) {
			int[][] startBoard = new int[5][5];
			Pair emptySpace = new Pair(0,0);
			//Import board
			for(int i = 0; i < 5; i++) {
				String line = sc.nextLine();
				for(int j = 0; j < 5; j++) {
					if(line.substring(j,j+1).equals(" ")) {
						startBoard[i][j] = 2;
						emptySpace.row = i;
						emptySpace.col = j;
					}else {
						startBoard[i][j] = Integer.parseInt(line.substring(j,j+1)); 
					}
				}
			}
			Pair blah = new Pair(6,6);
			playGame(startBoard, 0, emptySpace, blah);
			if(lowestMoves < 11) {
				System.out.println("Solvable in " + lowestMoves + " move(s).");
			}else {
				System.out.println("Unsolvable in less than 11 move(s).");				
			}
			//printBoard(startBoard);
		}
	}
	static void printBoard(int[][] board) {
		for(int k = 0; k < 5; k++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(board[k][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void playGame(int[][] board, int moves, Pair blank, Pair previousBlank) {
		boolean complete = gameComplete(board);
		if(moves > 10) {
			return;
		}else if(complete && moves < lowestMoves) {
			lowestMoves = moves;
		}else {
			List<Pair> validCoordinates = createStatements(board, blank, previousBlank);
			for(Pair Coor:validCoordinates) {
				int[][] newBoard = new int[5][5];
				for(int k = 0; k < 5; k++) {
					for(int j = 0; j < 5; j++) {
						newBoard[k][j] = board[k][j];
					}
				}
				newBoard[blank.row][blank.col] = newBoard[Coor.row][Coor.col];
				newBoard[Coor.row][Coor.col] = 2;
				Pair newBlank = new Pair(Coor.row,Coor.col);
				playGame(newBoard, moves+1, newBlank, blank);
			}
		}
	}
	static List<Pair> createStatements(int[][] board, Pair blank, Pair previousBlank) {
		List<Pair> validCoordinates = new ArrayList<Pair>();
		if(checkValid(blank.row-1,blank.col-2, previousBlank)) {
			Pair Coordinates = new Pair(blank.row-1,blank.col-2);
			validCoordinates.add(Coordinates);
		}
		if(checkValid(blank.row+1,blank.col-2, previousBlank)) {
			Pair Coordinates = new Pair(blank.row+1,blank.col-2);
			validCoordinates.add(Coordinates);
		}
		if(checkValid(blank.row+2,blank.col-1, previousBlank)) {
			Pair Coordinates = new Pair(blank.row+2,blank.col-1);
			validCoordinates.add(Coordinates);
		}
		if(checkValid(blank.row+2,blank.col+1, previousBlank)) {
			Pair Coordinates = new Pair(blank.row+2,blank.col+1);
			validCoordinates.add(Coordinates);
		}
		if(checkValid(blank.row+1,blank.col+2, previousBlank)) {
			Pair Coordinates = new Pair(blank.row+1,blank.col+2);
			validCoordinates.add(Coordinates);
		}
		if(checkValid(blank.row-1,blank.col+2, previousBlank)) {
			Pair Coordinates = new Pair(blank.row-1,blank.col+2);
			validCoordinates.add(Coordinates);
		}
		if(checkValid(blank.row-2,blank.col+1, previousBlank)) {
			Pair Coordinates = new Pair(blank.row-2,blank.col+1);
			validCoordinates.add(Coordinates);
		}
		if(checkValid(blank.row-2,blank.col-1, previousBlank)) {
			Pair Coordinates = new Pair(blank.row-2,blank.col-1);
			validCoordinates.add(Coordinates);
		}
		return validCoordinates;
	}
	static boolean checkValid(int row, int col, Pair prevBlank) {
		boolean valid = true;
		if(row < 0 || row > 4 || col < 0 || col > 4 || (prevBlank.row == row && prevBlank.col == col)){
			valid = false;
		}
		return valid;
	}

	static boolean gameComplete(int[][] board) {
		boolean complete = true;
		int[][] endBoard = {{1,1,1,1,1}, {0,1,1,1,1}, {0,0,2,1,1}, {0,0,0,0,1}, {0,0,0,0,0}};
		for(int k = 0; k < 5; k++) {
			for(int j = 0; j < 5; j++) {
				if(board[k][j] != endBoard[k][j]) {
					complete = false;
				}
			}
		}
		return complete;
	}
}
class Pair{
		int row;
		int col;
		Pair(int rowIn, int colIn){
			row = rowIn;
			col = colIn;
		}
}
