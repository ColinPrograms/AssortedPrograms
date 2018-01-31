import java.util.Scanner;
public class ChartingProgress{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String block="", currentLine="", toPrint="";
		int blockWidth = 0, asterisks = 0, position = 0;
		boolean check = true;
		while(sc.hasNextLine()){
			currentLine = sc.nextLine();
			if(check){
				blockWidth = position = currentLine.length();
				check = false;
			}
			if(currentLine.equals("")){
				toPrint += "\n";
				check = true;
			}else{
			asterisks = countAst(currentLine);
			toPrint += createLine(blockWidth,position,asterisks) + "\n";
			position -= asterisks;
			}

		}

		System.out.println(toPrint);
	}

	public static int countAst(String currentLine){
		int count=0;
		for(int k=0;k<currentLine.length();k++){
			if(currentLine.substring(k,k+1).equals("*")){
				count++;
			}
		}
		return count;
	}
	public static String createLine(int blockWidth,int position,int asterisks){
		String lineToPrint = "";
		int pre = position-asterisks;
		for(int k=0;k<pre;k++){
			lineToPrint += ".";
		}
		for(int i=pre;i<position;i++){
			lineToPrint += "*";
		}
		for(int j=position;j<blockWidth;j++){
			lineToPrint +=".";
		}
		return lineToPrint;
	}
}