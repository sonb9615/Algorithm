package Programmers_Lvl2;

import java.util.Stack;

public class 택배배달과수거하기 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIdx = n-1;
        int pikIdx = n-1;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> pickStack = new Stack<>();
        for(int i = 0; i < n; i++){
            stack.push(deliveries[i]);
            pickStack.push(pickups[i]);
        }
        while(!stack.empty() || !pickStack.isEmpty()){
            int go = cap;
            int dist = 0;
            while(!stack.isEmpty() && go > 0){
                int amount = stack.pop();
                if(amount == 0) {
                    --delIdx;
                    continue;
                }
                dist = Integer.max(dist, delIdx+1);
                if(amount > go) {
                    stack.push(amount - go);
                    break;
                }else{
                    go -= amount;
                    --delIdx;
                }
            }

            go = cap;
            while(!pickStack.isEmpty() && go > 0){
                int amount = pickStack.pop();
                if(amount == 0) {
                    --pikIdx;
                    continue;
                }
                dist = Integer.max(dist, pikIdx+1);
                if(amount > go) {
                    pickStack.push(amount - go);
                    break;
                }else{
                    go -= amount;
                    --pikIdx;
                }
            }
            answer += dist * 2L;
        }

        return answer;
    }


    public static void main(String[] args) {
        int cap = 50;
        int n = 2;
        int[] del = {0,0};
        int[] pic = {0,4};
        solution(cap,n,del,pic);
    }
}
