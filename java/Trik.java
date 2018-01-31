import java.util.Scanner;

//https://open.kattis.com/problems/trik
public class Trik{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String moves = sc.next();
		int left, mid, right, output,temp;
		left = 1;
		mid = right = 0;

		for(int k=0;k<moves.length();k++){
			char currentSwap = moves.charAt(k);

			switch(currentSwap){
				case 'A':	temp = left;
							left = mid;
							mid = temp;
							break;
				case 'B':	temp = mid;
							mid = right;
							right = temp;
							break;
				case 'C':	temp = left;
							left = right;
							right = temp;
							break;
			}
		}
		if(left == 1){
			output = 1;
		}else if(mid == 1){
			output = 2;
		}else{
			output = 3;
		}

		System.out.println(output);
	}
}
