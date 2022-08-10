package Stack_Queue;

import java.util.Stack;

public class Bracket {

    public static int solution(String S) {

        int answer = 1;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(st.empty()){
                st.push(S.charAt(i));
            }else{
                if(st.peek() == '('){
                    if (S.charAt(i) == ')') {
                        st.pop();
                    }else{
                        st.push(S.charAt(i));
                    }
                }else if(st.peek() == '{'){
                    if (S.charAt(i) == '}') {
                        st.pop();
                    }else{
                        st.push(S.charAt(i));
                    }
                }else if(st.peek() == '['){
                    if (S.charAt(i) == ']') {
                        st.pop();
                    }else{
                        st.push(S.charAt(i));
                    }
                }else{
                    answer = 0;
                    break;
                }
            }
        }

        if(!st.empty()){
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {

        String S = "";
        System.out.println(solution(S));
    }
}
