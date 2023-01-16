package Programmers_Lvl2;


import java.util.HashMap;
import java.util.Map;

public class 단체사진찍기_카카오2017 {

    static Map<Character, Integer> map;
    static boolean[] visited;
    static int[] ch;
    static int answer;

    public static int solution(int n, String[] data) {
        answer = 0;
        map = new HashMap<>();
        visited = new boolean[8];
        ch = new int[8];
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        dfs(0,data);
        return answer;
    }

    public static void dfs(int idx, String[] data){
        if(idx == 8 && check(data)){
            ++answer;
        }else{
            for(int i = 0; i < 8; i++){
                if(!visited[i]){
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx+1, data);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean check(String[] data){
        for(String s : data){
            int a = ch[map.get(s.charAt(0))];
            int b = ch[map.get(s.charAt(2))];
            int dist = Character.getNumericValue(s.charAt(4)) + 1;
            char c = s.charAt(3);

            if(c == '='){
                if(Math.abs(a-b) != dist) return false;
            }
            if(c == '>'){
                if(Math.abs(a-b) <= dist) return false;
            }
            if(c == '<'){
                if(Math.abs(a-b) >= dist) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str = {"N~F=0", "R~T>2"};
        System.out.println(solution(2, str));
    }
}
