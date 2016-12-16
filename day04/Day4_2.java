package ordon.marek.adventofcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line;
		int id = 0;
		String[] tab;
		String[] tab2;
		
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			tab = line.split("\\[");
			tab2 = tab[0].split("-");
			id = Integer.parseInt(tab2[tab2.length-1]);
			tab2 = Arrays.copyOfRange(tab2, 0, tab2.length-1);
			id = id%26;
			String output = "";
			for (int i = 0; i < tab2.length; i++) {
				output += cipher(tab2[i],id);
				output += " ";
			}
			if (output.contains("north")) {
				System.out.println(line);
				System.out.println(output + " " + id);
			}
		}

	}
	
	private static String cipher(String msg, int shift){
	    String s = "";
	    int len = msg.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(msg.charAt(x) + shift);
	        if (c > 'z')
	            s += (char)(msg.charAt(x) - (26-shift));
	        else
	            s += (char)(msg.charAt(x) + shift);
	    }
	    return s;
	}

}
