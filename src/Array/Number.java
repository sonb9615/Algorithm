package Array;

import java.util.Arrays;

public class Number {

	  public static int[] solution(int[] array, int[][] commands) {
	      int[] answer = {};
	      answer = new int[commands.length];
	      for(int i = 0; i < commands.length; i++) {
	    	  int x = commands[i][0];
	    	  int y = commands[i][1];
	    	  int z = commands[i][2];
	    	  
	    	  int[] arr = new int[y-x+1];
	    	  
	    	  int idx = 0;
	    	  
	    	  for(int j = x-1; j <= y-1; j++) {
	    		  arr[idx] = array[j]; 
	    		
	    		  idx++;	
	    		  
	    	  }
	    	  Arrays.sort(arr);
	    	  
			
	    	  answer[i] = arr[z-1];
	    	  
	      }
	      
	      
	      return answer;
	  }
	
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] result = new int[commands.length];
		result = solution(array, commands);
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
}
