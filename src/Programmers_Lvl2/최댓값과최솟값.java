package Programmers_Lvl2;

public class 최댓값과최솟값 {

    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        String[] sp = s.split(" ");
        for(String n : sp){
            max = Math.max(max, Integer.parseInt(n));
            min = Math.min(min, Integer.parseInt(n));
        }
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
