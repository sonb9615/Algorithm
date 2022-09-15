package Programmers_Lvl1;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {

    static Elem[] elem;
    static int idx;
    static class Elem implements Comparable<Elem>{
        String str;

        @Override
        public int compareTo(Elem other) {
            if(str.charAt(idx) == other.str.charAt(idx)){
                return str.compareTo(other.str);
            }
            return String.valueOf(str.charAt(idx)).compareTo(String.valueOf(other.str.charAt(idx)));
        }
    }



    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        idx = n;
        elem = new Elem[strings.length];
        for(int i = 0; i < strings.length; i++){
            elem[i] = new Elem();
            elem[i].str = strings[i];
        }
        Arrays.sort(elem);
        for(int i = 0; i < strings.length; i++){
            answer[i] = elem[i].str;
        }
        return answer;
    }

    public static void main(String[] args) {

        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        String[] result = solution(strings,n);
        for(String str : result){
            System.out.println(str);
        }
    }
}
