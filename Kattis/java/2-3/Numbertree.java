import java.util.*;

//https://open.kattis.com/problems/numbertree
public class Numbertree{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int height = Integer.parseInt(sc.next());
		long currentNode = (long)Math.pow(2, height+1) - 1;
		if (!sc.hasNext()) {
			System.out.println(currentNode);
		}else {

			String path = sc.next();
			int previousDifference = 0;
			String previousDirection = "";

			if (path.substring(0,1).equals("L")) {
				previousDirection = "L";
				previousDifference = 1;
				currentNode -= 1;
			}else {
				previousDirection = "R";
				previousDifference = 2;
				currentNode -= 2;
			}

			for (int k  = 1; k < path.length(); k++) {
				if (path.substring(k,k+1).equals("L") && previousDirection.equals("L")) {
					previousDifference *= 2;
					currentNode -= previousDifference;
					previousDirection = "L";
				}else if (path.substring(k,k+1).equals("L") && previousDirection.equals("R")){
					previousDifference = (2*previousDifference) - 1;
					currentNode -= previousDifference;
					previousDirection = "L";				
				}else if (path.substring(k,k+1).equals("R") && previousDirection.equals("R")){
					previousDifference *= 2;
					currentNode -= previousDifference;	
					previousDirection = "R";
				}else {//R,L
					previousDifference = (2*previousDifference) + 1;
					currentNode -= previousDifference;	
					previousDirection = "R";
				}
			}

			System.out.println(currentNode);
		}
	}
}