package programmers_0910;

import java.util.ArrayList;
import java.util.Scanner;

public class 정수오름차순더하기 {
	
	public static int[] solution(int[] numbers) {
		
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<Integer> com = new ArrayList<>();
        
		int x = 0;
		
        for(int i = 0; i < numbers.length; i++) {
        	for(int j = i+1; j <numbers.length; j++) {
        		if(x != numbers[i] + numbers[j]) {
        			temp.add(numbers[i] + numbers[j]);
        		}
        		x = numbers[i] + numbers[j];
        	}
        }
        
        int[] answer = new int[temp.size()];
        int len = 0;
        for(int A : temp) {
        	answer[len] = A;
        	len++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] answer = {};
		int[] numbers = {2,1,3,4,1};
		answer = solution(numbers);
		for(int i = 0; i<answer.length; i++) {
			System.out.println(i + " : " + answer[i]);
		}
		
	}
}
