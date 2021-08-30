package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
	
	public static int[] solution(String[] operations) {
		
		int cnt = 0;
		// 최솟값
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
        //최댓값
        PriorityQueue<Integer> rpq= new PriorityQueue<Integer>(Collections.reverseOrder());

        for(String str : operations){
        	String[] sp = str.split(" ");
        	if(sp[0].equals("I")){
        		cnt += 1;
        		pq.offer(Integer.parseInt(sp[1]));
        		rpq.offer(Integer.parseInt(sp[1]));
        	}else if(sp[0].equals("D") && pq.size() != 0 && rpq.size() != 0){
        		cnt -= 1;
        		if(sp[1].equals("1")) {
        			rpq.poll();
        		}else {
        			pq.poll();
        		}
        	}
        	
        	if(pq.size() == 0 || rpq.size() == 0 || cnt == 0){
        		pq.clear();
        		rpq.clear();
        	}
        }
        
        if(rpq.size() == 0 || pq.size() == 0) {
        	int[] answer = {0,0};
        	return answer;
        }else {
        	int[] answer = {rpq.poll(),pq.poll()};
        	return answer;
        }
        
        

    }
	
	
	public static void main(String args[]) {
		
//		"I 7","I 5","I -5","D -1" -> 7,5
//		"I 16","D 1" -> 0,0
//		"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" -> 0,0
		String[] operations = {"I 7","D 1","I 7","I 7","D 1","D -1"};
		
		int [] result = solution(operations);
		
		for(int i : result) {
			System.out.println(i);
		}
	}

}
