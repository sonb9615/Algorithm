package BinaraySearch;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long L = 1;
        long R = times[times.length-1] * (long)n;
        while(L <= R){
            long sum = 0;
            long mid = (L+R) / 2;
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
            }
            if(sum >= n){
                answer = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return answer;
    }
}
