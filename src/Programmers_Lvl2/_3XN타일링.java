package Programmers_Lvl2;

public class _3XN타일링 {

    public int solution(int n) {
        long[] dy = new long[n+1];
        if(n%2 == 1) return 0;
        dy[2] = 3;
        dy[4] = 11;
        int mod = 1000000007;
        for(int i = 6; i <= n; i+=2){
            dy[i] = ((dy[i-2] * 4 % mod) - (dy[i-4] % mod) + mod) % mod;
        }
        return (int)dy[n];
    }
}
