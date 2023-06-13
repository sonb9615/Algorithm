package Programmers_Lvl1;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("N", 0);
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);

        for(int i = 0; i < survey.length; i++){
            if(choices[i] == 4) continue;
            int score = 0;
            if(choices[i] == 3 || choices[i] == 5) score = 1;
            else if(choices[i] == 2 || choices[i] == 6) score = 2;
            else score = 3;

            if(choices[i] < 4) map.put(survey[i].substring(0,1), map.get(survey[i].substring(0,1))+score);
            else map.put(survey[i].substring(1,2), map.get(survey[i].substring(1,2))+score);
        }

        StringBuilder sb = new StringBuilder();
        if(map.get("R") >= map.get("T")) sb.append("R");
        else sb.append("T");
        if(map.get("C") >= map.get("F")) sb.append("C");
        else sb.append("F");
        if(map.get("J") >= map.get("M")) sb.append("J");
        else sb.append("M");
        if(map.get("A") >= map.get("N")) sb.append("A");
        else sb.append("N");

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "12";
        System.out.println(str.substring(1,2));
    }
}
