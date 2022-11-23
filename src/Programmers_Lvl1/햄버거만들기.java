package Programmers_Lvl1;

import java.util.Stack;

public class 햄버거만들기 {

    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int num : ingredient){
            st.push(num);
            if(st.size() >= 4){
                if("1231".equals(st.get(st.size()-4).toString() + st.get(st.size()-3).toString()
                + st.get(st.size()-2).toString() + st.get(st.size()-1).toString())){
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                    ++answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ingredients = {1, 2, 1, 2, 3, 1, 3, 1, 1, 2, 3, 1};
        System.out.println(solution(ingredients));
    }


}
