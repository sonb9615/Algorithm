package Greedy;

public class Joystick {

	public static int solution(String name) {
        
		int answer = 0;
        
        
        int min = name.length() - 1;
        
        for(int i = 0; i < name.length(); i++) {
        	
        	// 1. 상, 하
        	answer += Math.min((int)name.charAt(i)-65, 91 - (int)name.charAt(i));
        	
        	//2. 좌, 우
        	
        	int nextIdx = i+1;
        	while(nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
        		nextIdx++;
        	}
        	min = Math.min(min, (i*2) + name.length() - nextIdx);
        }
        
        answer += min;
        
        return answer;
    }
	
	public static void main(String[] args) {
		
 		System.out.println(solution("JAZ"));		
		
	}

}
