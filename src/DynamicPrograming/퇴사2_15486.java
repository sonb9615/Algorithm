package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 퇴사2_15486 {

    static FastReader scan = new FastReader();
    static int N;
    static int[][] arr;
    static int[] dp;
    static void input(){
        N = scan.nextInt();
        arr = new int[N+1][2];
        dp = new int[N+1];
        for(int i = 1; i < N+1; i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
    }

    static void pro(){
        int result = 0;
        for(int i = 1; i < N+1; i++){
            if(arr[i][0] + i - 1<= N) {
                dp[arr[i][0]+i -1] = Math.max(dp[arr[i][0] + i -1], result + arr[i][1]);
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
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
