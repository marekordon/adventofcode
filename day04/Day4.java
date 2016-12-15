package ordon.marek.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Day4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line;
		int sum = 0;
		int id = 0;
		String[] tab;
		String[] tab2;
		String wynik="";
		char previous=' ';
		
		while(scanner.hasNextLine()){
			Map<Character, Integer> wyjscie = new HashMap<Character,Integer>();
			line = scanner.nextLine();
			tab = line.split("\\[");
			wynik = tab[1].substring(0, 5);
			tab2 = tab[0].split("-");
			id = Integer.parseInt(tab2[tab2.length-1]);
			tab2 = Arrays.copyOfRange(tab2, 0, tab2.length-1);
			String s = String.join("", tab2);
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			for (int i = 0; i < chars.length; i++) {
				if(chars[i]==previous){
					wyjscie.put(Character.valueOf(chars[i]),wyjscie.get(Character.valueOf(chars[i]))+1);
				} else {
					wyjscie.put(Character.valueOf(chars[i]),Integer.valueOf(1));
					previous=chars[i];
				}
			}
			previous = ' ';
			List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(wyjscie.entrySet());
			CompareMap compare = new CompareMap();
			Collections.sort(list, compare);
			int size = list.size()>5?5:list.size();
			String forComparition = "";
			System.out.println(list);
			for (int i = 0; i < size; i++) {
				forComparition += list.get(i).getKey().toString();
			}
			System.out.println(forComparition +" - "+wynik);
			if(forComparition.equals(wynik)){
				sum+=id;
			}
		}
		System.out.println(sum);

	}

}
