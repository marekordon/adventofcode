package ordon.marek.adventofcode;

import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {
		int where = 5;
		Scanner scanner = new Scanner(System.in);
		String line;
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			for(int i=0; i<line.length(); i++){
				where = changeNumber(where, line.charAt(i));
			}
			System.out.print(where);
		}

	}
	
	private static int changeNumber(int current, char direction){
		switch(direction){
			case 'U':
				if(current>3)
					return current-3;
				else 
					return current;
			case 'D':
				if(current<7)
					return current+3;
				else 
					return current;
			case 'R':
				if((current%3)!=0)
					return current+1;
				else 
					return current;
			case 'L':
				if((current%3)!=1)
					return current-1;
				else 
					return current;
			default:
				break;
			
		}
		return current;
	}

}
