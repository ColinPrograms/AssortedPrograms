import java.util.*;
import java.lang.Math;
//https://open.kattis.com/problems/zigzag2

public class Zigzag {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numDigits = sc.nextInt();
		//tracking current digit, prev digit in the zigzag, and length of total subsequence for starting by going down or up
		int curStartDescent, curStartAscent, prevStartDescent, prevStartAscent, totalStartDescent, totalStartAscent;
		totalStartDescent = totalStartAscent = 1;
		prevStartDescent = prevStartAscent = sc.nextInt();

		boolean directionStartDescent = false; //down = false
		boolean directionStartAscent = true; // up = true
		for(int k = 1; k < numDigits; k++) {
			curStartDescent = curStartAscent = sc.nextInt();

			if(directionStartAscent) {
				if(curStartAscent < prevStartAscent) {
					directionStartAscent = false;
					totalStartAscent++;
				}
				prevStartAscent = curStartAscent;
			}else {
				if(curStartAscent > prevStartAscent) {
					directionStartAscent = true;
					totalStartAscent++;
				}
				prevStartAscent = curStartAscent;
			}

			if(directionStartDescent) {
				if(curStartDescent < prevStartDescent) {
					directionStartDescent = false;
					totalStartDescent++;
				}
				prevStartDescent = curStartDescent;
			}else {
				if(curStartDescent > prevStartDescent) {
					directionStartDescent = true;
					totalStartDescent++;
				}
				prevStartDescent = curStartDescent;
			}
		}
		System.out.println(Math.max(totalStartDescent, totalStartAscent));
	}
}
 