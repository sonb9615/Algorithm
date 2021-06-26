package Stack_Queue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Printer {

	public static int solution(int[] priorities, int location) {
		int answer = 0;      
        Queue qu = new LinkedList();
        Queue od = new LinkedList();
        
        for(int i = 0; i < priorities.length; i++) {
        	qu.offer(priorities[i]);
        	od.offer(i);       	
        }
        
        while(!qu.isEmpty()) {
        	int ch = 0;
        	int odpk = (int)od.peek();        	
        	int temp = 0;
        	
        	for(int i = 0; i < priorities.length; i++) {      		
        		if(priorities[0] == 0) {
        			ch = 1;
        			break;
        		}       		
        		if( priorities[0]< priorities[i]) {        			
        			qu.offer((int)qu.peek());      			
        			qu.poll();
        			od.offer((int)od.peek());        			
					od.poll();
					ch = 1;
					break;
        		}      		
        	}
        	temp = priorities[0];
			for(int j = 0; j < priorities.length -1; j++) {
				priorities[j] = priorities[j+1];					
			}
			
			priorities[priorities.length-1] = temp;
			if ( ch != 1) {
				answer++;
				qu.poll();
				odpk = (int)od.peek();
				od.poll();
				priorities[priorities.length - 1] = 0;
			}
			
        	if(odpk == location && ch != 1) {
				return answer;	
			}        	
		}
		return answer;
	}

	public static void main(String[] args) {

		int[] priorities = {1,2,3,4};
		int location = 1;
		int a = 0;
		a = solution(priorities, location);
		System.out.println(a);
	}
}
