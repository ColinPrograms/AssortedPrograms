import java.util.*;

//https://open.kattis.com/problems/blackfriday
public class BlackFriday {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> dieRolls = new ArrayList<Integer>();
		int groupSize = Integer.parseInt(sc.next());
		boolean found = false;
		int index = 0;

		for(int k = 0; k < groupSize; k++) {
			dieRolls.add(Integer.parseInt(sc.next()));
		}
		for(int j = 6; j > 0; j--) {
			for(int k = 0; k < groupSize; k++) {
				if(dieRolls.get(k) == j) {
					if(dieRolls.lastIndexOf(j) == k) {
						found = true;
						index = k + 1;
					}else {
						break;
					}
				}
			}
			if(found) {
				break;
			}
		}
		if(found) {
			System.out.println(index);
		}else {
			System.out.println("none");
		}
	}
}