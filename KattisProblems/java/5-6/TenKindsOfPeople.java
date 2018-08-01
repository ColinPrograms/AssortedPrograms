import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//https://open.kattis.com/problems/10kindsofpeople
//currently 'Time Exceeded' on 3rd last testcase

public class TenKindsOfPeople {
	private static boolean binary = false;
	private static boolean decimal = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		List<int[]> worldLayout = new ArrayList<int[]>(rows);
		List<int[]> template = new ArrayList<int[]>(rows);
		for(int k = 0; k < rows; k++) {
			int[] row = new int[columns];
			int[] row2 = new int[columns];
			String line = sc.next();
			for(int j = 0; j < columns; j++) {
				row[j] = Integer.parseInt(line.substring(j,j+1));
				row2[j] = Integer.parseInt(line.substring(j,j+1));
			}
			template.add(row2);
			worldLayout.add(row);
		}
		int query = sc.nextInt();
		String output = "";
		for(int k = 0; k < query; k++) {
			int[] test = new int[4];
			for(int j = 0; j < 4; j++) {
				test[j] = sc.nextInt()-1;
			}
			output += solveQuery(worldLayout, test) + "\n";
			worldLayout = resetList(template);
		}
		System.out.print(output);
		sc.close();
	}

	public static String solveQuery(List<int[]> layoutIn, int[] queryIn) {
		//if start and finish = 0
		if(layoutIn.get(queryIn[0])[queryIn[1]] == 0 && layoutIn.get(queryIn[2])[queryIn[3]] == 0) {
			findPath(0, layoutIn, queryIn);
		}
		//if start and finish = 1
		if(layoutIn.get(queryIn[0])[queryIn[1]] == 1 && layoutIn.get(queryIn[2])[queryIn[3]] == 1) {
			findPath(1, layoutIn, queryIn);
		}
		if(binary) {
			binary = false;
			return "binary";
		}else if(decimal) {
			decimal = false;
			return "decimal";
		}else{
			return "neither";
		}
	}

	public static void findPath(int digit, List<int[]> layoutIn, int[] queryIn) {
		int row = queryIn[0];
		int col = queryIn[1];
		if(queryIn[0] == queryIn[2] && queryIn[1] == queryIn[3]){
			if(digit == 0) {
				binary = true;
			}else {
				decimal = true;
			}
		}else{ 
			if(row-1 >= 0 && row-1 < layoutIn.size() && col >= 0 && col < layoutIn.get(0).length && layoutIn.get(row-1)[col] == digit) {
				int[] newQuery = {row-1, col, queryIn[2], queryIn[3]};
				layoutIn.get(row)[col] = 2;
				findPath(digit,layoutIn,newQuery);
			}
			if(row+1 >= 0 && row+1 < layoutIn.size() && col >= 0 && col < layoutIn.get(0).length && layoutIn.get(row+1)[col] == digit) {
				int[] newQuery = {row+1, col, queryIn[2], queryIn[3]};
				layoutIn.get(row)[col] = 2;
				findPath(digit,layoutIn,newQuery);
			}
			if(row >= 0 && row < layoutIn.size() && col-1 >= 0 && col-1 < layoutIn.get(0).length && layoutIn.get(row)[col-1] == digit) {
				int[] newQuery = {row, col-1, queryIn[2], queryIn[3]};
				layoutIn.get(row)[col] = 2;
				findPath(digit,layoutIn,newQuery);
			}
			if(row >= 0 && row < layoutIn.size() && col+1 >= 0 && col+1 < layoutIn.get(0).length && layoutIn.get(row)[col+1] == digit) {
				int[] newQuery = {row, col+1, queryIn[2], queryIn[3]};
				layoutIn.get(row)[col] = 2;
				findPath(digit,layoutIn,newQuery);
			}
		}
	}
	public static List<int[]> resetList(List<int[]> oldList) {
		List<int[]> layout = new ArrayList<int[]>();
		for(int k = 0; k < oldList.size(); k++) {
			int[] row = new int[oldList.get(0).length];
			for(int j = 0; j < oldList.get(0).length; j++) {
				row[j] = oldList.get(k)[j];
			}
			layout.add(row);
		}
		return layout;
	}
}
