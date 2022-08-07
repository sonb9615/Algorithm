package 스킬체크_1;

import java.util.Arrays;

public class Solution_1 {

    static int answer = 0;

    public static int solution(int[] nums) {

        int[] temp = new int[3];
        makeCombination(nums,3, temp, 0, 0);

        return answer;
    }

    private static void makeCombination(int[] arr,int r, int[] temp, int current, int start) {
        if (r == current) {
            if(isPrime(temp)){
                ++answer;
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeCombination(arr ,r, temp, current + 1, i + 1);
            }
        }
    }

    public static boolean isPrime(int[] num){
        int sum = 0;
        for(int n : num){
            sum += n;
        }
        for(int i = 2; i < sum; i++){
            if(sum % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] temp = new int[arr.length];

        makeCombination(arr,1, temp, 0, 0);
    }
}
