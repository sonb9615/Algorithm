package DynamicPrograming;

import java.io.*;
import java.util.StringTokenizer;

public class 오르막수_11057 {

    public static void main(String[] args) {

        FastReader scan = new FastReader();
        int n = scan.nextInt();
        int[][] dy = new int[n+1][10];

        for(int i = 0; i < 10; i++){
            dy[1][i] = 1;
        }

        for(int i = 2; i < n+1; i++){
            for(int j = 0; j < 10; j++){
                for(int k = j; k > -1; k--){
                    dy[i][j] += dy[i-1][k];
                    dy[i][j] %= 10007;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 10; i++){
            ans += dy[n][i];
            ans %= 10007;
        }
        System.out.println(ans);
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
