package DynamicPrograming;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 평범한배낭_12856 {

    static FastReader scan = new FastReader();
    static int N, K;
    static int[] W, V;

    static void input(){
        N = scan.nextInt();
        K = scan.nextInt();
        W = new int[N+1];
        V = new int[N+1];
        for(int i = 1; i < N+1; i++){
            W[i] = scan.nextInt();
            V[i] = scan.nextInt();
        }
    }

    static void pro(){
        int[][] dp = new int[N+1][K+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < K+1; j++){
                if(W[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
