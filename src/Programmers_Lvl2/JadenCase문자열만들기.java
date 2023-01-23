package Programmers_Lvl2;

public class JadenCase문자열만들기 {

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean chk = true;
        for(char c : s.toCharArray()){
            if(chk){
                sb.append(String.valueOf(c).toUpperCase());
                chk = false;
            }else{
                sb.append(String.valueOf(c).toLowerCase());
            }
            if(c == ' ') chk = true;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = " CCC";
        System.out.println(solution(s));
    }

}
