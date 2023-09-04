package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 정수삼각형_1932 {

    static FastReader scan = new FastReader();
    static int N;
    static int[][] arr, dp;
    static void input(){
        N = scan.nextInt();
        arr = new int[N][N];
        dp = new int[N][N];
        int x = 0;
        for(int i = 0; i < N; i++){
            ++x;
            for(int j = 0; j < x; j++){
                arr[i][j] = scan.nextInt();
            }
        }
    }

    static void pro(){
        int ans = arr[0][0];
        dp[0][0] = arr[0][0];
        int x = 1;
        for(int i = 1; i < N; i++){
            ++x;
            for(int j = 0; j < x; j++){
                if(j == 0) dp[i][j] = dp[i-1][0] + arr[i][j];
                else {
                    dp[i][j] = Integer.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
                ans = Integer.max(dp[i][j], ans);
            }
        }
        System.out.println(ans);
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
