import java.util.Scanner;

public class BattleSimulation{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String monsterMoves = sc.nextLine();
		for(int k = 0; k < monsterMoves.length(); k++){
			if(k < monsterMoves.length()-2){
				String combo = monsterMoves.substring(k,k+3);
				if(combo.equals("RBL") || combo.equals("BLR") || combo.equals("RLB") || combo.equals("BRL") || combo.equals("LRB") || combo.equals("LBR")){
					System.out.print("C");
					k = k + 2;
				}else{
					System.out.print(getChar(monsterMoves.substring(k,k+1)));
				}
			}else{
				System.out.print(getChar(monsterMoves.substring(k,k+1)));
			}
		}
	}

	public static String getChar(String a){
		if(a.equals("R")){
			return "S";
		}else if(a.equals("B")){
			return "K";
		}else{ 
			return "H";
		}
	}
}