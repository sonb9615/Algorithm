package Programmers_Lvl3;

import java.util.*;

public class 불량사용자 {

    static ArrayList<Map<String, Integer>>[] arr;
    static HashMap<String, Integer>[] maps;
    static HashMap<String, Integer> result;
    static StringBuilder sb = new StringBuilder();

    public static int solution(String[] user_id, String[] banned_id) {
        arr = new ArrayList[banned_id.length];
        maps = new HashMap[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) {
            arr[i] = new ArrayList<>();
            maps[i] = new HashMap<>();
        }
        result = new HashMap<>();

        Arrays.sort(banned_id, Collections.reverseOrder());
        for(int i = 0; i < user_id.length; i++){
            banCheck(user_id[i], banned_id);
        }
        selectCase(new TreeMap<String, Integer>(), 0);

        return result.size();
    }

    public static void banCheck(String user_id, String[] bannned_id){
        for(int i = 0; i < bannned_id.length; i++){
            if(user_id.length() != bannned_id[i].length()) continue;
            boolean chk = true;
            for(int j = 0; j < bannned_id[i].length(); j++){
                if(bannned_id[i].charAt(j) == '*'
                        || bannned_id[i].charAt(j) == user_id.charAt(j)) continue;
                else chk = false;
            }
            if(chk){
                maps[i].put(user_id, 1);
            }
        }
    }

    public static void selectCase(TreeMap<String, Integer> map, int cnt){
        if(cnt == maps.length) return;
        for(String key : maps[cnt].keySet()){
            if(map.containsKey(key)) continue;
            else {
                map.put(key, 1);
                selectCase(map, cnt + 1);
                if(cnt == maps.length-1) {
                    for(String s : map.keySet()) sb.append(s);
                    result.put(sb.toString(),1);
                }
                map.remove(key);
                sb = new StringBuilder();
            }
        }
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        solution(user_id, banned_id);
        //String s = "1234";
        //System.out.println(s.substring(0,2));
    }

}
