package Programmers_Lvl1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> callCnt = new HashMap<>();
        Map<String, Map<String, Integer>> calledUser = new HashMap<>();

        for(String rp : report){
            String[] sp = rp.split(" ");

            if(!calledUser.containsKey(sp[0])){

                if(callCnt.containsKey(sp[1])){
                    callCnt.put(sp[1],callCnt.get(sp[1]) + 1);
                }else{
                    callCnt.put(sp[1],1);
                }

                Map<String, Integer> map = new HashMap<>();
                map.put(sp[1],1);
                calledUser.put(sp[0],map);
            }else{
                if(!calledUser.get(sp[0]).containsKey(sp[1])){
                    if(callCnt.containsKey(sp[1])){
                        callCnt.put(sp[1],callCnt.get(sp[1]) + 1);
                    }else{
                        callCnt.put(sp[1],1);
                    }
                    calledUser.get(sp[0]).put(sp[1],1);
                }
            }
        }

        int idx = -1;
        for(String id : id_list){
            ++idx;
            int cnt = 0;
            if(calledUser.containsKey(id)){
                for(String user : calledUser.get(id).keySet()){
                    if(callCnt.get(user) >= k){
                        ++cnt;
                    }
                }
            }
            answer[idx] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        /*String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;*/

        int[] answer = solution(id_list, report, k);

        for(int a : answer){
            System.out.println(a);
        }
    }

}
