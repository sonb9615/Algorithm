package Hash;
import java.util.HashMap;
import java.util.Map;
public class FindNonComplete {

	public String solution(String[] participant, String[] completion) {

		Map<String, Integer> part = new HashMap<>();
		String answer = "";
		

		for(String word : participant) {
			if(part.containsKey(word)) {
				Integer value = part.get(word);
				part.put(word, ++value);
			}
			else {
				part.put(word, 1);
			}
		}

		for(String word : completion) {
			if(part.containsKey(word)) {
				Integer value = part.get(word);
				part.put(word, --value);
			}
		}
		
		for(String word : participant) {
			if(part.get(word) != 0) {
				answer = word;
			}
		}
		
		return answer;

	}
	
	
	
}