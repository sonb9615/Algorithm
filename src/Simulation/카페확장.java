package Simulation;

import java.util.LinkedList;
import java.util.Queue;

public class 카페확장 {
    public static int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int run = 0;
        int time = 0;
        int cnt = 1;
        Queue<Integer> wq = new LinkedList<>();
        wq.add(0);
        int idx = 0;
        while(idx < order.length){
            --time;
            if(run > 0 && run % k == 0){
                if(idx+1 >= order.length) break;
                wq.add(++idx);
                ++cnt;
            }
            if(time <= 0){
                if(cnt > 0 && time == 0) --cnt;
                if(!wq.isEmpty()) time = menu[order[wq.poll()]];
            }
            answer = Integer.max(answer, cnt);
            ++run;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] m = {5, 6, 7, 11};
        int[] o = {1, 2, 3, 3, 2, 1, 1};
        int k = 10;
        //2
        solution(m, o, k);
    }
}
