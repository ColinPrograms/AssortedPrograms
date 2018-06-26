import  java.util.*;

//https://open.kattis.com/problems/treasurehunt
public class TreasureHunt{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int height = Integer.parseInt(sc.next());
		int width = Integer.parseInt(sc.next());
		List<List<Pair>> map = new ArrayList<List<Pair>>();

		//Fill map, "B" character boardering.
		List<Pair> boarderRow = new ArrayList<Pair>();
		for(int k = 0; k < width + 2; k++) {
			Pair b = new Pair("B");
			boarderRow.add(b);
		}	
		map.add(boarderRow);

		for(int k = 1; k < height + 1; k++) {
			List<Pair> rows = new ArrayList<Pair>();
			Pair b = new Pair("B");
			rows.add(b);
			String line = sc.next();
			for(int j = 1; j < width + 1; j++) {
				Pair spot = new Pair(line.substring(j-1,j));
				rows.add(spot);
			}
			rows.add(b);
			map.add(rows);
		}
		map.add(boarderRow);

		boolean outOfBounds = false;
		boolean lost = false;
		boolean treasure = false;
		int count = 0;
		int x = 1;
		int y = 1;
		while(!outOfBounds && !lost && !treasure) {
			Pair current = map.get(y).get(x);
			if(current.encountered) {
				lost = true;
			}else {
				current.encountered = true;
				Pair current1 = map.get(y).get(x);
				switch(current.character) {
					case "B":	outOfBounds = true;
								break;
					case "N":	y--;
								count++;
								break;
					case "S":	y++;
								count++;
								break;
					case "W":	x--;
								count++;
								break;
					case "E":	x++;
								count++;
								break;
					case "T":	treasure = true;
								break;
				}				
			}
		}

		if(outOfBounds) {
			System.out.println("Out");
		}else if(lost) {
			System.out.println("Lost");
		}else {
			System.out.println(count);
		}
	}
}
class Pair{
		String character = "";
		boolean encountered = false;
		Pair(String charIn){
			character = charIn;
		}
}