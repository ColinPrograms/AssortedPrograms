import java.util.*;
//https://open.kattis.com/problems/woodcutting

public class Woodcutting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int k = 0; k < testCases; k++) {
			int numCustomers = sc.nextInt();
			List<Long> customerTimes = new ArrayList<Long>();
			for(int i = 0; i < numCustomers; i++) {
				int pieces = sc.nextInt();
				long time = 0;
				for(int j = 0; j < pieces; j++) {
					time += sc.nextLong();
				}
				customerTimes.add(time);
			}
			Collections.sort(customerTimes);

			int timePast = 0;
			long calculations = 0;
			for(long n : customerTimes) {
				timePast += n;
				calculations += timePast;
			}
			double average = calculations/(double)numCustomers;
			System.out.printf("%.7f" + "\n", average);
		}
	}
}