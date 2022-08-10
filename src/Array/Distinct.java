package Array;

import java.util.Arrays;

public class Distinct {

    public static int solution(int[] A) {
        int answer = 1;
        if(A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        int oldNum = A[0];
        for(int a : A){
            if(oldNum != a){
                ++answer;
                oldNum = a;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] A = {};
        System.out.println(solution(A));
    }
}
