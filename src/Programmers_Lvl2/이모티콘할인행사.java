package Programmers_Lvl2;

import java.util.*;

public class 이모티콘할인행사 {

    static int[] percents = {10,20,30,40};
    static class Result{
        int userCnt;
        int sales;
        public Result(int _userCnt, int _sales){
            this.userCnt = _userCnt;
            this.sales = _sales;
        }
    }

    static PriorityQueue<Result> pq = new PriorityQueue<>(new Comparator<Result>() {
        @Override
        public int compare(Result o1, Result o2) {
            if(o1.userCnt > o2.userCnt) return -1;
            if(o1.userCnt == o2.userCnt && o1.sales > o2.sales) return -1;
            return 1;
        }
    });

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        Stack<Integer> st = new Stack<>();
        getUserAndSale(emoticons, users, st);
        Result rst = pq.peek();
        answer[0] = rst.userCnt;
        answer[1] = rst.sales;
        return answer;
    }

    public static void getUserAndSale(int[] emoticons, int[][] users, Stack<Integer> st){
        if(st.size() == emoticons.length){
            List<Integer> arr = Arrays.asList(st.toArray(new Integer[0]));
            calculate(arr, users, emoticons);
            return;
        }
        for(int i = 0; i < 4; i++){
            st.push(percents[i]);
            getUserAndSale(emoticons, users, st);
            st.pop();
        }
    }

    public static void calculate(List<Integer> arr, int[][] users, int[] emoticons){
        int sum = 0;
        int userCnt = 0;
        int[] userSumArr = new int[users.length];
        boolean[] chkUserCnt = new boolean[users.length];
        for(int i = 0; i < arr.size(); i++){
            int cost = emoticons[i] * (100 - arr.get(i)) / 100;
            for(int j = 0; j < users.length; j++){
                int per = users[j][0];
                int userSum = users[j][1];
                if(per > arr.get(i)) continue;
                if(chkUserCnt[j]) continue;
                userSumArr[j] += cost;
                sum += cost;
                if(userSumArr[j] >= userSum){
                    ++userCnt;
                    sum -= userSumArr[j];
                    chkUserCnt[j] = true;
                }
            }
        }

        pq.add(new Result(userCnt, sum));
    }

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        solution(users, emoticons);
    }
}
