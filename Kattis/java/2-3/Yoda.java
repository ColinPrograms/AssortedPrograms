import java.util.*;

//https://open.kattis.com/problems/yoda
public class Yoda{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		String[] result;
		String a = sc.next();
		String b = sc.next();

		if(a.length() >= b.length()){
			result = squish(a,b);
			System.out.println(result[0] + "\n" + result[1]);
		}else{
			result = squish(b,a);
			System.out.println(result[1] + "\n" + result[0]);
		}
	}
	public static String[] squish(String longer, String shorter){
		int longerLength  = longer.length();
		int shorterLength = shorter.length();
		int difference    = longerLength - shorterLength;
		int longPosition  = longerLength-1;
		int shortPosition = shorterLength-1;
		
		while(longPosition >= difference){
			int longInt  = Integer.parseInt(longer.substring(longPosition,longPosition+1));
			int shortInt = Integer.parseInt(shorter.substring(shortPosition,shortPosition+1));
			
			if(longInt > shortInt){
				shorter = shorter.substring(0,shortPosition) + shorter.substring(shortPosition+1,shorterLength--);
				shortPosition--;
				longPosition--;
			}else if(longInt < shortInt){
				longer = longer.substring(0,longPosition) + longer.substring(longPosition+1,longerLength--);
				shortPosition--;
				longPosition--;
			}else{
				shortPosition--;
				longPosition--;
			}
		}

		String[] result = {longer, shorter};
		result = removeExtraZeroes(result);

		if(result[0].length() == 0){
			result[0] = "YODA";
		}
		if(result[1].length() == 0){
			result[1] = "YODA";
		}

		return result;
	}
	public static String[] removeExtraZeroes(String[] arrayIn){
		if(!arrayIn[0].equals("")){
			int longer = Integer.parseInt(arrayIn[0]);
			arrayIn[0] = String.valueOf(longer);
		}
		if(!arrayIn[1].equals("")){
			int shorter = Integer.parseInt(arrayIn[1]);
			arrayIn[1] = String.valueOf(shorter);
		}

		return arrayIn;
	}
}