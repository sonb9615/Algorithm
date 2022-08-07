package 스킬체크_1;

public class Solution_2 {

    public static double solution(int[] arr) {
        double answer = 0;
        for(int a : arr){
            answer += a;
        }
        answer = answer / arr.length;
        return answer;
    }

    public static void main(String[] args) {

    }
}
