package Programmers_Lvl2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {

    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> queue_1 = new LinkedList<>(Arrays.asList(Arrays.stream(queue1).boxed().toArray(Integer[]::new)));
        Queue<Integer> queue_2 = new LinkedList<>(Arrays.asList(Arrays.stream(queue2).boxed().toArray(Integer[]::new)));

        int end = (queue1.length + queue2.length) * 2;
        int cnt = 0;
        long sum1 = 0;
        long sum2 = 0;
       for(int i = 0; i < queue1.length; i++){
           sum1 += queue1[i];
           sum2 += queue2[i];
       }

       while(sum1 != sum2){
           if(sum1 > sum2){
               int x = queue_1.poll();
               sum1 -= x;
               queue_2.offer(x);
               sum2 += x;
           }else if(sum1 < sum2){
               int x = queue_2.poll();
               sum2 -= x;
               queue_1.offer(x);
               sum1 += x;
           }
           ++cnt;
           if(cnt > end) break;
       }
        if(sum1 != sum2) return -1;
        return cnt;
    }
}
