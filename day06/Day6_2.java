package ordon.marek.adventofcode;

import java.util.*;

/**
 * Created by Marek Ordon on 16.12.16.
 */
public class Day6_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        List<Map<Character, Integer>> wyjscie = new ArrayList<>();

        for (int i = 0; i<8; i++){
            wyjscie.add(new HashMap<Character, Integer>());
        }

        while(scanner.hasNext()){
            line = scanner.nextLine();
            for (int i=0; i<8; i++){
                if (wyjscie.get(i).containsKey(Character.valueOf(line.charAt(i)))){
                    wyjscie.get(i).put(Character.valueOf(line.charAt(i)),wyjscie.get(i).get(Character.valueOf(line.charAt(i)))+1);
                } else {
                    wyjscie.get(i).put(Character.valueOf(line.charAt(i)),1);
                }
            }
        }

        CompareMap compare = new CompareMap();
        for (Map m: wyjscie) {
            List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(m.entrySet());
            Collections.sort(list, compare);
            System.out.print(list.get(list.size()-1).getKey());
        }
        System.out.println();

    }

}
