package Array;

import java.util.*;

public class 메뉴리뉴얼 {

    private static Map<String, Integer> map;

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> arr = new ArrayList<>();

        for(int i = 0; i < orders.length; i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        for(int i = 0; i < course.length; i++){
            map = new TreeMap<>();
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < orders.length; j++){
                StringBuilder sb = new StringBuilder();
                makeCombination(course[i], sb, 0, 0, orders[j]);
            }

            for(String key : map.keySet()){
                if(map.get(key) > 1){
                    max = Integer.max(max, map.get(key));
                }
            }

            for(String key : map.keySet()){
                if(map.get(key) == max){
                    arr.add(key);
                }
            }
        }

        String[] answer = new String[arr.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private static void makeCombination(int r, StringBuilder sb, int current, int start, String str) {
        if (r == current) {
            if(!map.containsKey(sb.toString())) map.put(sb.toString(), 0);
            map.put(sb.toString(), map.get(sb.toString()) + 1);
        } else {
            for (int i = start; i < str.length(); i++) {
                sb.append(str.charAt(i));
                makeCombination(r, sb, current + 1, i + 1, str);
                sb.deleteCharAt(current);
            }
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};
        solution(orders, course);
    }
}
