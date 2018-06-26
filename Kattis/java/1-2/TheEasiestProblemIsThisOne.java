import java.util.Scanner;

//https://open.kattis.com/problems/easiest
public class TheEasiestProblemIsThisOne{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String input = sc.next();
			int intInput = Integer.parseInt(input);
			if(!input.equals("0")){
				 int inputValue = 0;
				for(int k = 0; k < input.length(); k++){
					inputValue += Integer.parseInt(input.substring(k,k+1));
				}

				boolean check = true;
				int p = 11;
				while(check){
					int sum = intInput*p;
					String sSum = String.valueOf(sum);
					int sumValue = 0;
					for(int j = 0; j < sSum.length(); j++){
						sumValue += Integer.parseInt(sSum.substring(j,j+1));
					}
					if(sumValue == inputValue){
						System.out.println(p);
						check = false;
					}
					p++;
				}
			}		
		}
	}
}