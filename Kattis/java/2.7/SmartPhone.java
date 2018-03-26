import java.util.*;

public class SmartPhone{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = Integer.parseInt(sc.next());
		for(int k = 0; k < testCases ; k++) {
			String wordToBuild = sc.next();
			int quickest = 55;
			for(int j = 0; j < 4; j++) {
				int similarChars = 0;
				String suggestion = sc.next();
				int keyPresses;
				if(suggestion.length() < wordToBuild.length()) {
					for(int i = 0; i < suggestion.length(); i++) {
						if(wordToBuild.substring(i,i+1).equals(suggestion.substring(i,i+1))) {
							similarChars++;
						}else {
							break;
						}
					}
				}else {
					for(int i = 0; i < wordToBuild.length(); i++) {
						if(wordToBuild.substring(i,i+1).equals(suggestion.substring(i,i+1))) {
							similarChars++;
						}else {
							break;
						}
					}
				}
				if(j == 0) {
					keyPresses = suggestion.length() + wordToBuild.length() - (2*similarChars);
				}else {
					keyPresses = 1 + suggestion.length() + wordToBuild.length() - (2*similarChars);
				}
				if(keyPresses < quickest) {
					quickest = keyPresses;
				}
			}
			System.out.println(quickest);
		}

	}
}
