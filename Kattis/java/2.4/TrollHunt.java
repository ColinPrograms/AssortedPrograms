import java.util.*;

//https://open.kattis.com/problems/trollhunt
public class TrollHunt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bridges = Integer.parseInt(sc.next()) - 1;
		int bridgesPerDay = Integer.parseInt(sc.next()) / Integer.parseInt(sc.next());
		if(bridges % bridgesPerDay == 0) {
			System.out.println(bridges/bridgesPerDay);
		}else {
			System.out.println((bridges/bridgesPerDay) + 1);
		}
	}
}