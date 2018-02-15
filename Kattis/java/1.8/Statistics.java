import java.util.*;

//https://open.kattis.com/problems/statistics
public class Statistics{
	public static void main(String[] args){
		int caseNum = 0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			caseNum++;
			String testCase = sc.nextLine();
			List<Integer> stats = new ArrayList<Integer>();

			testCase = testCase.substring(testCase.indexOf(" ") + 1); //missread question, fix
			int nextSpace = testCase.indexOf(" ");

			while(nextSpace != -1){
				int value = Integer.parseInt(testCase.substring(0,nextSpace));
				stats.add(value);
				testCase = testCase.substring(nextSpace + 1);
				nextSpace = testCase.indexOf(" ");
			}
			int value = Integer.parseInt(testCase);
			stats.add(value);


			int min, max, range;
			min = max = stats.get(0);

			for(int cur : stats){
				if(cur < min){
					min = cur;
				}
				if(cur > max){
					max = cur;
				}
			}
			range = max - min;

			System.out.println("Case " + caseNum + ": " + min + " " + max + " " + range);
		}
	}
}