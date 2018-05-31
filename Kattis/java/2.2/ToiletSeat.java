import java.util.*;
//https://open.kattis.com/problems/toilet

public class ToiletSeat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String prev = input.substring(0,1);
		int upPolicy, downPolicy, findPolicy;
		upPolicy = downPolicy = findPolicy = 0;
		String current = input.substring(1,2);

		if(current.equals("U") && prev.equals("U")) {
			downPolicy++;
		}
		if(current.equals("U") && prev.equals("D")) {
			upPolicy++;
			downPolicy += 2;
			findPolicy++;
		}
		if(current.equals("D") && prev.equals("U")) {
			upPolicy += 2;
			downPolicy++;
			findPolicy++;
		}
		if(current.equals("D") && prev.equals("D")) {
			upPolicy++;
		}
		
		prev = current;
		for(int k = 2; k < input.length(); k++) {
			current = input.substring(k,k+1);
			if(current.equals("U")) {
				downPolicy += 2;
				if(prev.equals("D")) {
					findPolicy++;
				}
			}else {
				upPolicy += 2;
				if(prev.equals("U")) {
					findPolicy++;
				}
			}
			prev = current;
		}
		System.out.println(upPolicy + "\n" + downPolicy + "\n" + findPolicy);
	}
}