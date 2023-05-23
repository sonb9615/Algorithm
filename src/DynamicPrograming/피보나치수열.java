package DynamicPrograming;

public class 피보나치수열 {

    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i < n+1; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
    }
}
