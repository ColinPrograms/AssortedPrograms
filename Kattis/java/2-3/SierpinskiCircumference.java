import java.util.*;
import java.math.*;

//https://open.kattis.com/problems/triangle
public class SierpinskiCircumference {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = 0;
		while(sc.hasNext()) {
			testCase++;
			int iteration = Integer.parseInt(sc.next());
			double sides = 1 + (iteration+1)*Math.log10(3);
			double shrink = iteration * Math.log10(2);
			int total = (int)(sides-shrink);
			System.out.println("Case " + testCase + ": " + total);
		}
	}
}

