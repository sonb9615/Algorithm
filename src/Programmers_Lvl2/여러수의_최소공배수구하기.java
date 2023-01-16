package Programmers_Lvl2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 여러수의_최소공배수구하기 {

    //최소공배수 구하기
    public static int solution(int[] arr) {
        int answer = 1;
        Map<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> pm = new ArrayList<>();
        for(int i = 2; i <= 100; i++){
            int count = 0;
            for(int j = 2; j <= i; j++){
                if(i%j == 0){
                    ++count;
                }
            }
            if(count == 1){
                pm.add(i);
            }
        }

        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            int idx = 0;
            int[] cnt = new int[num+1];
            while(num > 1){
                if(num % pm.get(idx) == 0){
                    ++cnt[pm.get(idx)];
                    num = num / pm.get(idx);
                    continue;
                }
                ++idx;
            }
            for(int j = 0; j < cnt.length; j++){
                if(cnt[j] == 0) continue;
                if(map.containsKey(j)){
                    map.put(j, Math.max(cnt[j], map.get(j)));
                    continue;
                }
                map.put(j, cnt[j]);
            }
        }

        for(int x : map.keySet()){
            answer *= Math.pow(x,map.get(x));
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(solution(arr));
    }
}
