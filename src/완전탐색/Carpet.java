package 완전탐색;

public class Carpet {

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i < yellow+1; i++) {
        	
        	if(yellow % i == 0) {
        		
        		if(brown == (((yellow/i)+2)*2) + (i*2)) {
        			answer[0] = (yellow/i)+2;
        			answer[1] = i+2;
        			break;
        		}else {
        			continue;
        		}
        		
        	}else {
        		continue;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] sol = solution(8,1);

		for(int a : sol) {
			System.out.println(a);
		}
	}

}
