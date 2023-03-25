package Array;

import java.util.Arrays;

public class CyclicRotation {

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] answer = new int[A.length];
        if(A.length > 0){
            if(K > A.length){
                K = K % A.length;
            }
            if(K == 0){
                answer = A;
            }else{

                int idx = A.length - K;
                for(int i = idx ; i < A.length; i++){
                    answer[i - idx] = A[i];
                }
                for(int i = 0; i < idx; i++){
                    answer[i+K] = A[i];
                }
            }
        }else{
            answer = A;

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1,10};
        int K = 1;
        int[] a = solution(A,K);
        for(int x : a){
            System.out.println(x);
        }
    }
}
