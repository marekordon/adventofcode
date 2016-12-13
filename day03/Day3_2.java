package ordon.marek.adventofcode;

import java.util.Arrays;
import java.util.Scanner;

public class Day3_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line;
		int counter = 0;
		int midCounter =0;
		int[] tab1=new int[3], tab2=new int[3], tab3=new int[3];
		
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			String[] tab = line.trim().split("\\s+");
			tab1[midCounter] = Integer.parseInt(tab[0]);
			tab2[midCounter] = Integer.parseInt(tab[1]);
			tab3[midCounter] = Integer.parseInt(tab[2]);
			midCounter++;
			if(midCounter==3){
				Arrays.sort(tab1);
				Arrays.sort(tab2);
				Arrays.sort(tab3);
				if(tab1[0]+tab1[1]>tab1[2])
					counter++;
				if(tab2[0]+tab2[1]>tab2[2])
					counter++;
				if(tab3[0]+tab3[1]>tab3[2])
					counter++;
				midCounter=0;
			}
			
		}
		
		System.out.println(counter);

	}

}
