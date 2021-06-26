package Stack_Queue;

import java.util.Stack;

public class StockPrice {

	 public static int[] solution(int[] prices) {
	     int[] answer = {};
	     answer = new int[prices.length];
	     Stack st = new Stack<Integer>();
	     
	     for(int i = 0; i < prices.length - 1; i++) {
	    	 for(int j = i + 1; j < prices.length; j++) {
	    		 if(prices[i] <= prices[j]) {
	    			 answer[i] = j-i;
	    		 }
	    		 else {
	    			 answer[i] = j -i;
	    			 break;
	    		 }
	    	 }
	     }
	     
	     return answer;
	 }
	
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] a = solution(prices);
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
	}
}
