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

			int num = 1; //�ش� �ǻ� ������ ���� + �ش� ���� ���Դ� ���(1)
			int N = 1; // ������ ����
	        
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
			
			answer = num - 1; // ��� ���Դ� ���(1)�� ������
			return answer;
	    }

	
}
