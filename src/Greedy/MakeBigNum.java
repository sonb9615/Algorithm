package Greedy;

public class MakeBigNum {

	public static String solution(String number, int k) {
		//문자열의 순서는 바뀌지 말아야 한다.
        String answer = "";
        
        int idx = 0;
        int lastIdx = -1;
        boolean chk = true;
        while(k > 0) {
        	int max = -1;
        	for(int i = lastIdx + 1; i <= lastIdx + k + 1; i++) {
        		if(i >= number.length()) {
        			chk = false;
        			break;
        		}
        		if(number.charAt(i) == '9') {
        			max = Character.getNumericValue(number.charAt(i));
        			idx = i;
        			break;
        		} else if(max < Character.getNumericValue(number.charAt(i))) {
        			max = Character.getNumericValue(number.charAt(i));
        			idx = i;
        		}
        	}
        	
        	answer += number.charAt(idx);
        	k -= idx - lastIdx - 1;
        	lastIdx = idx;
        	if(!chk) {
        		break;
        	}
        }
        if(k > 0) {
        	answer = answer.substring(0,number.length() - k);
        }else {
        	answer += number.substring(lastIdx+1);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("1999999",1));
		
	}

}
