package Programmers_Lvl1;

import java.util.HashMap;
import java.util.Map;

public class 소수만들기 {

    public static int solution(int[] nums) {
        int answer = 0;
        int a,b,c;
        for(int i = 0; i < nums.length; i++){
            a = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                b = nums[j];
                for(int k = j + 1; k< nums.length; k++){
                    c = nums[k];
                    int sum = a + b + c;
                    if(!chk_prime(sum)){
                        ++answer;
                    }
                }
            }
        }
        return answer;
    }

    public static boolean chk_prime(int n){
        boolean chk = false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
              chk = true;
              break;
            }
        }
        return chk;
    }

    public static void main(String[] args) {
        int[] num = {1,3,7,21};
        System.out.println(solution(num));
    }
}
