package Programmers_Lvl2;

public class 주식가격 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                ++answer[i];
                if(prices[i] > prices[j]) break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,3};
        solution(arr);
    }
}
