package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class _1로만들기_1463 {

    static FastReader scan = new FastReader();
    static int N;
    static int[] dp;
    static void input(){
        N = scan.nextInt();
        dp = new int[N+1];
    }

    static void pro(){
        dp[0] = 0;
        dp[1] = 0;
        if(N >= 2) dp[2] = 1;
        if(N >= 3) dp[3] = 1;
        for(int i = 4; i < N+1; i++){
            int x = Integer.MAX_VALUE;
            if(i % 2 == 0){
                x = Math.min(x, dp[i/2] + 1);
            }
            if(i % 3 == 0){
                x = Math.min(x, dp[i/3] + 1);
            }
            x = Math.min(x, dp[i-1] + 1);
            dp[i] = x;
        }
        System.out.println(dp[N]);
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
