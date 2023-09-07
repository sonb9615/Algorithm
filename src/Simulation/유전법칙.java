package Simulation;

import java.util.ArrayList;
import java.util.Stack;

public class 유전법칙 {

    public static String[] solution(int[][] queries) {

        String[] answer = new String[queries.length];
        for(int i = 0; i < queries.length; i++){
            Stack<Integer> st = new Stack<>();
            String parent = "Rr";
            int n = queries[i][0];
            int m = queries[i][1]-1;
            if(n == 1) {
                answer[i] = "Rr";
                continue;
            }
            while(n > 1){
                --n;
                st.push(m % 4);
                m /= 4;
            }

            while(!st.isEmpty()){
                int num = st.pop();
                if(parent .equals("Rr")){
                    if(num == 0) parent = "RR";
                    else if(num == 1 || num == 2) parent = "Rr";
                    else if(num == 3) parent = "rr";
                }else break;
            }

            answer[i] = parent;

        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] q = {{3,5}};
        solution(q);
    }
}
