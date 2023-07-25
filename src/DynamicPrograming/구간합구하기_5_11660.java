package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 구간합구하기_5_11660 {

    static FastReader scan = new FastReader();
    static int N, M;
    static int[][] arr, order, dp;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                arr[i][j] = scan.nextInt();
            }
        }
        order = new int[M][4];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < 4; j++){
                order[i][j] = scan.nextInt();
            }
        }
    }

    static void pro(){
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < N+1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int x1 = order[i][0];
            int y1 = order[i][1];
            int x2 = order[i][2];
            int y2 = order[i][3];
            int answer = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
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
