import java.util.*;
import java.io.*;
//https://open.kattis.com/problems/cd

public class CD
{
	public static void main(String[] args) throws Exception 
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		boolean check = true;
		while(check)
		{
			StringTokenizer st = new StringTokenizer(sc.readLine());
			int jack = Integer.parseInt(st.nextToken());
			int jill = Integer.parseInt(st.nextToken());

			if(jack == 0 && jill == 0)
			{
				check = false;
				continue;
			}
			int[] repo = new int[jack];

			for(int k = 0; k < jack; k++)
			{	
				repo[k] = Integer.parseInt(sc.readLine());
			}

			int total = 0;

			for(int i = 0; i < jill; i++)
			{

				if(binarySearch(Integer.parseInt(sc.readLine()), repo, 0, jack) >= 0)
				{
					total++;
				}

			}
			System.out.println(total);
		}
		sc.close();
	}
	public static int binarySearch(int id, int[] repo, int lo, int hi) {
        if(hi <= lo)
        {
        	return -1;
        }
        int mid = lo + (hi - lo) / 2;
        int compare = repo[mid] - id;
        if(compare > 0)
        {
			return binarySearch(id, repo, lo, mid);
        }else if (compare < 0) 
        {
        	return binarySearch(id, repo, mid+1, hi);
        }else
        {
            return mid;        	
        }

    }
}

