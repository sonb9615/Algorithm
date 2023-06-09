package Programmers_Lvl1;

public class 이상한문자만들기 {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                if(word.length() > 0) {
                    sb.append(word);
                    word = new StringBuilder();
                }
                sb.append(' ');
                idx = 0;
                continue;
            }
            if(idx % 2 == 0) word.append(String.valueOf(s.charAt(i)).toUpperCase());
            else word.append(String.valueOf(s.charAt(i)).toLowerCase());
            ++idx;
        }
        if(word.length() > 0) sb.append(word);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
