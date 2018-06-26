import java.util.Scanner;

//https://open.kattis.com/problems/volim
public class Volim{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int countDown = 210;
		int currentHolder = Integer.parseInt(sc.next());
		int numQuestions = Integer.parseInt(sc.next());

		for(int k = 0; k < numQuestions; k++){
			countDown -= Integer.parseInt(sc.next());
			if(countDown <= 0){
				System.out.print(currentHolder);
				break;
			}
			String answer = sc.next();
			if(answer.equals("T")){
				if(currentHolder == 8){
					currentHolder = 1;
				}else{
					currentHolder++;
				}
			}
		}
	}
	
}