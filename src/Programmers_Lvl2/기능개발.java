package Programmers_Lvl2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> arr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] != 0){
                queue.add((100 - progresses[i]) / speeds[i] + 1);
            }else queue.add((100 - progresses[i]) / speeds[i]);
        }
        int day = queue.peek();
        int cnt = 0;
        while (!queue.isEmpty()){
            if(queue.peek() <= day) {
                ++cnt;
                queue.poll();
                if(queue.isEmpty()) arr.add(cnt);
            }else{
                arr.add(cnt);
                cnt = 0;
                day = queue.peek();
            }
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] pro = {93, 30, 55};
        int[] sp = {1, 30, 5};
        solution(pro, sp);
    }
}
