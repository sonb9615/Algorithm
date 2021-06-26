package Array;

import java.util.Arrays; 
import java.util.ArrayList;

public class MaxNumber {

	public static String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String[] carr = new String[numbers.length];
        String[] subcarr = new String[numbers.length];
        int len = 1;
        
        for(int i = numbers.length; i > 1 ; i--) {
        	len = len * i;
        }
        
        for(int i = 0; i < numbers.length; i++) {
        	carr[i] = Integer.toString(numbers[i]);
        	subcarr[i] = Integer.toString(numbers[i]);
        }
        
        for(int i = 0; i < carr.length; i++) {
        	String temp = carr[0];
        	carr[0] = carr[i];
        	carr[i] = temp;
        	
        	
        	//초기화
        	for(int j = 0; j < carr.length; j++) {
        		carr[j] = subcarr[j];
        	}
        }
       
        return answer;
    }
	
	
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		String result = solution(numbers);
		
		System.out.println(result);
	}
}
