package TwoPointers;

import java.util.*;

public class 보석쇼핑 {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> germList = new HashSet<>(Arrays.asList(gems));
        if(germList.size() == 1) return new int[]{1,1};

        int start = 0;
        int length = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for(int end = 0; end < gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);

            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start]) - 1);
                ++start;
            }

            if(map.size() == germList.size() && length > end - start){
                length = end - start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] germs = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        solution(germs);
    }
}
