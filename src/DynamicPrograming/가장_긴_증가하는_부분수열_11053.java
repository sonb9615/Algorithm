package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분수열_11053 {

    static FastReader scan = new FastReader();
    static int N;
    static int[] arr, dp;

    static void input(){
        N = scan.nextInt();
        arr = new int[N];
        dp = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void pro(){
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
            max = Integer.max(max, dp[i]);
        }
        System.out.println(max);
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
