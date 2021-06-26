package Stack_Queue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Top {
	public static int[] solution(int[] heights) {
        int[] answer = {};        
        Stack st = new Stack();
        answer = new int[heights.length];
        
        for(int i = heights.length-1; i >= 0; i--) {
        	st.push(heights[i]);
        	System.out.println(st.peek());
        	for(int j = i - 1; j >= 0; j--) {
        		if((int)st.peek() < heights[j]) {
        			answer[i] = j + 1;
        			
        			break;
        		}
        		else {
        			answer[i] = 0;
        		}
        	}
        	st.pop();
        	
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] height = {6,9,5,7,4};
		int[] arr = {};
		arr = solution(height);
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}	
		
}
