package Hash;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class Streaming {

	public int[] solution(String[] genres, int[] plays) {
        
		int[] answer = {};
        
        Map<String, Integer> sumgen = new HashMap<>();
        Map<Integer, String> gen = new HashMap<>();
        String[] ordgen = {""};
        int index = 0;
     
        for(int i = 0; i < genres.length; i++) {        	
        	sumgen.put(genres[i], sumgen.getOrDefault(genres[i], 0) + plays[i]);
        	gen.put(i, genres[i]);
        }
        
        sumgen = sortByValue(sumgen); // 내림차순으로 정렬된 장르map
        
        
        Iterator<String> iterator = sumgen.keySet().iterator();
        
		while(iterator.hasNext()) { 
			String key = (String)iterator.next(); 
			for(int i = 0; i < genres.length; i++) {
				if(genres[i] == key) {
					answer[index] = i;
					
				}
			}
		}
	
		
 
        return answer;
    }
	
	//map을 value값으로 내림차순 시키기
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        Collections.reverse(list);
        
        
        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
/*
 * for(int i = 0; i < genres.length; i++) { gen.put(genres[i],
 * gen.getOrDefault(genres[i], 0) + 1); }
 */