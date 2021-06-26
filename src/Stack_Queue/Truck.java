package Stack_Queue;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Truck {
	
	 public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue qu = new LinkedList(); 
	        ArrayList arr = new ArrayList<Integer>();
	        int temp = 0;
	        
	        for(int i = 0; i < truck_weights.length; i++) {
	        	qu.offer(truck_weights[i]);
	        	System.out.println("i : " + i);
	        	temp = (int)qu.peek();
	        	for(int j = i + 1; j < truck_weights.length; j++) {
	        		temp = temp + truck_weights[j];
	        		System.out.println("temp : " + temp);
	        		if(temp > weight) {
	        			System.out.println("temp : " + temp + " / qu.peek() : " + qu.peek());
	        			qu.poll();
	        			//temp = 0;
	        			i = j;
	        			System.out.println(j);
	        			answer = answer + bridge_length;
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
		 int a = solution(bridge_length, weight, truck_weights);
		 
		 System.out.println(a);
		 
	}
}
