package BFS_DFS;

import java.util.Arrays;

public class WordTransform {

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;


        if(!Arrays.stream(words).anyMatch(target::equals)){
        	return answer;
        }

        
        for(String word : words){
        	
        	String chk = compWord(begin,word);
        	if(!chk.equals(target)){
        		begin = chk;
        		answer++;
        	}
        }
        
        
        /////////////////////////
//        for(String word : words){
//        	if(word.equals(target)){
//        		answer++;
//        		break;
//        	}else{
//        		if(!compWord(begin,word).equals(target)){
//            		begin = target;
//            		answer++;
//            	}
//        	}
//        }

        return answer;
    }
	
	
	public static String compWord(String str, String word) {

	      int cnt = 0;

	      for(int i = 0; i < str.length(); i++) {
	         if(str.charAt(i) == word.charAt(i)) {
	            cnt++;
	         }
	      }

	      if(cnt == str.length() - 1) {
	         return word;
	      }

	      return str;
	}
	
	public static void main(String[] args) {
		
		String begin = "hit";
		String target = "cog";
//		String[] words = {"cog", "log", "lot", "dog", "dot", "hot"};
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin, target, words));
	}
}
