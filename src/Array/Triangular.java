package Array;

import java.util.Arrays;

public class Triangular {

    public static int solution(int[] A) {
        int answer = 0;
        Arrays.sort(A);
        for(int i = 0; i < A.length - 2; i++){
            if(A[i] > 0 &&A[i] == A[i+1] && A[i+1] == A[i+2]){
                answer = 1;
                break;
            }
            if(A[i] + A[i+1] > A[i+2]
                    && A[i+1] + A[i+2] > A[i]
                    && A[i] + A[i+2] > A[i+1]){
                answer = 1;
                break;
            }
        }

        return  answer;
    }

    public static void main(String[] args) {

        int[] A = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        System.out.println(solution(A));
    }
}
