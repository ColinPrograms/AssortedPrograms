import java.util.*;

//https://open.kattis.com/problems/pebblesolitaire
public class PebbleSolitaire {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numberOfGames = Integer.parseInt(sc.next());

		for(int k = 0; k < numberOfGames; k++) {
			List<String> gameState = createGameState(sc.next());
			Game solitaireGame =  new Game(gameState);
			solitaireGame.playThrough(gameState);
			System.out.println(solitaireGame.getPebbles());
		}
	}

	private static List<String> createGameState(String dataIn) {
		List<String> board = new ArrayList<String>();

		for(int k = 0; k < dataIn.length(); k++) {
			board.add(dataIn.substring(k,k+1));
		}
		return board;
	}
}

class Game {
	private List<String> gameState;
	private int leastPebbles = 0;

	Game(List<String> gameStateIn) {
		gameState = gameStateIn;
		for (String k : gameState) {
			if(k.equals("o")) {
				leastPebbles++;
			}		
		}
	}

	void playThrough(List<String> gameStateIn) {
		int moves = 0;

		//Left side check
		if(gameStateIn.get(0).equals("o")) {
			if(gameStateIn.get(1).equals("o")) {
				if(gameStateIn.get(2).equals("-")) {
					moves++;
					List<String> newState = updatedBoard(0,1,2,gameStateIn);
					playThrough(newState);
				}
			}
		}
		//All middle checks
		for(int k = 1; k < gameStateIn.size() - 2; k++) {
			if(gameStateIn.get(k).equals("o")) {
				if(gameStateIn.get(k+1).equals("o")) {
					if(gameStateIn.get(k-1).equals("-")) {
						moves++;
						List<String> newState = updatedBoard(k,k+1,k-1,gameStateIn);
						playThrough(newState);
					}
					if(gameStateIn.get(k+2).equals("-")) {
						moves++;
						List<String> newState = updatedBoard(k,k+1,k+2,gameStateIn);
						playThrough(newState);
					}

				}
			}
		}
		//Right side check
		if(gameStateIn.get(10).equals("o")) {
			if(gameStateIn.get(11).equals("o")) {
				if(gameStateIn.get(9).equals("-")) {
					moves++;
					List<String> newState = updatedBoard(10,11,9,gameStateIn);
					playThrough(newState);
				}
			}
		}
		//When the board has no moves to make, count pebbles and 
		//check if there are less than the current least amount of pebbles.
		if(moves == 0) {
			int pebbles = 0;
			for (String j : gameStateIn) {
				if(j.equals("o")){
					pebbles++;
				}
			}

			if(pebbles < leastPebbles) {
				leastPebbles = pebbles;
				gameState = gameStateIn;
			}
			return;
		}
	}

	List<String> updatedBoard(int dashOne, int dashTwo, int pebble, List<String> oldBoard) {
		List<String> newState = new ArrayList<String>();
		newState.addAll(oldBoard);
		newState.set(pebble,"o");
		newState.set(dashOne,"-");
		newState.set(dashTwo,"-");

		return newState;
	}

	int getPebbles() {
		return leastPebbles;
	}
}