import java.util.Scanner;

//https://open.kattis.com/problems/twostones
public class TakeTwoStones{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int rocks = Integer.parseInt(sc.next());
		if(rocks%2 == 1){
			System.out.println("Alice");
		}else{
			System.out.println("Bob");
		}
	}
}