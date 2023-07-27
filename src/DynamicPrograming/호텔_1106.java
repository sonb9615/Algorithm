package DynamicPrograming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호텔_1106 {

    static FastReader scan = new FastReader();
    static int C, N;
    static int[][] arr;
    static int[] dp;

    static void input(){
        C = scan.nextInt();
        N = scan.nextInt();
        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        dp = new int[C + 100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
    }

    static void pro(){
        for(int i = 0; i < N; i++){
            int cost = arr[i][0];
            int customer = arr[i][1];
            for(int j = customer; j < C+100; j++){
                if(dp[j-customer] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-customer] + cost);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = C; i < C + 100; i++){
            min = Math.min(min, dp[i]);
        }
        System.out.println(min);
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
