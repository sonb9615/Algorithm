package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {
	
	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 1;
	        
	        //queue 는 다리
	        Queue<Integer> que = new LinkedList<Integer>();
	        // que에 들어가있는 값의 합
	        int sum = 0;
	        int idx = 1;
	        
	        que.add(truck_weights[0]);
	        sum = truck_weights[0];
	        
	        while(que.peek() != null){

	        	if(idx == truck_weights.length){
	        			
	        		que.add(-1);
	        	
	        	} else if(sum + truck_weights[idx] > weight) {
	        		
	        		que.add(0);
	        	
	        	} else{
	        		
	        		que.add(truck_weights[idx]);
	        		sum += truck_weights[idx];
	        		
	        		if(idx < truck_weights.length) {
	        			idx++;
	        		}
	        	}
	        	
	        	answer++;
	        	
	        	if(que.size() == bridge_length){
	        		sum -= que.poll();
	        		if(idx == truck_weights.length && que.peek() == -1) {
	        			answer++;
	        			break;
	        		}
	        	}
	        }
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		
		 int bridge_length = 2;
		 int weight = 10;
		 int[] truck_weights = {7,4,5,6};
//		 int bridge_length = 3;
//		 int weight = 3;
//		 int[] truck_weights = {3,3};
		 int a = solution(bridge_length, weight, truck_weights);
		 
		 System.out.println(a);
		 
	}
}
