package Stack_Queue;

import java.util.PriorityQueue;

public class 과제진행하기 {
    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<String[]> sq = new PriorityQueue<>((o1, o2)->{
            return timeToInt(o1[1]) - timeToInt(o2[1]);
        });

        PriorityQueue<String[]> wq = new PriorityQueue<>((o1, o2)->{
            return timeToInt(o1[1]) - timeToInt(o2[1]);
        });

        for(int i = 0; i < plans.length; i++){
            sq.add(plans[i]);
        }

        int time = 0;
        int run = -1;
        String[] now = null;
        int idx = 0;
        while(true){
            if(wq.isEmpty() && sq.isEmpty()) break;
            ++run;
            if(now != null){
                if(Integer.parseInt(now[2]) == 1){
                    answer[idx] = now[0];
                    ++idx;
                    now = null;
                }else{
                    now[2] = String.valueOf(Integer.parseInt(now[2]) - 1);
                }
            }

            if(!sq.isEmpty() && timeToInt(sq.peek()[1]) == run){
                if(now != null) wq.add(now);
                now = sq.poll();
            }

            if(now == null){
                now = wq.poll();
            }

        }
        answer[idx] = now[0];
        return answer;
    }

    public static int timeToInt(String time){
        String[] sp = time.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }

    public static void main(String[] args) {
        String[][] s = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        solution(s);
    }
}
