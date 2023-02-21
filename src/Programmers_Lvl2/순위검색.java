package Programmers_Lvl2;

import java.util.*;

public class 순위검색 {

    static Map<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        for(String str : info){
            String[] sp = str.split(" ");
            setAllCase(sp, "", 0);
        }
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        for(int i = 0; i < query.length; i++){
            String[] sp = query[i].split(" and | ");
            StringBuilder sb = new StringBuilder();
            sb.append(sp[0]).append(sp[1]).append(sp[2]).append(sp[3]);
            String str = sb.toString();
            if(map.containsKey(str)){
                answer[i] += bs(map.get(str),0, map.get(str).size()-1,Integer.parseInt(sp[4]));
            }
        }
        return answer;
    }

    public static int bs(List<Integer> arr,int L, int R ,int val){

        while(L <= R){
            int mid = (L + R) / 2;
            if(arr.get(mid) < val){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return arr.size() - L;
    }

    public static void setAllCase(String[] info, String str, int cnt){
        if(cnt == 4){
            if(!map.containsKey(str)) map.put(str, new ArrayList<>());
            map.get(str).add(Integer.parseInt(info[4]));
            return;
        }
        setAllCase(info, str+"-", cnt+1);
        setAllCase(info, str+info[cnt], cnt+1);
    }
}
