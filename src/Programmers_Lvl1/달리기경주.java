package Programmers_Lvl1;

import java.util.*;

public class 달리기경주 {
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        TreeMap<Integer, String> idxMap = new TreeMap<>();
        for(int i = 0 ; i < players.length; i++){
            map.put(players[i], i);
            idxMap.put(i, players[i]);
        }
        for(String name : callings){
            int idx = map.get(name);
            String loseName = idxMap.get(idx-1);
            map.put(name, idx-1);
            map.put(loseName, idx);
            idxMap.put(idx-1, name);
            idxMap.put(idx, loseName);
        }
        for(int idx : idxMap.keySet()){
            answer[idx] = idxMap.get(idx);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        solution(players, callings);
    }
}
