import java.util.Scanner;
import java.lang.Math;
//https://open.kattis.com/problems/stockbroker

public class DaydreamingStockbroker{

	static Scanner sc = new Scanner(System.in);
	static long money = 100;
	static long days = sc.nextLong();
	static long currentPrice = sc.nextLong();
	static long next;
	static long shares, count;

	public static void main(String[] args){
		boolean tradeIndicator = true; // buy == true, sell == false
		shares = 0;
		count = 1;
		if(sc.hasNext()){
			next = sc.nextLong();
		}

		while(count < days) {
			if(tradeIndicator){
				findBuyValue();
				if(count < days){
					buy();
				}
				tradeIndicator = false;
			}else{
				findSellValue();
				sell();
				tradeIndicator = true;
			}
		}
		System.out.println(money);
	}

	public static void findSellValue(){
		while(currentPrice <= next && days > count){
			findNextValue();
		}
	}

	public static void findBuyValue(){
		while((currentPrice >= next || currentPrice > money) && days > count){
			findNextValue();
		}

	}

	public static void findNextValue(){
		currentPrice = next;
		if(count < days-1){
			next = sc.nextInt();
		}
		count++;	
	}

	public static void buy(){
		shares = Math.min(money/currentPrice, 100000);
		money -= currentPrice*shares;	
	}

	public static void sell(){
		money += currentPrice*shares;
		shares = 0;
	}
}
