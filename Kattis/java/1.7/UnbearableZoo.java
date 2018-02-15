import java.util.*;


//https://open.kattis.com/problems/zoo
public class UnbearableZoo{
	public static void main(String[] args){
		int listNum = 1;
		boolean check = true;
		Scanner sc = new Scanner(System.in);
		while(check){
			int numAnimals = Integer.parseInt(sc.nextLine());
			if(numAnimals == 0){
				check = false;
			}else{
				List<Pair> list = new ArrayList<Pair>();
				for(int k = 0; k < numAnimals; k++){
					String current = sc.nextLine();
					current = current.toLowerCase();
					int space = current.lastIndexOf(" ");
					current = current.substring(space+1);

					boolean match = false;
					for(int j = 0; j < list.size(); j++){
						if(list.get(j).animal.equals(current)){
							list.get(j).numAnimal++;
							match = true;
							break;
						}
					}
					if(!match){
						Pair duo = new Pair(current);
						list.add(duo);
					}
				}
				Collections.sort(list, new comp());
				printList(list,listNum);
				listNum++;
			}
		}
	}

	static void printList(List<Pair> listIn, int listNumIn){
		System.out.println("List " + listNumIn + ":");
		for(int j = 0; j < listIn.size(); j++){
			System.out.println(listIn.get(j).animal + " | " + listIn.get(j).numAnimal);
		}
	}
}
class Pair{
		String animal;
		int numAnimal = 1;
		Pair(String animalIn){
			animal = animalIn;
		}
}
class comp implements Comparator<Pair>{
	public int compare(Pair a, Pair b){
		return a.animal.compareTo(b.animal);
	}
}
