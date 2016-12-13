package ordon.marek.adventofcode;

import java.util.Scanner;

public class Day2_2 {

	public static void main(String[] args) {
		int[] where = {2,0};
		Scanner scanner = new Scanner(System.in);
		String line;
		
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			for(int i=0; i<line.length(); i++){
				where = changeNumber(where, line.charAt(i));
			}
			System.out.print(keypad[where[0]][where[1]]);
		}

	}
	
	private static int[] changeNumber(int[] tab, char direction){
		switch(direction){
			case 'U':
				if(tab[0]>0 && keypad[tab[0]-1][tab[1]]!='X')
					tab[0]=tab[0]-1;
				return tab;
			case 'D':
				if(tab[0]<4 && keypad[tab[0]+1][tab[1]]!='X')
					tab[0]=tab[0]+1;
				return tab;
			case 'R':
				if(tab[1]<4 && keypad[tab[0]][tab[1]+1]!='X')
					tab[1]=tab[1]+1;
				return tab;
			case 'L':
				if(tab[1]>0 && keypad[tab[0]][tab[1]-1]!='X')
					tab[1]=tab[1]-1;
				return tab;
			default:
				return tab;
			
					
		}
	}
	
	private static char[][] keypad = new char[][]{
        new char[]{'X', 'X', '1', 'X', 'X'},
        new char[]{'X', '2', '3', '4', 'X'},
        new char[]{'5', '6', '7', '8', '9'},
        new char[]{'X', 'A', 'B', 'C', 'X'},
        new char[]{'X', 'X', 'D', 'X', 'X'}};

}
