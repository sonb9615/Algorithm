package 완전탐색;

import java.util.ArrayList;

public class 모음사전 {

    public static ArrayList<String> arr;
    public static String[] words = {"A", "E", "I", "O", "U"};

    public static int solution(String word) {
        int answer = 0;
        arr = new ArrayList<>();
        createWord("", 0);
        for(String str : arr){
            if(str.equals(word)) break;
            ++answer;
        }
        return answer;
    }

    public static void createWord(String str, int depth){
        arr.add(str);
        if(depth == 5) return;
        for (String word : words) {
            createWord(str + word, depth + 1);
        }
    }

    public static void main(String[] args) {

    }
}
