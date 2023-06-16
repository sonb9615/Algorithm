package Programmers_Lvl1;

import java.util.*;

public class 개인정수집유효기간 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String[] temp = today.split("\\.");
        sb.append(temp[0]).append(temp[1]).append(temp[2]);
        int std = Integer.parseInt(sb.toString());


        for(String str : terms){
            String[] sp = str.split(" ");
            map.put(sp[0], Integer.parseInt(sp[1]));
        }

        int idx = 0;
        for(String str : privacies){
            ++idx;
            String[] sp = str.split(" ");
            String type = sp[1];
            int plusYear = map.get(type) / 12;
            int plusMonth = map.get(type) % 12;
            sp = sp[0].split("\\.");
            sb = new StringBuilder();
            sb.append(Integer.parseInt(sp[0]) + plusYear + ((Integer.parseInt(sp[1]) + plusMonth) / 13));
            if((Integer.parseInt(sp[1]) + plusMonth) == 12) sb.append(12);
            else{
                if((Integer.parseInt(sp[1]) + plusMonth) % 12 < 10) sb.append("0");
                sb.append((Integer.parseInt(sp[1]) + plusMonth) % 12);
            }
            sb.append(sp[2]);
            if(std >= Integer.parseInt(sb.toString())) arr.add(idx);
        }

        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"A 5"};
        String[] prv = {"2019.07.01 A"};
        solution(today, terms, prv);

    }
}
