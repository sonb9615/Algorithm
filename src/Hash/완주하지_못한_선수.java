package Hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for(String name : participant){
            if(map.containsKey(name)) map.put(name, map.get(name) + 1);
            else map.put(name, 1);
        }

        for(String name : completion){
            if(map.containsKey(name)) map.put(name, map.get(name) - 1);
        }

        for(String name : map.keySet()){
            if(map.get(name) > 0) return name;
        }

        return answer;
    }
}
