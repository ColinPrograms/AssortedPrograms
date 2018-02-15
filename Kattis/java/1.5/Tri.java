import java.util.Scanner;

//https://open.kattis.com/problems/tri
public class Tri{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int first = Integer.parseInt(sc.next());
		int second = Integer.parseInt(sc.next());
		int third = Integer.parseInt(sc.next());

		if(first+second==third){
			System.out.println(first + "+" + second + "=" + third);
		}else if(first-second==third){
			System.out.println(first + "-" + second + "=" + third);
		}else if(first*second==third){
			System.out.println(first + "*" + second + "=" + third);
		}else if(first/second==third){
			System.out.println(first + "/" + second + "=" + third);
		}else if(first==second+third){
			System.out.println(first + "=" + second + "+" + third);
		}else if(first==second-third){
			System.out.println(first + "=" + second + "-" + third);
		}else if(first==second*third){
			System.out.println(first + "=" + second + "*" + third);
		}else{
			System.out.println(first + "=" + second + "/" + third);
		}
	}
}