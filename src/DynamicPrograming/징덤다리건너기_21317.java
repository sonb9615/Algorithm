package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 징덤다리건너기_21317 {

    static FastReader scan = new FastReader();
    static int N, k;
    static int[][] jumpArr, dp;
    static boolean[] chk;

    static void input(){
        N = scan.nextInt();
        jumpArr = new int[N-1][2];
        for(int i = 0; i < N-1; i++){
            jumpArr[i][0] = scan.nextInt();
            jumpArr[i][1] = scan.nextInt();
        }
        chk = new boolean[N];
        dp = new int[N][2];
        k = scan.nextInt();
    }

    static void pro(){
        dp[0][0] = 0;
        dp[0][1] = 0;
        if(N >= 2){
            dp[1][0] = jumpArr[0][0];
            dp[1][1] = jumpArr[0][0];
        }
        if(N >= 3){
            dp[2][0] = Math.min(jumpArr[0][1], dp[1][0] + jumpArr[1][0]);
            dp[2][1] = Math.min(jumpArr[0][1], dp[1][0] + jumpArr[1][0]);
        }
        for(int i = 3; i < N; i++){
            dp[i][0] = Math.min(dp[i-1][0] + jumpArr[i-1][0], dp[i-2][0] + jumpArr[i-2][1]);
            dp[i][1] = Math.min(Math.min(dp[i-1][1] + jumpArr[i-1][0], dp[i-2][1] + jumpArr[i-2][1]), dp[i-3][0] + k);
        }
        System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
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
