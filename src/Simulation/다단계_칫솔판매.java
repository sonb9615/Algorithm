package Simulation;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔판매 {

    static Map<String, Integer> map;

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        map = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], i);
        }

        for(int i = 0; i < seller.length; i++){
            String s = seller[i];
            int profit = amount[i]*100;
            int idx = map.get(seller[i]);
            answer[idx] += profit - profit/10;
            if(!referral[idx].equals("-")){
                answer = distribution(map.get(referral[idx]), enroll, referral, answer, profit/10);
            }
        }

        return answer;
    }

    public static int[] distribution(int idx, String[] enroll, String[] referral ,int[] amount, int cost){
        if(map.containsKey(enroll[idx])){
            amount[idx] += cost - cost/10;
            if(map.containsKey(referral[idx]) && cost > 0){
                amount = distribution(map.get(referral[idx]), enroll, referral, amount, cost/10);
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        solution(enroll, referral, seller, amount);
    }
}
