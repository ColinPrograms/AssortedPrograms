import java.util.*;


//https://open.kattis.com/problems/hidden
public class HiddenPassword{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		char[] password = a.toCharArray();
		char[] code = b.toCharArray();
		boolean check = true;
		int tracker = 0;//keep track of where last character match was.

		//password loop
		for(int i = 0; i < a.length(); i++){
			if(!check){
				break;
			}
			//code loop
			for(int k = tracker; k < b.length(); k++){
				if(password[i] == code[k]){
					tracker = k+1;
					break;
				//if you get to end of code, and have not found char FAIL
				}else if(k == b.length()-1) {
					check = false;
					break;
				//check if code character is one of the other password characters
				}else{
					for(int j = i + 1; j < a.length(); j++){
						if(code[k] == password[j]){
							check = false;
							break;
						}
					}
				}
			}
		}
		if(check){
			System.out.print("PASS");
		}else{
			System.out.print("FAIL");
		}
	}
}