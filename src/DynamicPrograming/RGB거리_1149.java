package DynamicPrograming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리_1149 {

    static FastReader scan = new FastReader();
    static int n;
    static int[][] cost;
    static int[][] dy;

    static void input(){
        n = scan.nextInt();
        cost = new int[n][3];
        dy = new int[n][3];
        for(int i = 0; i < n; i++){
            cost[i][0] = scan.nextInt();
            cost[i][1] = scan.nextInt();
            cost[i][2] = scan.nextInt();
        }
    }

    static void pro(){
        dy[0][0] = cost[0][0];
        dy[0][1] = cost[0][1];
        dy[0][2] = cost[0][2];
        for(int i = 1; i < n; i++){
          dy[i][0] = Math.min(dy[i-1][1], dy[i-1][2]) + cost[i][0];
          dy[i][1] = Math.min(dy[i-1][0], dy[i-1][2]) + cost[i][1];
          dy[i][2] = Math.min(dy[i-1][0], dy[i-1][1]) + cost[i][2];
        }
        Arrays.sort(dy[n-1]);
        System.out.println(dy[n-1][0]);
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
