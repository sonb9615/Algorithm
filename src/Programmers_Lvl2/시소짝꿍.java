package Programmers_Lvl2;

public class 시소짝꿍 {

    public static long solution(int[] weights) {
        long answer = 0;
        long[] arr = new long[1001];
        for(int i = 0; i < weights.length; i++){
            ++arr[weights[i]];
        }
        for(int i = 100; i < 1001; i++){
            if(arr[i] == 0) continue;
            if(arr[i] > 2) answer += (arr[i] * (arr[i] - 1)) / 2;
            else if(arr[i] == 2) ++answer;
            int[] trgCmp = {i * 2, i * 3, i * 4};

            for(int j = i+1; j < 1001; j++){
                if(arr[j] == 0) continue;
                for(int x = 2; x < 5; x++){
                    int tmp = x * j;
                    if(trgCmp[0] == tmp || trgCmp[1] == tmp || trgCmp[2] == tmp){
                        answer += arr[j] * arr[i];
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] w = {100,100,100};
        System.out.println(solution(w));
    }
}
