import java.util.*;
//https://open.kattis.com/problems/redistribution

public class ExamRedistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> rooms = new ArrayList<Pair>();
        int numRooms = sc.nextInt();
        int total = 0;
        //fill list
        for(int k = 1; k <= numRooms; k++) {
        	int current = sc.nextInt();
        	total += current;
        	rooms.add(new Pair(current,k));
        }
        Collections.sort(rooms, new comp());

        //check if total exams from 2nd room to last room > then first room
        total -= rooms.get(0).exams * 2;
        if(total >= 0) {
        	for(Pair k : rooms) {
        		System.out.print(k.roomNum + " ");
        	}
        }else {
        	System.out.println("impossible");
        }  
    }
}
class Pair{
		int exams;
		int roomNum;
		Pair(int examIn, int roomIn){
			exams = examIn;
			roomNum = roomIn;
		}
}
class comp implements Comparator<Pair>{
	public int compare(Pair a, Pair b){
		if(a.exams < b.exams) {
			return 1;
		}else if(a.exams > b.exams) {
			return -1;
		}else {
			return 0;
		}
	}
}