package Heap;

import java.util.PriorityQueue;

public class MoreSpicy {

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(); 
        
        for(int scov : scoville) {
        	heap.offer(scov);
        }
        
        while(!heap.isEmpty()) {
        	if(heap.peek() < K) {
        		if(heap.size() == 1) {
        			answer = -1;
        			break;
        		}else {
        			int newScov = heap.poll() + (heap.poll() * 2);
        			heap.offer(newScov);
        		}
            	
            	answer++;
        	}else {
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String args[]) {
		
//		int[] scoville = {1, 2, 3, 9, 10, 12}; 
//		int K = 7;
		
		int[] scoville = {1,1,2}; 
		int K = 3;
		
		int a = solution(scoville, K);
		System.out.println(a);
	}
}
