package Programmers_Lvl2;

import java.util.Stack;

public class 괄호회전하기 {

    public static int solution(String s) {
        int answer = 0;
        int cnt = 0;
        while (cnt < s.length()){
            if(fn_check(s)){
                ++answer;
            }
            s = s.substring(1) + s.charAt(0);
            ++cnt;
        }
        return answer;
    }

    public static boolean fn_check(String trg){
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < trg.length(); i++){
            if(st.empty()){
                st.push(trg.charAt(i));
            }else{
                if(st.peek() == '[' && trg.charAt(i) == ']'){
                    st.pop();
                }else if(st.peek() == '{' && trg.charAt(i) == '}'){
                    st.pop();
                }else if(st.peek() == '(' && trg.charAt(i) == ')'){
                    st.pop();
                }else{
                    st.push(trg.charAt(i));
                }
            }
        }
        return st.size() == 0;
    }

    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }
}
