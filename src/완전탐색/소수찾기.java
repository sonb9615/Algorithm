package 완전탐색;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 소수찾기 {

    public static Map<Integer, Integer> map;

    public static int solution(String numbers) {
        int answer = 0;
        map = new HashMap<>();
        char[] num = numbers.toCharArray();
        for(int i = 1; i <= numbers.length(); i++){
            StringBuilder sb = new StringBuilder();
            makeCombination(num, 0, sb, i, 0);
        }

        for(int n : map.keySet()){
            if(n == 1 || n == 0) continue;
            if(isDecimal(n)) ++answer;
        }
        return answer;
    }

    public static void makeCombination(char[] chars, int current, StringBuilder sb, int r, int start){
        if(current == r){
            makePermutation(r, new ArrayList<>(), 0, new boolean[r], sb.toString());
        }else{
            for(int i = start; i < chars.length; i++){
                sb.append(chars[i]);
                makeCombination(chars, current + 1, sb, r, i+1);
                sb.deleteCharAt(current);
            }
        }
    }

    private static void makePermutation(int r, ArrayList<Integer> temp, int current, boolean[] visited, String str) {
        if(current == r){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < temp.size(); i++){
                sb.append(temp.get(i));
            }
            map.put(Integer.parseInt(sb.toString()), 1);
        }else{
            for (int i = 0; i < str.length(); i++) {
                if(!visited[i]){
                    visited[i] = true;
                    temp.add(Integer.parseInt(String.valueOf(str.charAt(i))));
                    makePermutation(r, temp, current+1, visited, str);
                    temp.remove(temp.size()-1);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean isDecimal(int num){
        if(num == 2) return true;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("1111"));
    }
}
