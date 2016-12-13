package ordon.marek.adventofcode;

import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line;
		int counter = 0;
		
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			String[] tab = line.trim().split("\\s+");
			System.out.println(Arrays.toString(tab));
			int[] array = Arrays.asList(tab).stream().mapToInt(Integer::parseInt).toArray();
			Arrays.sort(array);
			if(array[0]+array[1]>array[2])
				counter++;
		}
		
		System.out.println(counter);

	}

}
