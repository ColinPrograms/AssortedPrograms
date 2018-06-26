import java.util.Scanner;
import java.util.ArrayList;

public class EightQueens{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]> board = new ArrayList<int[]>();
		String hit = "valid";
		int hTotal = 0;
		int vTotal = 0;
		int totalLines = 0;
		int i = 1;

		while(sc.hasNextLine()){
				totalLines++;
				String line = sc.nextLine();
				
				if(line.length() != 8){
					hit = "invalid";
					break;
				}

				for(int k = 0;k<8;k++){
					int count = 0;
					if(!((line.substring(k,k+1).equals("*")) || line.substring(k,k+1).equals("."))){
						hit = "invalid";
						break;
					}
					if(line.substring(k,k+1).equals("*")){
						count++;
						if(count > 1){
							hit = "invalid";
						}
						int blah[] = {i,k+1};
						board.add(blah);
					}
				}
				i++;
				if(totalLines > 8){
					hit = "invalid";
				}	
		}
		for(int k = 0; k < board.size(); k++){
			int queenDif = board.get(k)[1] - board.get(k)[0];
			int queenInv = 9 - board.get(k)[1] - board.get(k)[0];
			hTotal += board.get(k)[1];
			vTotal += board.get(k)[0];
			
			for(int j = k+1; j < board.size(); j++){
				int compareDif = board.get(j)[1] - board.get(j)[0];
				int compareInv = 9 - board.get(j)[1] - board.get(j)[0];
				
				if((queenDif == compareDif) || (queenInv == compareInv)){
					hit = "invalid";
					break;
				}

			}
			if(hit.equals("invalid")){
				break;
			}

		}
		for(int k = 0; k < board.size(); k++){
			for(int j = k+1; j < board.size(); j++){
				if(board.get(k)[1] == board.get(j)[1]){
					hit = "invalid";
				}
			}
		}

		if(totalLines != 8){
			hit = "invalid";
		}
		if(sc.hasNextLine()){
			hit = "invalid";
		}
		if(hTotal != 36 || vTotal != 36){
			hit = "invalid";
		}
		if(board.size() != 8){
			hit = "invalid";
		}		
		System.out.print(hit);
	}
}