package 완전탐색;

import java.util.ArrayList;

public class BestScore {

	public static int[] solution(int[] answers) {
        
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] sc = {0,0,0};
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == one[i%one.length]) {
        		sc[0]++;
        	}
        	if(answers[i] == two[i%two.length]) {
        		sc[1]++;
        	}
        	if(answers[i] == three[i%three.length]) {
        		sc[2]++;
        	}
        }
        
        int max = sc[0];
        for(int a : sc) {
        	if(a >= max) {
        		max = a;
        	}
        }
        
        for(int i = 0; i < sc.length; i++) {
        	if(sc[i] == max) {
        		arr.add(i+1);
        	}
        }
        
        int[] answer = new int[arr.size()];
        int idx = 0;
        for(int a : arr) {
        	answer[idx++] = a;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {

		int[] anw = {1,2,3,4,5};
		
		for(int a : solution(anw)) {
			System.out.println(a);
		}
	}

}
