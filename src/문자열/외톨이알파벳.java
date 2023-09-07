package 문자열;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 외톨이알파벳 {
    public String solution(String input_string) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        char c = ' ';
        for(char cc : input_string.toCharArray()){
            if(c != cc){
                if(!map.containsKey(cc)){
                    map.put(cc, 1);
                }else{
                    map.put(cc, map.get(cc) + 1);
                }
                c = cc;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char cc : map.keySet()){
            if(map.get(cc) > 1) sb.append(cc);
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        answer = new String(chars);
        if(answer.equals("")) answer = "N";
        return answer;
    }
}
