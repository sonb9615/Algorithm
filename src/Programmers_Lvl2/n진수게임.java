package Programmers_Lvl2;

import java.util.Locale;

public class n진수게임 {

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int x = -1;
        while(t > 0){
            String str = Integer.toString(++x, n);
            for(int i = 0; i < str.length(); i++){
                if(t == 0) break;
                if(--p == 0) {
                    sb.append(str.charAt(i));
                    p = m;
                    --t;
                }
            }
        }
        answer = sb.toString();
        return answer.toUpperCase();
    }

    public static void main(String[] args) {
        solution(2,4,2,1);
    }
}
