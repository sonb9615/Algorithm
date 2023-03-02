package Programmers_Lvl2;

public class 숫자블록 {

    public static int[] solution(long begin, long end) {
        int[] answer = new int[Long.valueOf(end - begin + 1).intValue()];
        int idx = -1;
        for(int i = (int)begin; i < (int)end+1; i++){
            answer[++idx] = getBlock(i);
        }
        return answer;
    }

    public static int getBlock(int x){
        if(x == 1) return 0;
        int val = 1;
        int max = 10000000;
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                val = x/i;
                if(val <= max) break;
                else val = i;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        int [] ans = solution(100000014, 100000016);
//        int [] ans = solution(1,10);
        for(int x : ans){
            System.out.println(x);
        }
    }
}
