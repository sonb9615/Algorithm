package Hash;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SpyClothes {

	 public int solution(String[][] clothes) {
	        int answer = 0;
			Map<String, Integer> spy = new HashMap<>();

			int num = 1; //해당 의상 종류의 갯수 + 해당 종류 안입는 경우(1)
			int N = 1; // 종류의 갯수
	        
			for(int i = 0; i < clothes.length; i++) {
				spy.put(clothes[i][1], spy.getOrDefault(clothes[i][1], 0) + 1);
				
			}

			Iterator<String> iterator = spy.keySet().iterator();
			while(iterator.hasNext()) {
	           
				String Key = (String)iterator.next();
				num = num * (spy.get(Key)+1);
	            if(spy.size() == N){
	                N = 0;
	                break;
	            }	    
			}
			
			answer = num - 1; // 모두 안입는 경우(1)을 빼주자
			return answer;
	    }

	
}
