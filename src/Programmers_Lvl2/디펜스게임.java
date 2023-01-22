package Programmers_Lvl2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스게임 {

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int keyCnt = k;
        int curr = n;
        for(int i = 0; i < enemy.length; i++){
            curr -= enemy[i];
            pq.add(enemy[i]);
            while(curr < 0){
                if(answer > 0) break;
                if(keyCnt > 0 && !pq.isEmpty()){
                    curr += pq.poll();
                    --keyCnt;
                }else{
                    answer = i;
                    break;
                }
            }
        }
        answer = answer == 0 ? enemy.length : answer;
        return answer;
    }
}
