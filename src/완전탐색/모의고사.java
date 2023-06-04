package 완전탐색;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 모의고사 {

    public int[] solution(int[] answers) {
        int[] answer = {};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,0);
        map.put(2,0);
        map.put(3,0);

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int aIdx = -1;
        int bIdx = -1;
        int cIdx = -1;
        int max = Integer.MIN_VALUE;
        for(int x : answers){
            if(aIdx == a.length - 1) aIdx = -1;
            if(x == a[++aIdx]) map.put(1, map.get(1) + 1);
            if(bIdx == b.length - 1) bIdx = -1;
            if(x == b[++bIdx]) map.put(2, map.get(2) + 1);
            if(cIdx == c.length - 1) cIdx = -1;
            if(x == c[++cIdx]) map.put(3, map.get(3) + 1);
            max = Integer.max(max, map.get(1));
            max = Integer.max(max, map.get(2));
            max = Integer.max(max, map.get(3));
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i < 4; i++){
            if(map.get(i) == max) arr.add(i);
        }

        answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
