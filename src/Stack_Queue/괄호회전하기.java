package Stack_Queue;

import java.util.Stack;

public class 괄호회전하기 {
    public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = 0; i < s.length(); i++){
            Stack<Character> st = new Stack<>();
            for(int j = 0; j < sb.length(); j++){
                st.push(sb.charAt(j));
                if(st.size() < 2) continue;
                Character c = st.pop();
                if(st.peek() == '[' && c == ']') st.pop();
                else if(st.peek() == '{' && c == '}') st.pop();
                else if(st.peek() == '(' && c == ')') st.pop();
                else st.push(sb.charAt(j));
            }
            if(st.size() == 0) ++answer;
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "}]()[{";
        solution(str);
    }
}
