package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 운영체제 {
    public static long[] solution(int[][] program) {
        long[] answer = new long[11];
        PriorityQueue<int[]> waitQueue = new PriorityQueue<>((o1,o2)->{
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        PriorityQueue<int[]> sleepQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        sleepQueue.addAll(Arrays.asList(program));

        long time = -1;
        int run = 0;
        while (true) {
            if(sleepQueue.isEmpty() && waitQueue.isEmpty() && run == 0) break;
            ++time;
            if(run > 0) --run;
            while (!sleepQueue.isEmpty() && sleepQueue.peek()[1] == time) {
                waitQueue.add(sleepQueue.poll());
            }
            if (run == 0 && !waitQueue.isEmpty()) {
                int[] now = waitQueue.poll();
                answer[now[0]] += time - now[1];
                run += now[2];
            }
        }
        answer[0] = time;
        return answer;
    }

    public static void main(String[] args) {
        int[][] p = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}};
        solution(p);
    }

}
