import java.util.Scanner;
public class NewAlphabet{
	private static String[] alphabet = {"a","A","b","B","c","C","d","D","e","E","f","F","g","G","h","H","i","I","j","J","k","K","l","L","m","M","n","N","o","O","p","P","q","Q","r","R","s","S","t","T","u","U","v","V","w","W","x","X","y","Y","z","Z"}; 
	private static String[] newAlpha = {"@","8","(","|)","3","#","6","[-]","|","_|","|<","1","[]\\/[]","[]\\[]","0","|D","(,)","|Z","$","\'][\'","|_|","\\/","\\/\\/","}{","`/","2"};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(convertText(input));
	}

	public static String convertText(String input){
		String newString = "";
		for(int k = 0;k<input.length();k++){
			newString += convertLetter(input.substring(k,k+1));
		}
		return newString;
	}

	public static String convertLetter(String input){
		int charNumber = getCharNumber(input);
		String toReturn = "";
		if(charNumber == 26){
			toReturn = input;
		}else{
			toReturn = newAlpha[charNumber];
		}
		return toReturn;
	}

	public static int getCharNumber(String input){
		int charNumber = 26;
		for(int k=0;k<alphabet.length-1;k++){
			if(input.equals(alphabet[k])||input.equals(alphabet[k+1])){
				charNumber = k/2;
				break;
			}else{
				k++;
			}
		}

		return charNumber;
	}
}