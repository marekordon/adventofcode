package ordon.marek.adventofcode;

import java.util.Comparator;
import java.util.Map;

public class CompareMap implements Comparator<Map.Entry<Character,Integer>> {

	@Override
	public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
		if(o1.getValue().compareTo(o2.getValue())!=0){
			return o2.getValue().compareTo(o1.getValue());
		} else {
			return o1.getKey().compareTo(o2.getKey());
		}
	}
	
}
