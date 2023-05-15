package Programmers_Lvl2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        // int[] -> Integer[]
        Arrays.sort(Arrays.stream(truck_weights).boxed().toArray(Integer[]::new), Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(truck_weights[0]);
        int sum = truck_weights[0];
        int idx = 0;
        int zeroCnt = 0;
        while(!queue.isEmpty()){
            if(queue.size() == bridge_length) {
                if(zeroCnt == bridge_length) break;
                if(queue.peek() == 0) --zeroCnt;
                sum -= queue.peek();
                queue.poll();
            }
            if(idx + 1 < truck_weights.length &&
                    sum + truck_weights[idx+1] <= weight && queue.size() < bridge_length){
                queue.add(truck_weights[++idx]);
                sum += truck_weights[idx];
            }else{
                queue.add(0);
                ++zeroCnt;
            }
            ++answer;
        }
        return answer;
    }
}
