package Greedy;

import java.util.Arrays;

public class Sportswear {

	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int j = 0; j < lost.length; j++) {
        	for(int i = 0; i < reserve.length; i++) {
        		if(reserve[i] == lost[j]) {
        			lost[j] = -1;
        			reserve[i] = -1;
        			break;
        		}
        	}
        }
        
        for(int j = 0; j < lost.length; j++) {
        	for(int i = 0; i < reserve.length; i++) {
        		if(reserve[i] == lost[j] + 1 || reserve[i] == lost[j] - 1) {
        			lost[j] = -1;
        			reserve[i] = -1;
        			break;
        		}
        	}
        }
        
        for(int L : lost) {
        	if(L > 0) {
        		answer--;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
		int n = 10;
		int[] lost = {3,4};
		int[] reserve = {4,5};
		System.out.println(solution(n, lost, reserve));
		

	}

}
